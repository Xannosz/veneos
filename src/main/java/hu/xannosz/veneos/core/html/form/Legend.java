package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Legend extends InlineComponent {

    public Legend(String element) {
        super(element);
    }

    public Legend(HtmlComponent element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "legend";
    }

}
