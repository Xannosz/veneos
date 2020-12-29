package hu.xannosz.veneos.core.css.selector;

public enum ParameterizedPseudoClass {
    LANG, NTH_CHILD, NTH_LAST_CHILD, NTH_LAST_OF_TYPE, NTH_OF_TYPE;

    public String getSyntax() {
        return this.toString().toLowerCase().replaceAll("_", "-");
    }
}
