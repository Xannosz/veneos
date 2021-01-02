package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Button extends InlineComponent {

    public Button(HtmlComponent element) {
        super(element);
        putMeta("type", "button");
    }

    public Button(String element) {
        super(element);
        putMeta("type", "button");
    }

    public Button setSubmit() {
        return (Button) putMeta("type", "submit");
    }

    @Override
    protected String getTag() {
        return "button";
    }

}
