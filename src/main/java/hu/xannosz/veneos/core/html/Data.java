package hu.xannosz.veneos.core.html;

public class Data extends InlineComponent {

	public Data(String value, String element) {
		this.element = new StringHtmlComponent(element);
		meta.put("value", value);
	}

	public Data(String value, HtmlComponent element) {
		this.element = element;
		meta.put("value", value);
	}

	@Override
	protected String getTag() {
		return "data";
	}

}
