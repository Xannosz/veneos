package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Video extends AbstractBox {

    public Video setHeight(int height) {
        return (Video) putMeta("height", height);
    }

    public Video setWidth(int width) {
        return (Video) putMeta("width", width);
    }

    public Video setSrc(String src) {
        return (Video) putMeta("src", src);
    }

    public Video addControls() {
        return (Video) addMeta("controls");
    }

    @Override
    protected String getTag() {
        return "video";
    }

}
