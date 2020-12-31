package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.InlineComponent;

public class Script extends InlineComponent {

    public Script(String element) {
        super(element);
    }

    @Override
    protected String getTag() {
        return "script";
    }
}