package hu.xannosz.veneos.core.html;

public class Audio extends AbstractBox {

	public void addControls() {
		metaList.add("controls");
	}

	@Override
	protected String getTag() {
		return "audio";
	}

}
