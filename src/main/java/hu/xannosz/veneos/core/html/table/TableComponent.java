package hu.xannosz.veneos.core.html.table;

import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.ArrayList;

public class TableComponent {
    private final java.util.List<java.util.List<HtmlComponent>> rows = new ArrayList<>();
    private java.util.List<HtmlComponent> actualRow = new ArrayList<>();
    private final String tag;
    private final String td;

    public TableComponent(String tag) {
        this(tag,"td");
    }

    public TableComponent(String tag, String td) {
        this.tag = tag;
        this.td = td;
    }

    public void newRow() {
        if (!actualRow.isEmpty()) {
            rows.add(actualRow);
            actualRow = new ArrayList<>();
        }
    }

    public void add(HtmlComponent component) {
        actualRow.add(component);
    }

    public void add(String component) {
        add(new StringComponent(component));
    }

    protected String getSyntax() {
        newRow();
        if(rows.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder("<" + tag + ">");
        for (java.util.List<HtmlComponent> row : rows) {
            builder.append("<tr>");
            for (HtmlComponent comp : row) {
                builder.append("<").append(td).append(">");
                builder.append(comp.getSyntax());
                builder.append("</").append(td).append(">");
            }
            builder.append("</tr>");
        }
        builder.append("</").append(tag).append(">");
        return builder.toString();
    }

    private static class StringComponent extends HtmlComponent {
        private final String component;

        public StringComponent(String component) {
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
}
