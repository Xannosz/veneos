package hu.xannosz.veneos.core.css;

@Deprecated
public class StringCssComponent extends CssComponent {

	private final String component;

	public StringCssComponent(String component) {
		super(new Selector(""));
		this.component = component;
	}

	@Override
	public String getSyntax() {
		return component;
	}
}
