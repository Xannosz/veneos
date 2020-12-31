package hu.xannosz.veneos.core.html.ruby;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Rp extends InlineComponent {

    public Rp(String element) {
        super(element);
    }

    public Rp(HtmlComponent element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "rp";
    }
}
