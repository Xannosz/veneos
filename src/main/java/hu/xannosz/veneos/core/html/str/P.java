package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class P extends InlineComponent {

    public P(String element) {
        super(element);
    }

    public P(HtmlComponent element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "p";
    }
}
