package hu.xannosz.veneos.core.html;

public class Progress extends HtmlComponent {

	public Progress(String value, String max) {
		meta.put("value", value);
		meta.put("max", max);
	}

	@Override
	protected String getTag() {
		return "progress";
	}

	@Override
	protected String getContent() {
		return "";
	}

}
