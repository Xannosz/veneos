package hu.xannosz.veneos.outputs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.microtools.pack.Matrix;
import hu.xannosz.microtools.pack.Quatlet;
import hu.xannosz.veneos.components.Component;
import hu.xannosz.veneos.event.MouseButtonType;
import hu.xannosz.veneos.event.MouseEventType;
import hu.xannosz.veneos.event.TickEvent;

public class VeneosJPanel extends JPanel implements MouseInputListener, KeyListener {

	private static final long serialVersionUID = -2652784822344952869L;

	private Frame frame;
	private Dimension size;

	public VeneosJPanel(int x, int y) {
		frame = new Frame(x, y);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void addComponent(Component p, Quatlet<Integer, Integer, Integer, Integer> pos) {
		frame.addComponent(p, pos);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		size = getSize();
		Matrix<Color> matrix = frame.draw();
		for (int x = 0; x < matrix.getSize().getFirst(); x++) {
			for (int y = 0; y < matrix.getSize().getSecond(); y++) {
				g.setColor(matrix.getItem(x, y));
				g.fillRect(x * (int) Math.round(size.getWidth()) / matrix.getSize().getFirst(),
						y * (int) Math.round(size.getHeight()) / matrix.getSize().getSecond(),
						(x + 1) * (int) Math.round(size.getWidth()) / matrix.getSize().getFirst(),
						(y + 1) * (int) Math.round(size.getHeight()) / matrix.getSize().getSecond());
			}
		}
	}

	public void tick() {
		frame.runEvent(new TickEvent());
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		addEvent(e, MouseEventType.CLICK);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Unused function
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Unused function
	}

	@Override
	public void mousePressed(MouseEvent e) {
		addEvent(e, MouseEventType.PRESS);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		addEvent(e, MouseEventType.RELEASE);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		addEvent(e, MouseEventType.DRAG);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		addEvent(e, MouseEventType.MOVE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		addEvent(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		addEvent(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		addEvent(e);
	}

	private void addEvent(MouseEvent e, MouseEventType t) {
		hu.xannosz.veneos.event.MouseEvent event = new hu.xannosz.veneos.event.MouseEvent();
		event.setPos(getPanelPosition(e));
		event.setEventType(t);
		if (e.getButton() == 0) {
			event.setButton(MouseButtonType.NONE);
		} else if (e.getButton() == 1) {
			event.setButton(MouseButtonType.LEFT);
		} else if (e.getButton() == 2) {
			event.setButton(MouseButtonType.MIDDLE);
		} else if (e.getButton() == 3) {
			event.setButton(MouseButtonType.RIGHT);
		}
		event.setClickCount(e.getClickCount());
		event.setAltPressed(e.isAltDown());
		event.setAltGrPressed(e.isAltGraphDown());
		event.setControlPressed(e.isControlDown());
		event.setShiftPressed(e.isShiftDown());
		frame.runEvent(event);
		repaint();
	}

	private Douplet<Integer, Integer> getPanelPosition(MouseEvent e) {
		return new Douplet<Integer, Integer>((int) Math.floor(e.getX() / size.getWidth() * frame.getSize().getFirst()),
				(int) Math.floor(e.getY() / size.getHeight() * frame.getSize().getSecond()));
	}

	private void addEvent(KeyEvent e) {
		hu.xannosz.veneos.event.KeyEvent event = new hu.xannosz.veneos.event.KeyEvent();
		event.setKeyCode(e.getKeyCode());
		event.setKeyChar(e.getKeyChar());
		event.setActionKey(e.isActionKey());
		event.setKeyLocation(e.getKeyLocation());
		event.setAltPressed(e.isAltDown());
		event.setAltGrPressed(e.isAltGraphDown());
		event.setControlPressed(e.isControlDown());
		event.setShiftPressed(e.isShiftDown());
		frame.runEvent(event);
		repaint();
	}
}
