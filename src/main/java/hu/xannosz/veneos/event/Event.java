package hu.xannosz.veneos.event;

public abstract class Event {
	private boolean isStopped;
	private boolean isAltPressed;
	private boolean isAltGrPressed;
	private boolean isControlPressed;
	private boolean isShiftPressed;

	public Event() {
	}

	public Event(Event e) {
		isStopped = e.isStopped;
		isAltPressed = e.isAltPressed;
		isAltGrPressed = e.isAltGrPressed;
		isControlPressed = e.isControlPressed;
		isShiftPressed = e.isShiftPressed;
	}

	public boolean isStopped() {
		return isStopped;
	}

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	public boolean isAltPressed() {
		return isAltPressed;
	}

	public void setAltPressed(boolean isAltPressed) {
		this.isAltPressed = isAltPressed;
	}

	public boolean isAltGrPressed() {
		return isAltGrPressed;
	}

	public void setAltGrPressed(boolean isAltGrPressed) {
		this.isAltGrPressed = isAltGrPressed;
	}

	public boolean isControlPressed() {
		return isControlPressed;
	}

	public void setControlPressed(boolean isControlPressed) {
		this.isControlPressed = isControlPressed;
	}

	public boolean isShiftPressed() {
		return isShiftPressed;
	}

	public void setShiftPressed(boolean isShiftPressed) {
		this.isShiftPressed = isShiftPressed;
	}
}
