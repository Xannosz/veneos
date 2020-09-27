package hu.xannosz.veneos.core.html;

public class Fieldset extends AbstractBox {

	public Fieldset add(String component) {
		add(new StringHtmlComponent(component));
		return this;
	}

	@Override
	protected String getTag() {
		return "fieldset";
	}

}
