package hu.xannosz.veneos.core.html;

public class Dialog extends InlineComponent {

	public Dialog(String element) {
		this.element = new StringHtmlComponent(element);
	}

	public Dialog(HtmlComponent element) {
		this.element = element;
	}
	
	public void setOpen() {
		metaList.add("open");
	}

	@Override
	protected String getTag() {
		return "dialog";
	}

}
