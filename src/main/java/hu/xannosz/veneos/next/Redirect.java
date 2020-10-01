package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Redirect extends HtmlComponent {

    private final String target;
    @Setter
    private Map<String, String> datas = new HashMap<>();

    public Redirect(String target) {
        this.target = target;
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
        builder.append("</form><script type=\"text/javascript\">console.log(\"Redirect to ").append(target).append("\");document.redirectForm.submit();</script>");
        return builder.toString();
    }
}
