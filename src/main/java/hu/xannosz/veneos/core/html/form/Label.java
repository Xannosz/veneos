package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Label extends InlineComponent {

    public Label(String for_, HtmlComponent element) {
        super(element);
        putMeta("for", for_);
    }

    public Label(String for_, String element) {
        super(element);
        putMeta("for", for_);
    }

    @Override
    protected String getTag() {
        return "label";
    }

}
