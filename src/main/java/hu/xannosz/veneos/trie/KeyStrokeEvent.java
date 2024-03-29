package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.Json;
import lombok.Data;

import java.util.Map;

@Data
public class KeyStrokeEvent {
    public static final String KEY_STROKE_EVENT_ADDITIONAL_PARAMS_KEY = "keyStrokeEvent";

    private boolean altKey;
    private boolean ctrlKey;
    private boolean metaKey;
    private boolean shiftKey;
    private String key;
    private String code;
    private int keyCode;

    public static KeyStrokeEvent getFromMap(Map<String, Object> additionalParams) {
        return Json.castObjectToSpecificClass(additionalParams.get(KEY_STROKE_EVENT_ADDITIONAL_PARAMS_KEY), KeyStrokeEvent.class);
    }
}
