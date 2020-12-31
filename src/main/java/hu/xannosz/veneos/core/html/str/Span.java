package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Span extends InlineComponent {

    public Span(String content) {
        super(content);
    }

    public Span(HtmlComponent content) {
        super(content);
    }

    @Override
    protected String getTag() {
        return "span";
    }
}
