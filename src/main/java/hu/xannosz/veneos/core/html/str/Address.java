package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Address extends InlineComponent {

    public Address(String element) {
        super(element);
    }

    public Address(HtmlComponent element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "address";
    }

}
