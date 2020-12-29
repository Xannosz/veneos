package hu.xannosz.veneos.core.css;

import hu.xannosz.veneos.core.DefaultLogHandler;
import hu.xannosz.veneos.core.LogHandler;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CssValidator {

    @Setter
    private static LogHandler logger = new DefaultLogHandler();

    private static final Map<CssProperty, Function<String, Boolean>> validators = new HashMap<>();
    private static final Map<CssProperty, String> helpers = new HashMap<>();

    public static void validate(CssProperty property, String value) {
        if (validators.containsKey(property) && !validators.get(property).apply(value)) {
            logger.warn(property + ": " + value + " is invalid.", "Valid " + property + ":\n" + helpers.get(property));
        }
    }
}
