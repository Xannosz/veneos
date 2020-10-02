package hu.xannosz.veneos.core;

import java.util.UUID;

public class HtmlID {

	private final String id = UUID.randomUUID().toString();

	public String getSyntax() {
		return id;
	}

	@Override
	public String toString() {
		return getSyntax();
	}
}
