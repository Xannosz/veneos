package hu.xannosz.veneos.core.html.table;

import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.ArrayList;

public class Table extends HtmlComponent {

    private final java.util.List<java.util.List<HtmlComponent>> rows = new ArrayList<>();
    private java.util.List<HtmlComponent> actualRow = new ArrayList<>();
    private final java.util.List<HtmlComponent> headRow = new ArrayList<>();
    private final java.util.List<Col> cols = new ArrayList<>();
    private HtmlComponent caption = new StringComponent("");

    public Table newRow() {
        if (!actualRow.isEmpty()) {
            rows.add(actualRow);
            actualRow = new ArrayList<>();
        }
        return this;
    }

    public Table add(HtmlComponent component) {
        actualRow.add(component);
        return this;
    }

    public Table add(String component) {
        return add(new StringComponent(component));
    }

    public Table addHead(HtmlComponent component) {
        headRow.add(component);
        return this;
    }

    public Table addHead(String component) {
        return addHead(new StringComponent(component));
    }

    public Table setCaption(HtmlComponent component) {
        caption = component;
        return this;
    }

    public Table setCaption(String component) {
        return setCaption(new StringComponent(component));
    }

    public Table addCol(Col col) {
        cols.add(col);
        return this;
    }

    @Override
    protected String getTag() {
        return "table";
    }

    @Override
    protected String getContent() {
        newRow();
        StringBuilder builder = new StringBuilder();
        builder.append("<caption>");
        builder.append(caption.getSyntax());
        builder.append("</caption>");
        if (!cols.isEmpty()) {
            builder.append("<colgroup>");
            for (Col col : cols) {
                builder.append(col.getSyntax());
            }
            builder.append("</colgroup>");
        }
        builder.append("<tr>");
        for (HtmlComponent comp : headRow) {
            builder.append("<th>");
            builder.append(comp.getSyntax());
            builder.append("</th>");
        }
        builder.append("</tr>");
        for (java.util.List<HtmlComponent> row : rows) {
            builder.append("<tr>");
            for (HtmlComponent comp : row) {
                builder.append("<td>");
                builder.append(comp.getSyntax());
                builder.append("</td>");
            }
            builder.append("</tr>");
        }
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
