package hu.xannosz.veneos.components;

import java.awt.Color;
import java.util.function.Consumer;

import hu.xannosz.microtools.pack.Matrix;
import hu.xannosz.veneos.event.Event;
import hu.xannosz.veneos.event.MouseEvent;
import hu.xannosz.veneos.event.MouseEventType;

public class Button extends Component {

	private boolean isClicked = false;
	private boolean isEntered = false;
	private Consumer<MouseEvent> action;
	protected Matrix<Color> normal;
	protected Matrix<Color> clicked;
	protected Matrix<Color> entered;

	public Button(Matrix<Color> normal, Matrix<Color> clicked, Matrix<Color> entered) {
		setStopEvent(true);
		this.normal = normal;
		this.clicked = clicked;
		this.entered = entered;
	}

	public void addClickListener(Consumer<MouseEvent> action) {
		this.action = action;
	}

	@Override
	public Matrix<Color> draw() {
		if (isClicked) {
			return clicked;
		} else if (isEntered) {
			return entered;
		} else {
			return normal;
		}
	}

	@Override
	public void runEvent(Event e) {
		if (e instanceof MouseEvent) {
			if (((MouseEvent) e).getEventType() == MouseEventType.ENTER) {
				isEntered = true;
				setReDraw();
			} else if (((MouseEvent) e).getEventType() == MouseEventType.PRESS) {
				isClicked = true;
				setReDraw();
			} else if (((MouseEvent) e).getEventType() == MouseEventType.RELEASE) {
				isClicked = false;
				action.accept((MouseEvent) e);
				setReDraw();
			} else if (((MouseEvent) e).getEventType() == MouseEventType.EXIT) {
				isClicked = false;
				isEntered = false;
				setReDraw();
			}
		}
	}
}
