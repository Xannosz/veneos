package hu.xannosz.veneos.core.html.structure;

import hu.xannosz.veneos.core.css.Theme;
import hu.xannosz.veneos.core.handler.ThemeHandler;
import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.Set;

public class Page {

    private final Head head = new Head();
    private final Body body = new Body();

    public void setTitle(String title) {
        head.setTitle(title);
    }

    public void setBase(Base base) {
        head.setBase(base);
    }

    public void setStyle(Theme style) {
        head.setStyle(style);
    }

    public void setCharset(String charset) {
        head.setCharset(charset);
    }

    public void setAutoRefresh(int time) {
        head.setAutoRefresh(time);
    }

    public void addTheme(Theme theme) {
        ThemeHandler.registerTheme(theme);
        head.addTheme(theme);
    }

    public void addScript(String script) {
        head.addScript(script);
    }

    public void addScript(Set<String> script) {
        head.addScript(script);
    }

    public void addComponent(HtmlComponent component) {
        body.add(component);
    }

    public String getSyntax() {
        return "<!DOCTYPE html><html>" + head.getSyntax() + body.getSyntax() + "</html>";
    }
}
