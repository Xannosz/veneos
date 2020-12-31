package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;

public class H extends HtmlComponent {

    private final int num;
    private final String header;

    public H(int num, String header) {
        if (num < 1) {
            this.num = 1;
        } else if (num > 6) {
            this.num = 6;
        } else {
            this.num = num;
        }
        this.header = header;
    }

    @Override
    protected String getTag() {
        return "h" + num;
    }

    @Override
    protected String getContent() {
        return header;
    }
}
