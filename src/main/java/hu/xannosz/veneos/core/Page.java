package hu.xannosz.veneos.core;

import hu.xannosz.veneos.core.html.Body;
import hu.xannosz.veneos.core.html.Head;
import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.Set;

public class Page {

    private final Head head = new Head();
    private final Body body = new Body();

    public void setTitle(String title) {
        head.setTitle(title);
    }

    public void setCharset(String charset) {
        head.setCharset(charset);
    }

    public void setAutoRefresh(int time) {
        head.setAutoRefresh(time);
    }

    public void addTheme(Theme theme) {
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
