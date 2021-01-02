package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Area extends SingleHtmlComponent {

    public Area(String shape, String coords, String href, String alt) {
        putMeta("shape", shape);
        putMeta("coords", coords);
        putMeta("href", href);
        putMeta("alt", alt);
    }

    @Override
    protected String getTag() {
        return "area";
    }

}
