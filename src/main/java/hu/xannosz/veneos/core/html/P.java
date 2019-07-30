package hu.xannosz.veneos.core.html;

public class P extends InlineComponent {

	public P(String element) {
		this.element = new StringHtmlComponent(element);
	}

	@Override
	protected String getTag() {
		return "p";
	}
}
