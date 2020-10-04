package hu.xannosz.veneos.core;

import java.util.UUID;

public class HtmlClass {

    private final String clazz = "class" + UUID.randomUUID().toString().replace("-", "");

    public String getSyntax() {
        return clazz;
    }

    @Override
    public String toString() {
        return getSyntax();
    }
}
