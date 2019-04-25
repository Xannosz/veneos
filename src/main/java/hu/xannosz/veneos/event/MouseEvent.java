package hu.xannosz.veneos.event;

import hu.xannosz.microtools.pack.Douplet;

public class MouseEvent extends Event {
	private Douplet<Integer, Integer> pos;
	private MouseButtonType button;
	private int clickCount;
	private MouseEventType type;
	
	public MouseEvent() {
	}

	public MouseEvent(MouseEvent e) {
		super(e);
		pos=e.pos;
		button=e.button;
		clickCount=e.clickCount;
		type=e.type;
	}

	public Douplet<Integer, Integer> getPos() {
		return pos;
	}

	public void setPos(Douplet<Integer, Integer> pos) {
		this.pos = pos;
	}

	public MouseButtonType getButton() {
		return button;
	}

	public void setButton(MouseButtonType button) {
		this.button = button;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public void setEventType(MouseEventType type) {
		this.type = type;
	}

	public MouseEventType getEventType() {
		return type;
	}

	@Override
	public String toString() {
		return "MouseEvent [pos=" + pos + ", button=" + button + ", clickCount=" + clickCount + ", type=" + type + "]";
	}
}
