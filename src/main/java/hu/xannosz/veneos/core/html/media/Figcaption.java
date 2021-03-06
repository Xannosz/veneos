package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Figcaption extends InlineComponent {

    public Figcaption(String element) {
        super(element);
    }

    public Figcaption(HtmlComponent element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "figcaption";
    }

}
