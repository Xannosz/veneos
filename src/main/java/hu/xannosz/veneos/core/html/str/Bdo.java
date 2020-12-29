package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

public class Bdo extends InlineComponent {

    public Bdo(Dir dir, String element) {
        this.element = new StringHtmlComponent(element);
        meta.put("dir", dir.toString().toLowerCase());
    }

    public Bdo(Dir dir, HtmlComponent element) {
        this.element = element;
        meta.put("dir", dir.toString().toLowerCase());
    }

    @Override
    protected String getTag() {
        return "bdo";
    }

    public enum Dir {
        LTR, RTL;
    }

}
