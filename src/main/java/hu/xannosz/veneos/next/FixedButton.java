package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;

@Deprecated
public class FixedButton extends OneButtonForm {

    public FixedButton(String action, HtmlComponent element, ButtonPosition position, boolean useOnClick) {
        super(action, element, useOnClick);
        putMeta("style", position.toString());
    }

    public FixedButton(String action, String element, ButtonPosition position, boolean useOnClick) {
        super(action, element, useOnClick);
        putMeta("style", position.toString());
    }
}
