package hu.xannosz.veneos.core.html;

public class Map extends AbstractBox {

	public Map(String name) {
		meta.put("name", name);
	}

	@Override
	protected String getTag() {
		return "map";
	}
}