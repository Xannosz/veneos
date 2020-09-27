package hu.xannosz.veneos.core.html;

public class Output extends HtmlComponent{
	
	public Output(String name, String for_) {
		meta.put("name", name);
		meta.put("for", for_);
	}

	@Override
	protected String getTag() {
		return "output";
	}

	@Override
	protected String getContent() {
		return "";
	}

}
