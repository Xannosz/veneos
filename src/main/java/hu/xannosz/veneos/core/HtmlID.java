package hu.xannosz.veneos.core;

import java.util.UUID;

public class HtmlID {

	String id = UUID.randomUUID().toString();

	public String getSyntax() {
		return id;
	}
}
