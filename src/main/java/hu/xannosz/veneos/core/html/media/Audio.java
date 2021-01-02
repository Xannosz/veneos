package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Audio extends AbstractBox {

    public Audio addControls() {
        return (Audio) addMeta("controls");
    }

    @Override
    protected String getTag() {
        return "audio";
    }

}
