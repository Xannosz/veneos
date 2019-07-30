package hu.xannosz.veneos.next;

import java.util.Map;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.HttpHandler;
import hu.xannosz.veneos.core.Page;
import hu.xannosz.veneos.core.html.A;
import hu.xannosz.veneos.core.html.Nav;
import lombok.Setter;

public class NextHandler implements HttpHandler {

	@Setter
	private Page failPage;
	private Frame frame;

	public NextHandler(Frame frame) {
		this.frame = frame;
	}

	@Override
	public Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI,
			Map<String, String> requestMap) {
		try {
			NextMap map = new NextMap();
			map.parseMap(requestURI);
			map.addBasics(requestMethod, requestMap);
			map = frame.run(map);
			Page page = new Page();
			page.setTitle(frame.getTitle());
			Nav nav = new Nav();
			for (String act : frame.getActivitiesTitles()) {
				if (act.equals(frame.getActiveActivityTitle())) {
					nav.add(new A("#", act));
				} else {
					nav.add(new A(map.getMap(act), act));
				}
			}
			page.addComponent(nav);
			page.addComponent(frame.getActivityPanel());
			return null;
		} catch (Exception e) {
			return new Douplet<Integer, Page>(404, failPage);
		}
	}
}
