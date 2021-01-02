package hu.xannosz.veneos.core.html.gauge;

import hu.xannosz.veneos.core.html.HtmlComponent;

public class Progress extends HtmlComponent {

    public Progress(int value, int max) {
        putMeta("value", value);
        putMeta("max", max);
    }

    @Override
    protected String getTag() {
        return "progress";
    }

    @Override
    protected String getContent() {
        return "";
    }

}
