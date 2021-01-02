package hu.xannosz.veneos.core.html.table;

import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.ArrayList;

public class Table extends HtmlComponent {

    private final java.util.List<Col> cols = new ArrayList<>();
    private HtmlComponent caption = new StringComponent("");
    private final TableComponent head = new TableComponent("thead", "th");
    private final TableComponent body = new TableComponent("tbody");
    private final TableComponent footer = new TableComponent("tfoot");

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

    public Table newRow() {
        body.newRow();
        return this;
    }

    public Table addCell(HtmlComponent component) {
        body.add(component);
        return this;
    }

    public Table addCell(String component) {
        body.add(component);
        return this;
    }

    public Table newHeadRow() {
        head.newRow();
        return this;
    }

    public Table addHeadCell(HtmlComponent component) {
        head.add(component);
        return this;
    }

    public Table addHeadCell(String component) {
        head.add(component);
        return this;
    }

    public Table newFootRow() {
        footer.newRow();
        return this;
    }

    public Table addFootCell(HtmlComponent component) {
        footer.add(component);
        return this;
    }

    public Table addFootCell(String component) {
        footer.add(component);
        return this;
    }

    @Override
    protected String getTag() {
        return "table";
    }

    @Override
    protected String getContent() {
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
        builder.append(head.getSyntax());
        builder.append(body.getSyntax());
        builder.append(footer.getSyntax());
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
