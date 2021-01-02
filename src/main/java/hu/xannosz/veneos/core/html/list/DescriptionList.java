package hu.xannosz.veneos.core.html.list;

import hu.xannosz.veneos.core.html.HtmlComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DescriptionList extends HtmlComponent {

    private final Map<HtmlComponent, HtmlComponent> components = new HashMap<>();

    public DescriptionList add(HtmlComponent title, HtmlComponent description) {
        components.put(title, description);
        return this;
    }

    public DescriptionList add(String title, HtmlComponent description) {
        add(new StringComponent(title), description);
        return this;
    }

    public DescriptionList add(HtmlComponent title, String description) {
        add(title, new StringComponent(description));
        return this;
    }

    public DescriptionList add(String title, String description) {
        add(new StringComponent(title), new StringComponent(description));
        return this;
    }

    @Override
    protected String getTag() {
        return "dl";
    }

    @Override
    protected String getContent() {
        StringBuilder builder = new StringBuilder();
        for (Entry<HtmlComponent, HtmlComponent> component : components.entrySet()) {
            builder.append("<dt>");
            builder.append(component.getKey().getSyntax());
            builder.append("</dt><dd>");
            builder.append(component.getValue().getSyntax());
            builder.append("</dd>");
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
