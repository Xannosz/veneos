package hu.xannosz.veneos.core.html.misc;

import hu.xannosz.veneos.core.html.HtmlComponent;

public class Iframe extends HtmlComponent {

    public Iframe(String src, String title) {
        putMeta("src", src);
        putMeta("title", title);
    }

    @Override
    protected String getTag() {
        return "iframe";
    }

    @Override
    protected String getContent() {
        return "";
    }

}
