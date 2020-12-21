package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.Button;
import hu.xannosz.veneos.core.html.Form;
import hu.xannosz.veneos.core.html.HtmlComponent;

public class OneButtonForm extends Form {

    public OneButtonForm(String action, HtmlComponent element, boolean useOnClick) {
        super(action, useOnClick);
        Button button = new Button(element);
        if (!useOnClick) {
            button.setSubmit();
        }
        add(button);
    }

    public OneButtonForm(String action, String element, boolean useOnClick) {
        super(action, useOnClick);
        Button button = new Button(element);
        if (!useOnClick) {
            button.setSubmit();
        }
        add(button);
    }
}
