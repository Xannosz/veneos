package hu.xannosz.veneos.core.html;

public class HtmlComponentBox extends AbstractBox {
	@Override
	public String getSyntax() {
		return getContent();
	}

	@Override
	protected String getTag() {
		return null;
	}
}
