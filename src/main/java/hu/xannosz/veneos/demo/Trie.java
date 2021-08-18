package hu.xannosz.veneos.demo;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.handler.HttpHandler;
import hu.xannosz.veneos.core.html.box.Div;
import hu.xannosz.veneos.core.html.str.P;
import hu.xannosz.veneos.core.html.str.StringModifiers;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.trie.RequestBody;
import hu.xannosz.veneos.trie.TryButton;
import hu.xannosz.veneos.trie.TryHandler;

import java.util.Map;

public class Trie implements TryHandler, HttpHandler {

    private static final String TOKEN = "tokenId";

    public static void main(String[] args) {
        VeneosServer server = new VeneosServer();
        server.createServer(8000);
        Trie trie = new Trie();
        server.setTryHandler(trie);
        server.setHandler(trie);
    }

    private Div component = new Div();

    @Override
    public Douplet<Integer, Page> handleRequest(String id, RequestBody body) {
        component = new Div();
        component.add("ID: " + id + StringModifiers.BR);
        component.add("RequestBody: " + body);

        Page normal = new Page();
        normal.addComponent(component);
        return new Douplet<>(200, normal);
    }

    @Override
    public Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI, Map<String, String> requestMap) {
        Page normal = new Page();
        normal.addComponent(new P("URL: " + requestURI));
        normal.addComponent(new TryButton(TOKEN, "Send token"));
        normal.addComponent(new P("Component: "));
        normal.addComponent(component);
        return new Douplet<>(200, normal);
    }
}
