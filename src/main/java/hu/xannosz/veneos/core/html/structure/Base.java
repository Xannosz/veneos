package hu.xannosz.veneos.core.html.structure;

public class Base {

    private final String href;
    private final String target;

    public Base(String href) {
        this(href, null);
    }

    public Base(String href, String target) {
        this.href = href;
        this.target = target;
    }

    public String getSyntax() {
        return "< href=\"" + href + "\" " + (target == null ? "" : ("target=\"" + target + "\"")) + ">";
    }
}
