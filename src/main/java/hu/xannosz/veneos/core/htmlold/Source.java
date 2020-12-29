package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Source extends SingleHtmlComponent {

    public Source(String src, String type) {
        meta.put("src", src);
        meta.put("type", type);
    }

    @Override
    protected String getTag() {
        return "source";
    }

}
