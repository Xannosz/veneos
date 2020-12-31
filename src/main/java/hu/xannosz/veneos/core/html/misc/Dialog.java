package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Dialog extends InlineComponent {

    public Dialog(String element) {
        super(element);
    }

    public Dialog(HtmlComponent element) {
        super(element);
    }

    public void setOpen() {
        metaList.add("open");
    }

    @Override
    protected String getTag() {
        return "dialog";
    }

}
