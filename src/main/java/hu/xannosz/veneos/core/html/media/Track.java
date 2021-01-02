package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Track extends SingleHtmlComponent {

    public Track(String src, String kind, String srcLang, String label) {
        putMeta("src", src);
        putMeta("kind", kind);
        putMeta("srclang", srcLang);
        putMeta("label", label);
    }

    @Override
    protected String getTag() {
        return "track";
    }

}
