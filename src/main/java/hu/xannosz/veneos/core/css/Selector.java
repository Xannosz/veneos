package hu.xannosz.veneos.core.css;

import hu.xannosz.veneos.core.HtmlClass;
import hu.xannosz.veneos.core.HtmlID;

public class Selector {

    private String selector;

    public static Selector allSelector() {
        return new Selector("*");
    }

    public Selector(HtmlID selector) {
        this.selector = "#" + selector;
    }

    public Selector(HtmlClass selector) {
        this.selector = "." + selector;
    }

    public Selector(String selector) {
        this.selector = selector;
    }

    public Selector addClass(HtmlClass clazz) {
        selector += clazz.getSelector().getSyntax();
        return this;
    }

    public Selector descendant(Selector selector) {
        this.selector += " " + selector.getSyntax();
        return this;
    }

    public Selector child(Selector selector) {
        this.selector += ">" + selector.getSyntax();
        return this;
    }

    public Selector after(Selector selector) {
        this.selector += "+" + selector.getSyntax();
        return this;
    }

    public Selector precede(Selector selector) {
        this.selector += "~" + selector.getSyntax();
        return this;
    }

    public Selector withAttribute(String attribute) {
        selector += "[" + attribute + "]";
        return this;
    }

    public Selector withAttributeEquals(String attribute, String value) {
        selector += "[" + attribute + "=\"" + value + "\"]";
        return this;
    }

    public Selector withAttributeContainsWord(String attribute, String value) {
        selector += "[" + attribute + "~=\"" + value + "\"]";
        return this;
    }

    public Selector withAttributeStartingWithWord(String attribute, String value) {
        selector += "[" + attribute + "|=\"" + value + "\"]";
        return this;
    }

    public Selector withAttributeBegin(String attribute, String value) {
        selector += "[" + attribute + "^=\"" + value + "\"]";
        return this;
    }

    public Selector withAttributeEnds(String attribute, String value) {
        selector += "[" + attribute + "$=\"" + value + "\"]";
        return this;
    }

    public Selector withAttributeContainsSubstring(String attribute, String value) {
        selector += "[" + attribute + "*=\"" + value + "\"]";
        return this;
    }

    public Selector addPseudoClass(PseudoClass pseudoClass) {
        selector += ":" + pseudoClass.getSyntax();
        return this;
    }

    public Selector addPseudoClass(ParameterizedPseudoClass pseudoClass, String value) {
        if (pseudoClass.equals(ParameterizedPseudoClass.NOT)) {
            selector = ":" + pseudoClass.getSyntax() + "(" + selector + ")";
            return this;
        } else {
            selector += ":" + pseudoClass.getSyntax() + "(" + value + ")";
            return this;
        }
    }

    public Selector addPseudoElement(PseudoElement pseudoElement) {
        selector += "::" + pseudoElement.getSyntax();
        return this;
    }

    public String getSyntax() {
        return selector;
    }
}
