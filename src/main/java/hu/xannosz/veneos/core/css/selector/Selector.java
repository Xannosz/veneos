package hu.xannosz.veneos.core.css.selector;

import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.core.html.HtmlID;

public class Selector extends SelectAttribute {

    public static Selectable allSelector() {
        return new Selectable("*");
    }

    public Selector(HtmlSelector htmlSelector) {
        super(htmlSelector.toString());
    }

    public Selector(HtmlID selector) {
        super("#" + selector);
    }

    public Selector(HtmlClass selector) {
        super("." + selector);
    }

    public Selector addClass(HtmlClass clazz) {
        selector += clazz.getSelector().getSyntax();
        return this;
    }
}
