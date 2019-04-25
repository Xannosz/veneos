package hu.xannosz.veneos.components;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.microtools.pack.Matrix;
import hu.xannosz.microtools.pack.Quatlet;
import hu.xannosz.veneos.event.Event;
import hu.xannosz.veneos.event.KeyEvent;
import hu.xannosz.veneos.event.MouseEvent;
import hu.xannosz.veneos.event.MouseEventType;
import hu.xannosz.veneos.event.TickEvent;

public class Panel extends Component {

	private List<Component> panelList = new ArrayList<>();
	private List<Quatlet<Integer, Integer, Integer, Integer>> panelPosList = new ArrayList<>();
	private Matrix<Color> picture;
	private Douplet<Integer, Integer> lastMousePos = new Douplet<Integer, Integer>(0, 0);
	protected Matrix<Color> backGround;

	public Panel(int x, int y) {
		picture = new Matrix<>(x, y);
		backGround = new Matrix<>(x, y);
	}

	public void addComponent(Component p, Quatlet<Integer, Integer, Integer, Integer> pos) {
		panelList.add(p);
		panelPosList.add(pos);
	}

	@Override
	public Matrix<Color> draw() {
		int i = 0;

		if (!reDraw) {
			for (; i < panelList.size(); i++) {
				if (panelList.get(i).reDraw) {
					break;
				}
			}
		} else {
			picture = backGround;
		}

		for (; i < panelList.size(); i++) {
			drawComponent(i);
		}

		reDraw = false;

		return picture;
	}

	@Override
	public void runEvent(Event e) {

	}

	@Override
	public void addEvent(Event e) {
		if (e instanceof KeyEvent) {
			for (Component component : panelList) {
				component.addEvent(e);
			}
			if (active) {
				runEvent(e);
			}
		} else if (e instanceof TickEvent) {
			for (Component component : panelList) {
				component.addEvent(e);
			}
			runEvent(e);
		} else if (e instanceof MouseEvent) {
			Douplet<Integer, Integer> pos = ((MouseEvent) e).getPos();
			for (int i = panelList.size() - 1; i >= 0; i--) {
				if ((!e.isStopped()) && isInRange(pos, panelPosList.get(i))) {
					if (!isInRange(lastMousePos, panelPosList.get(i))) {
						MouseEvent ev = new MouseEvent((MouseEvent) e);
						ev.setPos(new Douplet<Integer, Integer>(pos.getFirst() - panelPosList.get(i).getFirst(),
								pos.getSecond() - panelPosList.get(i).getSecond()));
						ev.setEventType(MouseEventType.ENTER);
						panelList.get(i).addEvent(ev);
					}
					((MouseEvent) e)
							.setPos(new Douplet<Integer, Integer>(pos.getFirst() - panelPosList.get(i).getFirst(),
									pos.getSecond() - panelPosList.get(i).getSecond()));
					panelList.get(i).addEvent(e);
				} else if (!e.isStopped() && isInRange(lastMousePos, panelPosList.get(i))) {
					MouseEvent ev = new MouseEvent((MouseEvent) e);
					ev.setPos(new Douplet<Integer, Integer>(pos.getFirst() - panelPosList.get(i).getFirst(),
							pos.getSecond() - panelPosList.get(i).getSecond()));
					ev.setEventType(MouseEventType.EXIT);
					panelList.get(i).addEvent(ev);
				}
			}
			((MouseEvent) e).setPos(pos);
			if (!e.isStopped()) {
				runEvent(e);
				e.setStopped(stopEvent);
			}
			lastMousePos = pos;
		}
	}

	private boolean isInRange(Douplet<Integer, Integer> pos, Quatlet<Integer, Integer, Integer, Integer> range) {
		return pos.getFirst() >= range.getFirst() && pos.getSecond() >= range.getSecond()
				&& pos.getFirst() <= range.getThird() && pos.getSecond() <= range.getFourth();
	}

	private void drawComponent(int p) {
		Matrix<Color> pic = panelList.get(p).draw();
		for (int i = 0; i < panelPosList.get(p).getThird(); i++) {
			for (int e = 0; e < panelPosList.get(p).getFourth(); e++) {
				if (pic.getItem(i, e) != null) {
					picture.addItem(i + panelPosList.get(p).getFirst(), e + panelPosList.get(p).getSecond(),
							pic.getItem(i, e));
				}
			}
		}
	}
}
