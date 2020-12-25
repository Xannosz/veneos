package hu.xannosz.veneos.core.css;

public enum CssAttribute {
    HEIGHT, WIDTH, FLOAT, POSITION, Z_INDEX, TOP, LEFT, BACKGROUND_COLOR, OVERFLOW_X, PADDING_TOP, PADDING, //
    TEXT_DECORATION, DISPLAY, COLOR, FONT_SIZE, TRANSITION, BORDER, BORDER_COLOR, BORDER_STYLE, BORDER_WIDTH, //
    MARGIN, BORDER_RADIUS, TEXT_ALIGN, FONT_WEIGHT, FONT_STYLE;

    public String getSyntax() {
        return this.toString().toLowerCase().replaceAll("_", "-");
    }
}
