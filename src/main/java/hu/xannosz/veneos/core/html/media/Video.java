package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Video extends AbstractBox {

    public void setHeight(String height) {
        meta.put("height", height);
    }

    public void setWidth(String width) {
        meta.put("width", width);
    }

    public void addControls() {
        metaList.add("controls");
    }

    @Override
    protected String getTag() {
        return "video";
    }

}
