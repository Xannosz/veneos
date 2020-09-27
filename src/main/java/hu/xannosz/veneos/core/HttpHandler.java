package hu.xannosz.veneos.core;

import hu.xannosz.microtools.pack.Douplet;

import java.util.Map;

public interface HttpHandler {
    Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI,
                                       Map<String, String> requestMap);

    enum RequestMethod {
        GET, POST
    }
}
