package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Time extends InlineComponent {

    public Time(String datetime, String element) {
        super(element);
        putMeta("datetime", datetime);
    }

    public Time(String datetime, HtmlComponent element) {
        super(element);
        putMeta("datetime", datetime);
    }

    @Override
    protected String getTag() {
        return "time";
    }
}
