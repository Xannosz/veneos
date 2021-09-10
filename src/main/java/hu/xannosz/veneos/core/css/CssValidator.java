package hu.xannosz.veneos.core.css;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
public class CssValidator {

    private static final Map<CssProperty, Function<String, Boolean>> validators = new HashMap<>();
    private static final Map<CssProperty, String> helpers = new HashMap<>();

    public static void validate(CssProperty property, String value) {
        if (validators.containsKey(property) && !validators.get(property).apply(value)) {
            log.warn(property + ": " + value + " is invalid.", "Valid " + property + ":\n" + helpers.get(property));
        }
    }
}
