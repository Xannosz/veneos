package hu.xannosz.veneos.core.html.structure;

import hu.xannosz.veneos.core.css.Theme;
import hu.xannosz.veneos.core.html.HtmlComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class Head extends HtmlComponent {

    @Setter
    private String title;
    @Getter
    @Setter
    private String charset;
    private Integer refreshTime;
    private final Set<Theme> themes = new HashSet<>();
    private final Set<String> scripts = new HashSet<>();

    public void addTheme(Theme theme) {
        themes.add(theme);
    }

    public void addScript(String script) {
        scripts.add(script);
    }

    public void addScript(Set<String> script) {
        scripts.addAll(script);
    }

    private String getTitleSyntax() {
        return "<title>" + title + "</title>";
    }

    private String getThemeSyntax() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Theme theme : themes) {
            stringBuilder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/");
            stringBuilder.append(theme.getId());
            stringBuilder.append("\">");
        }
        return stringBuilder.toString();
    }

    public void setAutoRefresh(int refreshTime) {
        this.refreshTime = refreshTime;
    }

    private String getScriptSyntax() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String script : scripts) {
            stringBuilder.append("<script>");
            stringBuilder.append(script);
            stringBuilder.append("</script>");
        }
        return stringBuilder.toString();
    }

    private String getCharsetSyntax() {
        return "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=" + charset + "\">";
    }

    private String getRefreshSyntax() {
        if (refreshTime == null) {
            return "";
        }
        return "<meta http-equiv=\"refresh\" content=\"" + refreshTime + "\">";
    }

    @Override
    protected String getTag() {
        return "head";
    }

    @Override
    protected String getContent() {
        return getCharsetSyntax() + getRefreshSyntax() + getTitleSyntax() + getThemeSyntax() + getScriptSyntax();
    }
}
