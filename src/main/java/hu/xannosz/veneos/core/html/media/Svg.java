package hu.xannosz.veneos.core.html.media;

import hu.xannosz.veneos.core.html.HtmlComponent;

public class Svg extends HtmlComponent {

    public Svg(int width, int height) {
        putMeta("width", "" + width);
        putMeta("height", "" + height);
    }

    private final StringBuilder builder = new StringBuilder();

    public Svg addCircle(int cx, int cy, int r, String stroke, int strokeWidth, String fill) {
        return add("circle", "cx", "" + cx, "cy", "" + cy, "r", "" + r, "stroke", stroke, "stroke-width", "" + strokeWidth, "fill", fill);
    }

    public Svg addRectangle(int cx, int cy, int width, int height, String stroke, int strokeWidth, String fill) {
        return add("rect", "cx", "" + cx, "cy", "" + cy, "width", "" + width, "height", "" + height, "stroke", stroke, "stroke-width", "" + strokeWidth, "fill", fill);
    }

    public Svg addRectangleRounded(int cx, int cy, int width, int height, int rx, int ry, String stroke, int strokeWidth, String fill) {
        return add("rect", "cx", "" + cx, "cy", "" + cy, "width", "" + width, "height", "" + height, "rx", "" + rx, "ry", "" + ry, "stroke", stroke, "stroke-width", "" + strokeWidth, "fill", fill);
    }

    public Svg addPolygon(String points, String stroke, int strokeWidth, String fill) {
        return add("polygon", "points", points, "stroke", stroke, "stroke-width", "" + strokeWidth, "fill", fill);
    }

    public Svg add(String tag, String... list) {
        builder.append("<").append(tag).append(" ");
        boolean isTag = true;
        for (String str : list) {
            builder.append(str);
            if (isTag) {
                builder.append("=\"");
                isTag = false;
            } else {
                builder.append("\" ");
                isTag = true;
            }
        }
        builder.append("/>");
        return this;
    }

    public Svg add(String content) {
        builder.append(content);
        return this;
    }

    @Override
    protected String getTag() {
        return "svg";
    }

    @Override
    protected String getContent() {
        return builder.toString();
    }
}
