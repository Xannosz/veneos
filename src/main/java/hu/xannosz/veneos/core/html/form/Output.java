package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.AbstractBox;

public class Output extends AbstractBox {

    public Output(String name, String for_) {
        putMeta("name", name);
        putMeta("for", for_);
    }

    @Override
    protected String getTag() {
        return "output";
    }
}
