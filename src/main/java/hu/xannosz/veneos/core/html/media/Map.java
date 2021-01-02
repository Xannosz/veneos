package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Map extends AbstractBox {

    public Map(String name) {
        putMeta("name", name);
    }

    @Override
    protected String getTag() {
        return "map";
    }
}
