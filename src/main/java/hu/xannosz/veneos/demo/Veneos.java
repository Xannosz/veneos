package hu.xannosz.veneos.demo;

import java.util.Map;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.HttpHandler;
import hu.xannosz.veneos.core.Page;
import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.html.A;
import hu.xannosz.veneos.core.html.Main;
import hu.xannosz.veneos.core.html.Nav;
import hu.xannosz.veneos.core.html.P;

public class Veneos implements HttpHandler {

	public static void main(String[] args) {
		VeneosServer server = new VeneosServer();
		server.createServer(8000);
		server.setHandler(new Veneos());
	}

	private Page normal = new Page();
	private Page fields = new Page();
	private Page high = new Page();
	private Page error = new Page();

	public Veneos() {
		normal.setTitle("Normal");
		normal.addComponent(getNav("Normal"));
		normal.addComponent(new Main());

		fields.setTitle("Fields");
		fields.addComponent(getNav("Fields"));
		fields.addComponent(new Main());

		high.setTitle("High");
		high.addComponent(getNav("High"));
		high.addComponent(new Main());

		error.setTitle("Error");
		error.addComponent(new P("Wrong Site!"));
	}

	private Nav getNav(String site) {
		Nav nav = new Nav();
		if(site.equals("Normal")){
			nav.add(new A("#", "Normal"));
		}else{
			nav.add(new A("normal", "Normal"));
		}
		if(site.equals("Fields")){
			nav.add(new A("#", "Fields"));
		}else{
			nav.add(new A("fields", "Fields"));
		}
		if(site.equals("High")){
			nav.add(new A("#", "High"));
		}else{
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
			return new Douplet<Integer, Page>(200, normal);
		case "/fields":
			return new Douplet<Integer, Page>(200, fields);
		case "/high":
			return new Douplet<Integer, Page>(200, high);
		default:
			return new Douplet<Integer, Page>(404, error);
		}

	}
}
