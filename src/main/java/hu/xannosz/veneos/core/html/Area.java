package hu.xannosz.veneos.core.html;

public class Area extends SingleHtmlComponent {

	public Area(String shape, String coords, String href, String alt) {
		meta.put("shape", shape);
		meta.put("coords", coords);
		meta.put("href", href);
		meta.put("alt", alt);
	}

	@Override
	protected String getTag() {
		return "area";
	}

}
