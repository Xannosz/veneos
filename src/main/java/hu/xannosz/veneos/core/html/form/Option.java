package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Option extends InlineComponent {

    public Option(String value, HtmlComponent element) {
        super(element);
        putMeta("value", value);
    }

    public Option(String value, String element) {
        super(element);
        putMeta("value", value);
    }

    @Override
    protected String getTag() {
        return "option";
    }

}
