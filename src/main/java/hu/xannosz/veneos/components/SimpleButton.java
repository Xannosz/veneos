package hu.xannosz.veneos.components;

import java.awt.Color;

import hu.xannosz.microtools.pack.Matrix;

public class SimpleButton extends Button {

	public SimpleButton(int x, int y, Color normalColor, Color clickedColor, Color enteredColor) {
		super(null, null, null);
		normal = new Matrix<>(x, y);
		for (int i = 0; i < x; i++) {
			for (int e = 0; e < y; e++) {
				normal.addItem(i, e, normalColor);
			}
		}
		clicked = new Matrix<>(x, y);
		for (int i = 0; i < x; i++) {
			for (int e = 0; e < y; e++) {
				clicked.addItem(i, e, clickedColor);
			}
		}
		entered = new Matrix<>(x, y);
		for (int i = 0; i < x; i++) {
			for (int e = 0; e < y; e++) {
				entered.addItem(i, e, enteredColor);
			}
		}
	}

}
