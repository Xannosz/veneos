package hu.xannosz.veneos.core;

import hu.xannosz.veneos.core.css.CssComponent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Theme {

    @Getter
    private final String id = UUID.randomUUID().toString();
    private final List<CssComponent> components = new ArrayList<>();

    public Theme add(CssComponent component) {
        components.add(component);
        return this;
    }

    public String getSyntax() {
        StringBuilder builder = new StringBuilder();
        for (CssComponent component : components) {
            builder.append(component.getSyntax());
            builder.append("\n");
        }
        return builder.toString();
    }
}
