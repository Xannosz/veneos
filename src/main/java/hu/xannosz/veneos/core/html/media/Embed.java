package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Embed extends SingleHtmlComponent {

    public Embed(String type, String src) {
        putMeta("type", type);
        putMeta("src", src);
    }

    @Override
    protected String getTag() {
        return "embed";
    }

}
