package hu.xannosz.veneos.core.html;

public class Track extends SingleHtmlComponent {

	public Track(String src, String kind, String srclang, String label) {
		meta.put("src", src);
		meta.put("kind", kind);
		meta.put("srclang", srclang);
		meta.put("label", label);
	}

	@Override
	protected String getTag() {
		return "track";
	}

}
