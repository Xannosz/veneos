package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Source extends SingleHtmlComponent {

    public Source(String src, String type) {
        putMeta("src", src);
        putMeta("type", type);
    }

    @Override
    protected String getTag() {
        return "source";
    }

}
