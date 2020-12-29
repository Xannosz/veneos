package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.box.AbstractBox;

public class Map extends AbstractBox {

    public Map(String name) {
        meta.put("name", name);
    }

    @Override
    protected String getTag() {
        return "map";
    }
}
