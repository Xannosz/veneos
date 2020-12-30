package hu.xannosz.veneos.core.html;

import hu.xannosz.veneos.core.css.selector.Selector;

import java.util.UUID;

public class HtmlID {

    private final String id = "id" + UUID.randomUUID().toString().replace("-", "");

    public String getSyntax() {
        return id;
    }

    public Selector getSelector() {
        return new Selector(this);
    }

    @Override
    public String toString() {
        return getSyntax();
    }
}
