package hu.xannosz.veneos.core.css;

public class Selector {
	
	private String selector;

	public Selector(String selector) {
		this.selector = selector;
	}
	
	public String getSyntax(){
		return selector;
	}
}
