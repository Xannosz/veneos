package hu.xannosz.veneos.components;

import java.awt.Color;

import hu.xannosz.microtools.pack.Matrix;
import hu.xannosz.veneos.event.Event;
import hu.xannosz.veneos.event.KeyEvent;
import hu.xannosz.veneos.event.TickEvent;

public abstract class Component {

	private static int lastID = -1;

	protected boolean active;
	protected boolean stopEvent;
	protected boolean reDraw;
	private int id;

	protected Component() {
		lastID++;
		id = lastID;
	}

	public abstract Matrix<Color> draw();

	public void addEvent(Event e) {
		if (e instanceof KeyEvent) {
			if (active) {
				runEvent(e);
			}
		} else if (e instanceof TickEvent) {
			runEvent(e);
		} else {
			if (!e.isStopped()) {
				runEvent(e);
				e.setStopped(stopEvent);
			}
		}
	}

	public abstract void runEvent(Event e);

	public void setReDraw() {
		reDraw = true;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isStopEvent() {
		return stopEvent;
	}

	public void setStopEvent(boolean stopEvent) {
		this.stopEvent = stopEvent;
	}

	public int getID() {
		return id;
	}
}
