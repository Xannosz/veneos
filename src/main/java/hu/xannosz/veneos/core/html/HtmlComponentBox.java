package hu.xannosz.veneos.core.html;

import hu.xannosz.veneos.core.html.box.AbstractBox;

public class HtmlComponentBox extends AbstractBox {
    @Override
    public String getSyntax() {
        return getContent();
    }

    @Override
    protected String getTag() {
        return null;
    }
}
