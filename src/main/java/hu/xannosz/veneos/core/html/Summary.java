package hu.xannosz.veneos.core.html;

public class Summary extends InlineComponent {

	public Summary(String summary) {
		element = new StringHtmlComponent(summary);
	}

	public Summary(HtmlComponent summary) {
		element = summary;
	}

	@Override
	protected String getTag() {
		return "summary";
	}

}
