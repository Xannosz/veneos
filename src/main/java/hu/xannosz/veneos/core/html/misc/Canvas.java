package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.InlineComponent;

public class Canvas extends InlineComponent {

    public Canvas(String alternative) {
        super(alternative);
    }

    @Override
    protected String getTag() {
        return "canvas";
    }
}
