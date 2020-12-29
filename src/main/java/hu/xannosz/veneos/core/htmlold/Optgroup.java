package hu.xannosz.veneos.core.htmlold;

import hu.xannosz.veneos.core.html.box.AbstractBox;

public class Optgroup extends AbstractBox {

    public Optgroup(String label) {
        meta.put("label", label);
    }

    @Override
    protected String getTag() {
        return "optgroup";
    }

}
