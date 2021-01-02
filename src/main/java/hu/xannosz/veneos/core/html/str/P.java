package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.AbstractBox;
import hu.xannosz.veneos.core.html.HtmlComponent;

public class P extends AbstractBox {

    public P(String element) {
        add(element);
    }

    public P(HtmlComponent element) {
        add(element);
    }

    @Override
    protected String getTag() {
        return "p";
    }
}
