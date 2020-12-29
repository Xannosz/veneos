package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Track extends SingleHtmlComponent {

    public Track(String src, String kind, String srclang, String label) {
        meta.put("src", src);
        meta.put("kind", kind);
        meta.put("srclang", srclang);
        meta.put("label", label);
    }

    @Override
    protected String getTag() {
        return "track";
    }

}
