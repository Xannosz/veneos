package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Figcaption extends InlineComponent {

    public Figcaption(String element) {
        this.element = new StringHtmlComponent(element);
    }

    public Figcaption(HtmlComponent element) {
        this.element = element;
    }

    @Override
    protected String getTag() {
        return "figcaption";
    }

}
