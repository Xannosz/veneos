package hu.xannosz.veneos.core;

import java.util.UUID;

public class HtmlClass {

	String id = UUID.randomUUID().toString();

	public String getSyntax() {
		return id;
	}
}
