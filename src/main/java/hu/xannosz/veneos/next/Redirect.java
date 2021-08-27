package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.structure.Page;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class Redirect extends HtmlComponent {

    private final String target;
    private Map<String, String> datas = new HashMap<>();

    public Redirect(String target, Page page) {
        this(target, 0, page);
    }

    public Redirect(String target, int waitMillis, Page page) {
        this.target = target;
        page.addScript(
                "function redirect(){console.log(\"Redirect to " + target + "\");" +
                        "window.setTimeout(function() {document.redirectForm.submit();}, "
                        + waitMillis + ");" + "} window.onload=redirect;");
    }

    public Redirect setDatas(Map<String, String> datas) {
        this.datas = datas;
        return this;
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
        StringBuilder builder = new StringBuilder("<form name=\"redirectForm\" action=\"" + target + "\" method=\"post\">");
        for (Map.Entry<String, String> data : datas.entrySet()) {
            builder.append("<input type=\"hidden\" name=\"").append(data.getKey()).append("\" value=\"").append(data.getValue()).append("\"/>");
        }
        builder.append("</form>");
        return builder.toString();
    }
}
