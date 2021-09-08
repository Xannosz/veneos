package hu.xannosz.veneos.util;

import hu.xannosz.veneos.trie.RequestBody;
import hu.xannosz.veneos.trie.RequestTypes;
import lombok.experimental.UtilityClass;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class RequestBodyUtil {

    public static RequestBody createOnOpen(WebSocket connection, ClientHandshake handshake) {
        RequestBody requestBody = new RequestBody();
        requestBody.setRequestType(RequestTypes.ON_OPEN_WEB_SOCKET_REQUEST);
        Map<String, Object> additionalParams = new HashMap<>();
        additionalParams.put("connection", connection);
        additionalParams.put("handshake", handshake);
        requestBody.setAdditionalParams(additionalParams);
        return requestBody;
    }

    public static RequestBody createOnClose(WebSocket connection, String sessionId, int code, String reason, boolean remote) {
        RequestBody requestBody = new RequestBody();
        requestBody.setRequestType(RequestTypes.ON_CLOSE_WEB_SOCKET_REQUEST);
        requestBody.setSessionId(sessionId);
        Map<String, Object> additionalParams = new HashMap<>();
        additionalParams.put("connection", connection);
        additionalParams.put("code", code);
        additionalParams.put("reason", reason);
        additionalParams.put("remote", remote);
        requestBody.setAdditionalParams(additionalParams);
        return requestBody;
    }

    public static RequestBody createOnMessage(WebSocket connection, String sessionId, String message) {
        RequestBody requestBody = new RequestBody();
        requestBody.setRequestType(RequestTypes.ON_MESSAGE_WEB_SOCKET_REQUEST);
        requestBody.setSessionId(sessionId);
        Map<String, Object> additionalParams = new HashMap<>();
        additionalParams.put("connection", connection);
        additionalParams.put("message", message);
        requestBody.setAdditionalParams(additionalParams);
        return requestBody;
    }

    public static RequestBody createOnError(WebSocket connection, String sessionId, Exception exception) {
        RequestBody requestBody = new RequestBody();
        requestBody.setRequestType(RequestTypes.ON_ERROR_WEB_SOCKET_REQUEST);
        requestBody.setSessionId(sessionId);
        Map<String, Object> additionalParams = new HashMap<>();
        additionalParams.put("connection", connection);
        additionalParams.put("exception", exception);
        requestBody.setAdditionalParams(additionalParams);
        return requestBody;
    }

    public static RequestBody createOnStart() {
        RequestBody requestBody = new RequestBody();
        requestBody.setRequestType(RequestTypes.ON_START_WEB_SOCKET_REQUEST);
        return requestBody;
    }
}
