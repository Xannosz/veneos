package hu.xannosz.veneos.core.handler;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.html.structure.Page;

import java.util.Map;

public interface HttpHandler {
    Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI,
                                       Map<String, String> requestMap);

    enum RequestMethod {
        GET, POST
    }
}
