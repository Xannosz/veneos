package hu.xannosz.veneos.core.css.selector;

public class SelectAttribute extends SelectPseudo {

    SelectAttribute(String selector) {
        super(selector);
    }

    public SelectPseudo withAttribute(String attribute) {
        selector += "[" + attribute + "]";
        return this;
    }

    public SelectPseudo withAttributeEquals(String attribute, String value) {
        selector += "[" + attribute + "=\"" + value + "\"]";
        return this;
    }

    public SelectPseudo withAttributeContainsWord(String attribute, String value) {
        selector += "[" + attribute + "~=\"" + value + "\"]";
        return this;
    }

    public SelectPseudo withAttributeStartingWithWord(String attribute, String value) {
        selector += "[" + attribute + "|=\"" + value + "\"]";
        return this;
    }

    public SelectPseudo withAttributeBegin(String attribute, String value) {
        selector += "[" + attribute + "^=\"" + value + "\"]";
        return this;
    }

    public SelectPseudo withAttributeEnds(String attribute, String value) {
        selector += "[" + attribute + "$=\"" + value + "\"]";
        return this;
    }

    public SelectPseudo withAttributeContainsSubstring(String attribute, String value) {
        selector += "[" + attribute + "*=\"" + value + "\"]";
        return this;
    }
}
