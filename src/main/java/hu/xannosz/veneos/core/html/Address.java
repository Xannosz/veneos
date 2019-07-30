package hu.xannosz.veneos.core.html;

public class Address extends InlineComponent {

	public Address(String element) {
		this.element = new StringHtmlComponent(element);
	}

	@Override
	protected String getTag() {
		return "address";
	}

}
