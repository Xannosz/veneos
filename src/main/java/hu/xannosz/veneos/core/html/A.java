package hu.xannosz.veneos.core.html;

public class A extends InlineComponent {

	public A(String href, HtmlComponent element) {
		this.element = element;
		meta.put("href", href);
	}

	public A(String href, String element) {
		this.element = new StringHtmlComponent(element);
		meta.put("href", href);
	}

	@Override
	protected String getTag() {
		return "a";
	}

}