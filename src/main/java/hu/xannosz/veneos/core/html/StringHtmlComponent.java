package hu.xannosz.veneos.core.html;

class StringHtmlComponent extends HtmlComponent {
    private final String component;

    public StringHtmlComponent(String component) {
        this.component = component;
    }

    @Override
    protected String getTag() {
        return null;
    }

    @Override
    protected String getContent() {
        return null;
    }

    @Override
    public String getSyntax() {
        return component;
    }
}
