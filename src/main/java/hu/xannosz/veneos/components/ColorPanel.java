package hu.xannosz.veneos.components;

import java.awt.Color;

public class ColorPanel extends Panel {
	public ColorPanel(Color c, int w, int h) {
		super(w,h);
		for (int i = 0; i < w; i++) {
			for (int e = 0; e < h; e++) {
				backGround.addItem(i, e, c);
			}
		}
		setReDraw();
	}
}
