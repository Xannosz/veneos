package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Address extends InlineComponent {

    public Address(String element) {
        this.element = new StringHtmlComponent(element);
    }

    @Override
    protected String getTag() {
        return "address";
    }

}
