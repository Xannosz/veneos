package hu.xannosz.veneos.core.html.list;

import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.ArrayList;

public class List extends HtmlComponent {

    private final ListType type;
    private final java.util.List<HtmlComponent> components = new ArrayList<>();

    public List(ListType type) {
        this.type = type;
    }

    public void add(HtmlComponent component) {
        components.add(component);
    }

    public void add(String component) {
        components.add(new StringComponent(component));
    }

    @Override
    protected String getTag() {
        if (type == ListType.OL) {
            return "ol";
        }
        return "ul";
    }

    @Override
    protected String getContent() {
        StringBuilder builder = new StringBuilder();
        for (HtmlComponent component : components) {
            builder.append("<li>");
            builder.append(component.getSyntax());
            builder.append("</li>");
        }
        return builder.toString();
    }

    public enum ListType {
        OL, UL
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
