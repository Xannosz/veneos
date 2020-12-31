package hu.xannosz.veneos.core.html;

public abstract class InlineComponent extends HtmlComponent {

    protected HtmlComponent element;

    public InlineComponent(HtmlComponent element) {
        this.element = element;
    }

    public InlineComponent(String element) {
        this.element = new StringHtmlComponent(element);
    }

    @Override
    protected String getContent() {
        return element.getSyntax();
    }

}
