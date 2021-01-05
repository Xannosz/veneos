package hu.xannosz.veneos.demo;

import hu.xannosz.microtools.FileResourcesUtils;
import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.handler.FileContainer;
import hu.xannosz.veneos.core.handler.HttpHandler;
import hu.xannosz.veneos.core.html.box.Main;
import hu.xannosz.veneos.core.html.box.Nav;
import hu.xannosz.veneos.core.html.media.Img;
import hu.xannosz.veneos.core.html.str.A;
import hu.xannosz.veneos.core.html.str.P;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.core.html.table.Table;
import hu.xannosz.veneos.next.*;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class Veneos implements HttpHandler {

    public static void main(String[] args) throws FileNotFoundException {
        VeneosServer server = new VeneosServer();
        server.createServer(8000);
        server.setHandler(new Veneos());
    }

    private final Page normal = new Page();
    private final Page fields = new Page();
    private final Page high = new Page();
    private final Page error = new Page();

    public Veneos() {
        FileContainer.addFile("kep1.png",
                FileResourcesUtils.getFileFromResourceAsFile("kep.png"));
        FileContainer.addFile("kep2",
                FileResourcesUtils.getFileFromResourceAsFile("kep.png"));

        normal.setTitle("Normal");
        normal.addComponent(getNav("Normal"));
        normal.addComponent(new Main());
        normal.addComponent(new JsonDisplay(new JSONObject("{" +
                "\"height\" : 6.2," +
                "        \"width\" : true," +
                "        \"length\" : \"9.1\"," +
                "        \"color\" : {" +
                "            \"r\" : 255," +
                "            \"g\" : 200," +
                "            \"b\" : 10" +
                "        }" +
                "    }"), 3, normal));
        normal.addComponent(new CopyButton((new Img("/files/kep2")).setHeight("20px").setWidth("30px"), normal, "copied text"));
        normal.addComponent((new Img("/files/kep1.png")).setHeight("10px").setWidth("20px"));
        normal.addComponent(new Table());

        fields.setTitle("Fields");
        fields.addComponent(getNav("Fields"));
        fields.addComponent(new Main());
        fields.addComponent(new ScrollUpButton("Top", new ButtonPosition("20px", "10px"), fields));
        for (int i = 0; i < 10000; i++) {
            fields.addComponent(new P("S"));
        }

        high.setTitle("High");
        high.addComponent(getNav("High"));
        high.addComponent(new Main());
        high.setAutoRefresh(3);

        error.setTitle("Error");
        error.addComponent(new P("Wrong Site!"));
    }

    private Nav getNav(String site) {
        Nav nav = new Nav();
        if (site.equals("Normal")) {
            nav.add(new A("#", "Normal"));
        } else {
            nav.add(new A("normal", "Normal"));
        }
        if (site.equals("Fields")) {
            nav.add(new A("#", "Fields"));
        } else {
            nav.add(new A("fields", "Fields"));
        }
        if (site.equals("High")) {
            nav.add(new A("#", "High"));
        } else {
            nav.add(new A("high", "High"));
        }
        return nav;
    }

    @Override
    public Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI,
                                              Map<String, String> requestMap) {
        switch (requestURI) {
            case "/":
            case "/normal":
                return new Douplet<>(200, normal);
            case "/fields":
                return new Douplet<>(200, fields);
            case "/high":
                return new Douplet<>(200, high);
            case "/login":
                return new Douplet<>(200, new Login("/log", "Belep", "User:", "PWD:"));
            case "/log":
                System.out.println("##:" + requestMap);
                Page page = new Page();
                page.addComponent(new P("lorum ipsum"));
                page.addComponent(new Redirect("/normal", 5000, page));
                return new Douplet<>(200, page);
            case "/default":
                return new Douplet<>(200, DefaultHtmlPage.createDefaultHtmlPage());
            default:
                return new Douplet<>(404, error);
        }

    }
}
