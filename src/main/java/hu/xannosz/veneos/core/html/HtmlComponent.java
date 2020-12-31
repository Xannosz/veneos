package hu.xannosz.veneos.core.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class HtmlComponent {

    private HtmlID id;

    protected final java.util.List<HtmlClass> clazzes = new ArrayList<>();

    protected final java.util.List<String> metaList = new ArrayList<>();

    protected final Map<String, String> meta = new HashMap<>();

    protected abstract String getTag();

    protected abstract String getContent();

    protected String getMetaSyntax() {
        StringBuilder builder = new StringBuilder();
        for (Entry<String, String> metaTag : meta.entrySet()) {
            builder.append(" ");
            builder.append(metaTag.getKey());
            builder.append("=\"");
            builder.append(metaTag.getValue());
            builder.append("\"");
        }
        return builder.toString();
    }

    protected String getMetaListSyntax() {
        StringBuilder builder = new StringBuilder();
        for (String metaTag : metaList) {
            builder.append(" ");
            builder.append(metaTag);
        }
        return builder.toString();
    }

    private String getIdSyntax() {
        if (id != null) {
            return " id=\"" + id.getSyntax() + "\"";
        } else {
            return "";
        }
    }

    private String getClassSyntax() {
        if (!clazzes.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append(" class=\"");
            for (HtmlClass clazz : clazzes) {
                builder.append(" ");
                builder.append(clazz.getSyntax());
            }
            builder.append("\"");
            return builder.toString();
        } else {
            return "";
        }
    }

    public HtmlID getID() {
        if (id == null) {
            id = new HtmlID();
        }
        return id;
    }

    public HtmlComponent addClass(HtmlClass clazz) {
        clazzes.add(clazz);
        return this;
    }

    public String getSyntax() {
        return "<" + getTag() + getIdSyntax() + getClassSyntax() + getMetaSyntax() + getMetaListSyntax() + ">"
                + getContent() + "</" + getTag() + ">";
    }
}
