package hu.xannosz.veneos.core.html;

public class Optgroup extends AbstractBox {

	public Optgroup(String label) {
		meta.put("label", label);
	}

	@Override
	protected String getTag() {
		return "optgroup";
	}

}
