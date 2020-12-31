package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Abbr extends InlineComponent {

    public Abbr(String title, HtmlComponent element) {
        super(element);
        meta.put("title", title);
    }

    public Abbr(String title, String element) {
        super(element);
        meta.put("title", title);
    }

    @Override
    protected String getTag() {
        return "abbr";
    }

}
