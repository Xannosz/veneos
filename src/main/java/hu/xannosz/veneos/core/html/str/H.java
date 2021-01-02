package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class H extends InlineComponent {

    private final int num;

    public H(int num, String header) {
        super(header);
        this.num = getNum(num);
    }

    public H(int num, HtmlComponent header) {
        super(header);
        this.num = getNum(num);
    }

    @Override
    protected String getTag() {
        return "h" + num;
    }

    private static int getNum(int num) {
        if (num < 1) {
            return 1;
        } else return Math.min(num, 6);
    }
}
