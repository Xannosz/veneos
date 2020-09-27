package hu.xannosz.veneos.core.html;

public class Blockquote extends InlineComponent {

	public Blockquote(String cite, String element) {
		this.element = new StringHtmlComponent(element);
		meta.put("cite", cite);
	}

	public Blockquote(String cite, HtmlComponent element) {
		this.element = element;
		meta.put("cite", cite);
	}

	@Override
	protected String getTag() {
		return "blockquote";
	}

}