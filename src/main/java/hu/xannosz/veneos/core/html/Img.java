package hu.xannosz.veneos.core.html;

public class Img extends SingleHtmlComponent {

	public Img(String src) {
		meta.put("src", src);
	}

	public Img setAlt(String alt) {
		meta.put("alt", alt);
		return this;
	}

	public Img setHeight(String height) {
		meta.put("height", height);
		return this;
	}

	public Img setWidth(String width) {
		meta.put("width", width);
		return this;
	}

	@Override
	protected String getTag() {
		return "img";
	}

}
