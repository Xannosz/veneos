package hu.xannosz.veneos.core.html.list;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Data extends InlineComponent {

    public Data(String value, String element) {
        super(element);
        putMeta("value", value);
    }

    public Data(String value, HtmlComponent element) {
        super(element);
        putMeta("value", value);
    }

    @Override
    protected String getTag() {
        return "data";
    }

}
