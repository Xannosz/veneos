package hu.xannosz.veneos.core;

import hu.xannosz.veneos.core.css.Selector;

import java.util.UUID;

public class HtmlClass {

    private final String clazz = "class" + UUID.randomUUID().toString().replace("-", "");

    public String getSyntax() {
        return clazz;
    }

    public Selector getSelector(){
        return new Selector(this);
    }

    @Override
    public String toString() {
        return getSyntax();
    }
}
