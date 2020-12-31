package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Select extends AbstractBox {

    public Select(String name) {
        meta.put("name", name);
    }

    @Override
    protected String getTag() {
        return "select";
    }

}
