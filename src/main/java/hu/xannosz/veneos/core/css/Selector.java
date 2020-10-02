package hu.xannosz.veneos.core.css;

import hu.xannosz.veneos.core.HtmlClass;
import hu.xannosz.veneos.core.HtmlID;

public class Selector {

    private final String selector;

    public Selector(HtmlID selector) {
        this.selector = "#" + selector;
    }

    public Selector(HtmlClass selector) {
        this.selector = "." + selector;
    }

    public Selector(String selector) {
        this.selector = selector;
    }

    public Selector(String formatter, Object... selectors) {
        this.selector = String.format(formatter, selectors);
    }

    public String getSyntax() {
        return selector;
    }
}
