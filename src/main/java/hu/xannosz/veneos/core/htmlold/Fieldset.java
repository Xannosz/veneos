package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.StringHtmlComponent;
import hu.xannosz.veneos.core.html.box.AbstractBox;

public class Fieldset extends AbstractBox {

    public Fieldset add(String component) {
        add(new StringHtmlComponent(component));
        return this;
    }

    @Override
    protected String getTag() {
        return "fieldset";
    }

}
