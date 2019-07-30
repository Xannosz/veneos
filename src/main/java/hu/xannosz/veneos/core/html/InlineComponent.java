package hu.xannosz.veneos.core.html;

public abstract class InlineComponent extends HtmlComponent{

	protected HtmlComponent element;

	@Override
	protected String getContent() {
		return element.getSyntax();
	}

}
