package hu.xannosz.veneos.core.html;

public abstract class SingleHtmlComponent extends HtmlComponent {

    @Override
    protected String getContent() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "<" + getTag() + " " + getMetaSyntax() + ">";
    }
}
