package hu.xannosz.veneos.core.html;

public class Legend extends InlineComponent {

	public Legend(String element) {
		this.element = new StringHtmlComponent(element);
	}

	public Legend(HtmlComponent element) {
		this.element = element;
	}

	@Override
	protected String getTag() {
		return "legend";
	}

}
