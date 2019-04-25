package hu.xannosz.veneos.outputs;

import java.awt.Color;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.microtools.pack.Matrix;
import hu.xannosz.microtools.pack.Quatlet;
import hu.xannosz.veneos.components.Component;
import hu.xannosz.veneos.components.Panel;
import hu.xannosz.veneos.event.Event;

public class Frame {
	Panel panel;
	private Douplet<Integer, Integer> size;

	public Frame(int x, int y) {
		panel = new Panel(x, y);
		this.size = new Douplet<Integer, Integer>(x, y);
	}

	public Matrix<Color> draw() {
		return panel.draw();
	}

	public void runEvent(Event e) {
		panel.addEvent(e);
	}

	public void addComponent(Component p, Quatlet<Integer, Integer, Integer, Integer> pos) {
		panel.addComponent(p, pos);
	}

	public Douplet<Integer, Integer> getSize() {
		return size;
	}
}
