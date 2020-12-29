package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Legend extends InlineComponent {

    public Legend(String element) {
        this.element = new StringHtmlComponent(element);
    }

    public Legend(HtmlComponent element) {
        this.element = element;
    }

    @Override
    protected String getTag() {
        return "legend";
    }

}
