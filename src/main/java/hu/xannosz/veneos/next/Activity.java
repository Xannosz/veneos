package hu.xannosz.veneos.next;

import java.util.ArrayList;
import java.util.List;

import hu.xannosz.veneos.core.html.Main;
import hu.xannosz.veneos.next.panel.Panel;
import lombok.Getter;
import lombok.Setter;

public class Activity {

	@Getter
	@Setter
	private String title;
	private List<Panel> panels = new ArrayList<>();

	public void add(Panel panel) {
		panels.add(panel);
	}

	public NextMap run(NextMap map) {
		return null;
	}

	public Main getPanel() {
		Main main = new Main();
		for (Panel p : panels) {
			main.add(p.getComponent());
		}
		return main;
	}
}
