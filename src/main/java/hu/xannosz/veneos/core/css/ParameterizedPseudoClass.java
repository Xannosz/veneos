package hu.xannosz.veneos.core.css;

public enum ParameterizedPseudoClass {
    LANG, NOT, NTH_CHILD, NTH_LAST_CHILD, NTH_LAST_OF_TYPE, NTH_OF_TYPE;

    public String getSyntax() {
        return this.toString().toLowerCase().replaceAll("_", "-");
    }
}
