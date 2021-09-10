package hu.xannosz.veneos.core;

import hu.xannosz.veneos.core.handler.HttpHandler;
import hu.xannosz.veneos.trie.DefaultTryHttpHandler;
import hu.xannosz.veneos.trie.TryHandler;
import lombok.Data;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Data
public class VeneosServerConfig {

    public VeneosServerConfig(HttpHandler handler, int port) {
        this.handler = handler;
        this.port = port;
    }

    public VeneosServerConfig(TryHandler tryHandler, int port) {
        this.tryHandler = tryHandler;
        this.port = port;
        this.handler = new DefaultTryHttpHandler();
    }

    private HttpHandler handler;
    private TryHandler tryHandler;
    private String encoding = StandardCharsets.UTF_8.toString();
    private File keyStore;
    private String keyStorePassword;
    private int port;
}
