package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Param extends SingleHtmlComponent {

    public Param(String name, String value) {
        meta.put("name", name);
        meta.put("value", value);
    }

    @Override
    protected String getTag() {
        return "param";
    }

}
