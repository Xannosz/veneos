package hu.xannosz.veneos.event;

public class KeyEvent extends Event {
	private int keyCode;
	private char keyChar;
	private boolean isActionKey;
	private int keyLocation;

	public KeyEvent() {
	}

	public KeyEvent(KeyEvent e) {
		super(e);
		keyCode = e.keyCode;
		keyChar = e.keyChar;
		isActionKey = e.isActionKey;
		keyLocation = e.keyLocation;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public char getKeyChar() {
		return keyChar;
	}

	public void setKeyChar(char keyChar) {
		this.keyChar = keyChar;
	}

	public boolean isActionKey() {
		return isActionKey;
	}

	public void setActionKey(boolean isActionKey) {
		this.isActionKey = isActionKey;
	}

	public int getKeyLocation() {
		return keyLocation;
	}

	public void setKeyLocation(int keyLocation) {
		this.keyLocation = keyLocation;
	}

	@Override
	public String toString() {
		return "KeyEvent [keyCode=" + keyCode + ", keyChar=" + keyChar + ", isActionKey=" + isActionKey
				+ ", keyLocation=" + keyLocation + "]";
	}
}
