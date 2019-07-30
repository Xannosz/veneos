package hu.xannosz.veneos.core.html;

public class Figcaption extends InlineComponent {

	public Figcaption(String element) {
		this.element = new StringHtmlComponent(element);
	}

	public Figcaption(HtmlComponent element) {
		this.element = element;
	}

	@Override
	protected String getTag() {
		return "figcaption";
	}

}
