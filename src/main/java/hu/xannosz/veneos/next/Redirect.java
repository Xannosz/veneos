package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.HashMap;
import java.util.Map;

public class Redirect extends HtmlComponent {

    private final String target;
    private final int waitMillis;

    private Map<String, String> datas = new HashMap<>();

    public Redirect(String target) {
        this(target, 0);
    }

    public Redirect(String target, int waitMillis) {
        this.target = target;
        this.waitMillis = waitMillis;
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
        builder.append("</form><script type=\"text/javascript\">" +
                "function wait(ms){\n" +
                "   var start = new Date().getTime();\n" +
                "   var end = start;\n" +
                "   while(end < start + ms) {\n" +
                "     end = new Date().getTime();\n" +
                "  }\n" +
                "}" +
                "console.log(\"Redirect to ").append(target).append("\");" +
                "document.body.appendChild(wait(").append(waitMillis).append("));document.redirectForm.submit();</script>");
        return builder.toString();
    }
}
