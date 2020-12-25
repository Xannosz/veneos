package hu.xannosz.veneos.core.html;

public class Select extends AbstractBox{

	public Select(String name){
		meta.put("name", name);
	}

	@Override
	protected String getTag() {
		return "select";
	}

}
