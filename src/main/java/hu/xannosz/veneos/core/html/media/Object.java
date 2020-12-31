package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Object extends AbstractBox {

    public Object(String data) {
        meta.put("data", data);
    }

    @Override
    protected String getTag() {
        return "object";
    }

}
