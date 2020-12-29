package hu.xannosz.veneos.core.css.selector;

public enum PseudoClass {
    ACTIVE, CHECKED, DEFAULT, DISABLED, EMPTY, ENABLED, FIRST_CHILD, FIRST_OF_TYPE, FOCUS, FULLSCREEN, HOVER, IN_RANGE, //
    INDETERMINATE, INVALID, LAST_CHILD, LAST_OF_TYPE, LINK, ONLY_OF_TYPE, ONLY_CHILD, OPTIONAL, OUT_OF_RANGE, //
    READ_ONLY, READ_WRITE, REQUIRED, ROOT, TARGET, VALID, VISITED;

    public String getSyntax() {
        return this.toString().toLowerCase().replaceAll("_", "-");
    }
}
