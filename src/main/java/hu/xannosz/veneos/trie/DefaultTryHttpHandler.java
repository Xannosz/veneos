package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.handler.HttpHandler;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.util.Scripts;

import java.util.Map;

public class DefaultTryHttpHandler implements HttpHandler {
    @Override
    public Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI, Map<String, String> requestMap) {
        Page page = new Page();

        page.setTitle("title");
        page.addScript(Scripts.getCookieScript() + "\n" + Scripts.getStarterScript());

        return new Douplet<>(200, page);
    }
}
