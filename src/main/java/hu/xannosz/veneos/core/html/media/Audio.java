package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Audio extends AbstractBox {

    public void addControls() {
        metaList.add("controls");
    }

    @Override
    protected String getTag() {
        return "audio";
    }

}
