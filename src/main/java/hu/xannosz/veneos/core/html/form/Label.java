package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Label extends InlineComponent {

    public Label(String for_, HtmlComponent element) {
        this.element = element;
        meta.put("for", for_);
    }

    public Label(String for_, String element) {
        this.element = new StringHtmlComponent(element);
        meta.put("for", for_);
    }

    @Override
    protected String getTag() {
        return "label";
    }

}
