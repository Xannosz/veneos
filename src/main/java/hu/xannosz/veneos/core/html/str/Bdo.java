package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Bdo extends InlineComponent {

    public Bdo(Dir dir, String element) {
        super(element);
        meta.put("dir", dir.toString().toLowerCase());
    }

    public Bdo(Dir dir, HtmlComponent element) {
        super(element);
        meta.put("dir", dir.toString().toLowerCase());
    }

    @Override
    protected String getTag() {
        return "bdo";
    }

    public enum Dir {
        LTR, RTL
    }

}
