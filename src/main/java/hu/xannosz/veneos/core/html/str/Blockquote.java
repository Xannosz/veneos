package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Blockquote extends InlineComponent {

    public Blockquote(String cite, String element) {
        super(element);
        meta.put("cite", cite);
    }

    public Blockquote(String cite, HtmlComponent element) {
        super(element);
        meta.put("cite", cite);
    }

    @Override
    protected String getTag() {
        return "blockquote";
    }

}
