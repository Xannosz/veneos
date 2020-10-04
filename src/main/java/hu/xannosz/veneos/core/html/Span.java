package hu.xannosz.veneos.core.html;

public class Span extends HtmlComponent {

    private final HtmlComponent content;

    public Span(String content) {
        this.content = new StringHtmlComponent(content);
    }

    public Span(HtmlComponent content) {
        this.content = content;
    }

    @Override
    protected String getTag() {
        return "span";
    }

    @Override
    protected String getContent() {
        return content.getSyntax();
    }
}
