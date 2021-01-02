package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Param extends SingleHtmlComponent {

    public Param(String name, String value) {
        putMeta("name", name);
        putMeta("value", value);
    }

    @Override
    protected String getTag() {
        return "param";
    }

}
