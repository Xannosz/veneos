package hu.xannosz.veneos.core.css.selector;

public class SelectPseudo extends Selectable {

    SelectPseudo(String selector) {
        super(selector);
    }

    public Selectable addPseudoClass(PseudoClass pseudoClass) {
        selector += ":" + pseudoClass.getSyntax();
        return this;
    }

    public Selectable not() {
        selector = ":not(" + selector + ")";
        return this;
    }

    public Selectable addPseudoClass(ParameterizedPseudoClass pseudoClass, String value) {
        selector += ":" + pseudoClass.getSyntax() + "(" + value + ")";
        return this;
    }

    public Selectable addPseudoElement(PseudoElement pseudoElement) {
        selector += "::" + pseudoElement.getSyntax();
        return this;
    }
}
