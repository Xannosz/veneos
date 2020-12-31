package hu.xannosz.veneos.core.html.gauge;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Meter extends InlineComponent {

    public Meter(String element, String value) {
        super(element);
        meta.put("value", value);
    }

    public Meter(HtmlComponent element, String value) {
        super(element);
        meta.put("value", value);
    }

    public Meter(String element, String value, String min, String max) {
        super(element);
        meta.put("value", value);
        meta.put("min", min);
        meta.put("max", max);
    }

    public Meter(HtmlComponent element, String value, String min, String max) {
        super(element);
        meta.put("value", value);
        meta.put("min", min);
        meta.put("max", max);
    }

    @Override
    protected String getTag() {
        return "meter";
    }

}
