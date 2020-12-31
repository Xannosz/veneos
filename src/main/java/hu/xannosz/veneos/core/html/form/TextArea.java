package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class TextArea extends SingleHtmlComponent {
    public TextArea(String name, int rows, int cols) {
        meta.put("name", name);
        meta.put("rows", "" + rows);
        meta.put("cols", "" + cols);
    }

    @Override
    protected String getTag() {
        return "textarea";
    }
}
