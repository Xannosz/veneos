package hu.xannosz.veneos.core.html;

public class Abbr extends InlineComponent {

	public Abbr(String title, HtmlComponent element) {
		this.element = element;
		meta.put("title", title);
	}

	public Abbr(String title, String element) {
		this.element = new StringHtmlComponent(element);
		meta.put("title", title);
	}

	@Override
	protected String getTag() {
		return "abbr";
	}

}
