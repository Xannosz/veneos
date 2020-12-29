package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Canvas extends InlineComponent {

    public Canvas(String alternative) {
        element = new StringHtmlComponent(alternative);
    }

    @Override
    protected String getTag() {
        return "canvas";
    }
}
