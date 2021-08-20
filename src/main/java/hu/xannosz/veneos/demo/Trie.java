package hu.xannosz.veneos.demo;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.core.html.box.Div;
import hu.xannosz.veneos.core.html.str.P;
import hu.xannosz.veneos.core.html.str.StringModifiers;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.trie.*;

public class Trie implements TryHandler {

    private static final String TOKEN = "tokenId";

    public static void main(String[] args) {
        VeneosServer server = new VeneosServer();
        server.createServer(8000);
        Trie trie = new Trie();
        server.setTryHandler(trie);
        server.setHandler(new DefaultTryHttpHandler());
    }

    private final HtmlClass clazz = new HtmlClass();

    @Override
    public ResponseBody handleRequest(RequestBody body) {
        System.out.println("###" + body);
        Div component = new Div();
        component.add("ID: " + body.getSessionId() + StringModifiers.BR);
        component.add("RequestBody: " + body);

        Page normal = new Page();
        normal.addComponent(component);

        return new ResponseBody(new ResponseBody.ComponentStruct(clazz, component));
    }

    public Douplet<Integer, Page> getResponse() {
        Page normal = new Page();
        Div component = new Div();
        normal.addComponent(new TryButton(TOKEN, "Send token"));
        normal.addComponent(new P("Component: "));
        normal.addComponent(component.addClass(clazz));
        return new Douplet<>(200, normal);
    }
}
