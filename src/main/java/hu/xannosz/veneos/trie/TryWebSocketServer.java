package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.Json;
import hu.xannosz.veneos.util.RequestBodyUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class TryWebSocketServer extends WebSocketServer {

    private final Map<WebSocket, String> webSocketIds = new HashMap<>();
    private final TryHandler tryHandler;

    public TryWebSocketServer(int port, TryHandler tryHandler) {
        super(new InetSocketAddress(port));
        this.tryHandler = tryHandler;
    }

    public void sendRefresh(String sessionId) {
        for (Map.Entry<WebSocket, String> webSocketId : webSocketIds.entrySet()) {
            if (webSocketId.getValue().equals(sessionId)) {
                webSocketId.getKey().send("Refresh");
            }
        }
    }

    @Override
    public void onOpen(WebSocket connection, ClientHandshake handshake) {
        webSocketIds.put(connection, "");
        tryHandler.handleRequest(RequestBodyUtil.createOnOpen(connection, handshake));
    }

    @Override
    public void onClose(WebSocket connection, int code, String reason, boolean remote) {
        tryHandler.handleRequest(RequestBodyUtil.createOnClose(connection, webSocketIds.get(connection), code, reason, remote));
        webSocketIds.remove(connection);
    }

    @Override
    public void onMessage(WebSocket connection, String message) {
        if (webSocketIds.get(connection).equals("")) {
            HelloMessage helloMessage = Json.castObjectToSpecificClass(message, HelloMessage.class);
            if (helloMessage != null) {
                webSocketIds.put(connection, helloMessage.getSessionId());
            }
        }
        tryHandler.handleRequest(RequestBodyUtil.createOnMessage(connection, webSocketIds.get(connection), message));
    }

    @Override
    public void onError(WebSocket connection, Exception ex) {
        tryHandler.handleRequest(RequestBodyUtil.createOnError(connection, webSocketIds.get(connection), ex));
    }

    @Override
    public void onStart() {
        tryHandler.handleRequest(RequestBodyUtil.createOnStart());
    }

    @Data
    @NoArgsConstructor
    private static class HelloMessage {
        private String sessionId;
    }
}
