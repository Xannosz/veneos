package hu.xannosz.veneos.core.html.str;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class A extends InlineComponent {

    public A(String href, HtmlComponent element) {
        super(element);
        putMeta("href", href);
    }

    public A(String href, String element) {
        super(element);
        putMeta("href", href);
    }

    public A setTarget(String target) {
        return (A) putMeta("target", target);
    }

    @Override
    protected String getTag() {
        return "a";
    }

}
