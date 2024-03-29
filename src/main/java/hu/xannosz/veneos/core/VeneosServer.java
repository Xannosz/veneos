package hu.xannosz.veneos.core;

import com.sun.net.httpserver.*;
import hu.xannosz.microtools.Json;
import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.css.Theme;
import hu.xannosz.veneos.core.handler.FileContainer;
import hu.xannosz.veneos.core.handler.HttpHandler.RequestMethod;
import hu.xannosz.veneos.core.handler.ThemeHandler;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.trie.RequestBody;
import hu.xannosz.veneos.trie.ResponseBody;
import hu.xannosz.veneos.trie.TryHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@SuppressWarnings("restriction")
public class VeneosServer {

    private hu.xannosz.veneos.core.handler.HttpHandler handler;
    private TryHandler tryHandler;
    @Getter
    private String encoding;
    private File keyStore;
    private String keyStorePassword;

    public void createServer(VeneosServerConfig veneosServerConfig) {
        handler = veneosServerConfig.getHandler();
        tryHandler = veneosServerConfig.getTryHandler();
        encoding = veneosServerConfig.getEncoding();
        keyStore = veneosServerConfig.getKeyStore();
        keyStorePassword = veneosServerConfig.getKeyStorePassword();

        HttpServer server;
        try {
            if (keyStorePassword != null) {
                server = HttpsServer.create(new InetSocketAddress(veneosServerConfig.getPort()), 0);
                createSSLContext((HttpsServer) server);
            } else {
                server = HttpServer.create(new InetSocketAddress(veneosServerConfig.getPort()), 0);
            }
            server.createContext("/", new MainHandler());
            server.createContext("/files", new FileHandler());
            server.createContext("/css", new CSSHandler());
            server.createContext("/internal", new InternalHandler());
            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            log.error("Exception during server creation.", e);
        }
    }

    private void createSSLContext(HttpsServer httpsServer) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        if (keyStore == null || !keyStore.exists()) {
            log.error("KeyStore " + keyStore + " doesn't exists.");
        }

        // initialise the keystore
        char[] password = keyStorePassword.toCharArray();
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(keyStore), password);

        // set up the key manager factory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, password);

        // set up the trust manager factory
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);

        // set up the HTTPS context and parameters
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
            public void configure(HttpsParameters params) {
                try {
                    // initialise the SSL context
                    SSLContext context = getSSLContext();
                    SSLEngine engine = context.createSSLEngine();
                    params.setNeedClientAuth(false);
                    params.setCipherSuites(engine.getEnabledCipherSuites());
                    params.setProtocols(engine.getEnabledProtocols());

                    // Set the SSL parameters
                    SSLParameters sslParameters = context.getSupportedSSLParameters();
                    params.setSSLParameters(sslParameters);
                } catch (Exception ex) {
                    log.error("Failed to create HTTPS port.", ex);
                }
            }
        });
    }

    public class MainHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            Douplet<Integer, Page> response = handler.getResponse(
                    t.getRequestMethod().equals("GET") ? RequestMethod.GET : RequestMethod.POST,
                    t.getRequestURI().getPath(), getRequestMap(t.getRequestBody()));

            response.getSecond().setCharset(encoding);
            String syntax = "";
            try {
                syntax = response.getSecond().getSyntax();
            } catch (Exception e) {
                log.error("Exception during response creation.", e);
            }
            byte[] responseSyntax = syntax.getBytes(encoding);
            t.sendResponseHeaders(response.getFirst(), responseSyntax.length);
            OutputStream os = t.getResponseBody();
            os.write(responseSyntax);
            os.flush();
            os.close();
        }

        private Map<String, String> getRequestMap(InputStream requestBody) {
            StringWriter writer = new StringWriter();
            Map<String, String> result = new HashMap<>();

            try {
                IOUtils.copy(requestBody, writer, encoding);
            } catch (IOException e) {
                log.error("Exception during request body conversation.", e);
            }

            for (String field : writer.toString().split("&")) {
                String[] fields = field.split("=");
                if (fields.length == 1) {
                    result.put(characterRecombinator(fields[0]), "");
                } else if (fields.length == 2) {
                    result.put(characterRecombinator(fields[0]), characterRecombinator(fields[1]));
                }
            }

            return result;
        }

        private String characterRecombinator(String input) {
            try {
                return URLDecoder.decode(input, encoding);
            } catch (UnsupportedEncodingException e) {
                log.error("Exception during character decoding.", e);
                return input;
            }
        }
    }

    public class CSSHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String[] tags = t.getRequestURI().getPath().split("/");
            String id = tags[tags.length - 1];
            Theme theme = ThemeHandler.getTheme(id);
            Douplet<Integer, String> response;
            if (theme != null) {
                response = new Douplet<>(200, theme.getSyntax());
            } else {
                response = new Douplet<>(404, id + " theme not found.");
            }
            byte[] responseSyntax = response.getSecond().getBytes(encoding);
            t.sendResponseHeaders(response.getFirst(), responseSyntax.length);
            OutputStream os = t.getResponseBody();
            os.write(responseSyntax);
            os.flush();
            os.close();
        }
    }

    public static class FileHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String[] tags = t.getRequestURI().getPath().split("/", 3);
            String id = tags[tags.length - 1];
            Douplet<String, File> fileData = FileContainer.getFile(id);

            Headers h = t.getResponseHeaders();
            h.add("Content-Type", fileData.getFirst());

            File file = fileData.getSecond();
            byte[] bytearray = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            //noinspection ResultOfMethodCallIgnored
            bis.read(bytearray, 0, bytearray.length);

            t.sendResponseHeaders(200, file.length());
            OutputStream os = t.getResponseBody();
            os.write(bytearray, 0, bytearray.length);
            os.close();
            bis.close();
        }
    }

    public class InternalHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String stringRequestBody = new BufferedReader(
                    new InputStreamReader(t.getRequestBody(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            InternalRequestBody internalRequestBody = Json.readData(stringRequestBody, InternalRequestBody.class);

            RequestBody requestBody = new RequestBody();
            requestBody.setRequestType(internalRequestBody.getRequestType());
            requestBody.setSessionId(internalRequestBody.getSessionId());
            requestBody.setEventId(internalRequestBody.getEventId());
            requestBody.setAdditionalParams(new HashMap<>());
            requestBody.getAdditionalParams().putAll(
                    Json.readData(
                            URLDecoder.decode(internalRequestBody.getExtraParams(),
                                    StandardCharsets.UTF_8.toString()),
                            Map.class));
            requestBody.getAdditionalParams().putAll(internalRequestBody.getAdditionalParams());

            ResponseBody responseBody = tryHandler.handleRequest(requestBody);

            byte[] responseSyntax = Json.writeData(responseBody).getBytes(encoding);
            t.sendResponseHeaders(200, responseSyntax.length);
            OutputStream os = t.getResponseBody();
            os.write(responseSyntax);
            os.flush();
            os.close();
        }

        private class InternalRequestBody extends RequestBody {
            @Getter
            private String extraParams;
        }
    }
}