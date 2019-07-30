package hu.xannosz.veneos.next;

import java.util.ArrayList;
import java.util.List;

import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.html.Main;
import lombok.Getter;
import lombok.Setter;

public class Frame {
	private VeneosServer veneosServer = new VeneosServer();
	private NextHandler handler = new NextHandler(this);
	private List<Activity> activities = new ArrayList<>();
	@Getter
	private String activeActivityTitle;
	@Getter
	@Setter
	private String title;

	public Frame(int port) {
		veneosServer.setHandler(handler);
		veneosServer.createServer(port);
	}

	public NextMap run(NextMap map) {
		try {
			return activities.stream().filter(act -> act.getTitle().equals(activeActivityTitle)).findFirst().get()
					.run(map);
		} finally {
			activeActivityTitle = map.get(NextMap.ACTIVITY_TITLE);
		}
	}

	public String[] getActivitiesTitles() {
		return activities.stream().map(Activity::getTitle).toArray(String[]::new);
	}

	public Main getActivityPanel() {
		return activities.stream().filter(act -> act.getTitle().equals(activeActivityTitle)).findFirst().get()
				.getPanel();
	}
	
	public void addActivity(Activity activity){
		activities.add(activity);
	}
}
