package hu.xannosz.veneos.core.html.gauge;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Meter extends InlineComponent {

    public Meter(String element, String value) {
        this.element = new StringHtmlComponent(element);
        meta.put("value", value);
    }

    public Meter(HtmlComponent element, String value) {
        this.element = element;
        meta.put("value", value);
    }

    public Meter(String element, String value, String min, String max) {
        this.element = new StringHtmlComponent(element);
        meta.put("value", value);
        meta.put("min", min);
        meta.put("max", max);
    }

    public Meter(HtmlComponent element, String value, String min, String max) {
        this.element = element;
        meta.put("value", value);
        meta.put("min", min);
        meta.put("max", max);
    }

    @Override
    protected String getTag() {
        return "meter";
    }

}
