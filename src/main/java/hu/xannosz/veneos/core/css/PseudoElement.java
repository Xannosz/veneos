package hu.xannosz.veneos.core.css;

public enum PseudoElement {
    AFTER, BEFORE, FIRST_LETTER, FIRST_LINE, PLACEHOLDER, SELECTION;

    public String getSyntax() {
        return this.toString().toLowerCase().replaceAll("_", "-");
    }
}
