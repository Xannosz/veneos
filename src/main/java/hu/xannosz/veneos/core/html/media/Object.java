package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Object extends AbstractBox {

    public Object(String data) {
        putMeta("data", data);
    }

    public Object setType(String type) {
        return (Object) putMeta("type", type);
    }

    @Override
    protected String getTag() {
        return "object";
    }

}
