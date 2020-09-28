package hu.xannosz.veneos.core.html;

import hu.xannosz.veneos.core.Page;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBox extends HtmlComponent {

    private final List<HtmlComponent> components = new ArrayList<>();

    public AbstractBox add(HtmlComponent component) {
        components.add(component);
        return this;
    }

    @Override
    protected String getContent() {
        StringBuilder builder = new StringBuilder();
        for (HtmlComponent component : components) {
            builder.append(component.getSyntax());
        }
        return builder.toString();
    }
}
