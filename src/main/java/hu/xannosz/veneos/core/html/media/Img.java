package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Img extends SingleHtmlComponent {

    public Img(String src) {
        putMeta("src", src);
    }

    public Img setAlt(String alt) {
        return  (Img)  putMeta("alt", alt);
    }

    public Img setHeight(String height) {
        return  (Img)   putMeta("height", height);
    }

    public Img setWidth(String width) {
        return  (Img)  putMeta("width", width);
    }

    @Override
    protected String getTag() {
        return "img";
    }

}
