package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;

public class FixedButton extends OneButtonForm {

    public FixedButton(String action, HtmlComponent element, ButtonPosition position) {
        super(action, element);
        meta.put("style", position.toString());
    }

    public FixedButton(String action, String element, ButtonPosition position) {
        super(action, element);
        meta.put("style", position.toString());
    }
}
