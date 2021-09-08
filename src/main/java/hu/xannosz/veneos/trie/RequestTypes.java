package hu.xannosz.veneos.trie;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestTypes {
    public static final String BUTTON_REQUEST = "buttonRequest";
    public static final String REFRESH_REQUEST = "refreshRequest";
    public static final String KEY_STROKE_REQUEST = "keyStrokeRequest";
    public static final String FORM_DATA_REQUEST = "formDataRequest";

    public static final String ON_START_WEB_SOCKET_REQUEST = "onStartWebSocketRequest";
    public static final String ON_OPEN_WEB_SOCKET_REQUEST = "onOpenWebSocketRequest";
    public static final String ON_CLOSE_WEB_SOCKET_REQUEST = "onCloseWebSocketRequest";
    public static final String ON_MESSAGE_WEB_SOCKET_REQUEST = "onMessageWebSocketRequest";
    public static final String ON_ERROR_WEB_SOCKET_REQUEST = "onErrorWebSocketRequest";
}
