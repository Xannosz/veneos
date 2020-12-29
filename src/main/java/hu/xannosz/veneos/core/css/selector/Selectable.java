package hu.xannosz.veneos.core.css.selector;

public class Selectable {
    protected String selector;

    Selectable(String selector) {
        this.selector = selector;
    }

    public SelectAttribute descendant(Selectable selector) {
        this.selector += " " + selector.getSyntax();
        return (SelectAttribute) this;
    }

    public SelectAttribute child(Selectable selector) {
        this.selector += ">" + selector.getSyntax();
        return (SelectAttribute) this;
    }

    public SelectAttribute after(Selectable selector) {
        this.selector += "+" + selector.getSyntax();
        return (SelectAttribute) this;
    }

    public SelectAttribute precede(Selectable selector) {
        this.selector += "~" + selector.getSyntax();
        return (SelectAttribute) this;
    }

    public String getSyntax() {
        return selector;
    }
}
