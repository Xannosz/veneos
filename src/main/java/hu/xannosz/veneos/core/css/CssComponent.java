package hu.xannosz.veneos.core.css;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.Map.Entry;

public class CssComponent {

    private final List<Selector> selectors;
    private final Map<CssProperty, String> properties = new HashMap<>();

    public CssComponent(HtmlSelector selector) {
        this.selectors = Collections.singletonList(selector.getSelector());
    }

    public CssComponent(Selector... selectors) {
        this.selectors = Arrays.asList(selectors);
    }

    public CssComponent addProperty(CssProperty property, String value) {
        properties.put(property, value);
        return this;
    }

    public String getSyntax() {
        StringBuilder builder = new StringBuilder();
        for (Entry<CssProperty, String> property : properties.entrySet()) {
            builder.append(property.getKey().getSyntax());
            builder.append(": ");
            builder.append(property.getValue());
            builder.append(";");
        }
        return toSyntax(selectors) + " {" + builder.toString() + "}";
    }

    private String toSyntax(List<Selector> selectors) {
        return StringUtils.join(selectors.stream().map(Selector::getSyntax).distinct().toArray(String[]::new), ", ");
    }

}
