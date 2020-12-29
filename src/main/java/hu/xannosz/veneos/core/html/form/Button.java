package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Button extends InlineComponent {

    public Button(HtmlComponent element) {
        this.element = element;
        meta.put("type", "button");
    }

    public Button(String element) {
        this.element = new StringHtmlComponent(element);
        meta.put("type", "button");
    }

    public void setSubmit() {
        meta.put("type", "submit");
    }

    @Override
    protected String getTag() {
        return "button";
    }

}
