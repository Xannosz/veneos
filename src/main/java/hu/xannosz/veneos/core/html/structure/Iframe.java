package hu.xannosz.veneos.core.html.structure;

import hu.xannosz.veneos.core.html.HtmlComponent;

public class Iframe extends HtmlComponent {

    public Iframe(String src, String title) {
        meta.put("src", src);
        meta.put("title", title);
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
