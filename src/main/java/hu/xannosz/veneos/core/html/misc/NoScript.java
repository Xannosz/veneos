package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class NoScript extends InlineComponent {

    public NoScript(String element) {
        super(element);
    }

    public NoScript(HtmlComponent element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "noscript";
    }
}
