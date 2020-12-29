package hu.xannosz.veneos.core.html.list;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DescriptionList extends HtmlComponent {

    private Map<HtmlComponent, HtmlComponent> components = new HashMap<>();

    public void add(HtmlComponent title, HtmlComponent description) {
        components.put(title, description);
    }

    public void add(String title, HtmlComponent description) {
        add(new StringHtmlComponent(title), description);
    }

    public void add(HtmlComponent title, String description) {
        add(title, new StringHtmlComponent(description));
    }

    public void add(String title, String description) {
        add(new StringHtmlComponent(title), new StringHtmlComponent(description));
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

}
