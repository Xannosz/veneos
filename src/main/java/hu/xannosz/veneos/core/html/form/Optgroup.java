package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Optgroup extends AbstractBox {

    public Optgroup(String label) {
        meta.put("label", label);
    }

    @Override
    protected String getTag() {
        return "optgroup";
    }

}
