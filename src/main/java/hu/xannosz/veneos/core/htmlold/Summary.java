package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Summary extends InlineComponent {

    public Summary(String summary) {
        element = new StringHtmlComponent(summary);
    }

    public Summary(HtmlComponent summary) {
        element = summary;
    }

    @Override
    protected String getTag() {
        return "summary";
    }

}
