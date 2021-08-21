package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.Json;
import lombok.Data;

import java.util.Map;

@Data
public class KeyStrokeEvent {
    public static final String ADDITIONAL_PARAMS_KEY = "event";

    private boolean altKey;
    private boolean ctrlKey;
    private boolean metaKey;
    private boolean shiftKey;
    private String key;
    private String code;
    private int keyCode;

    public static KeyStrokeEvent getFromMap(Map<String, Object> additionalParams) {
        return Json.readData(Json.writeData(additionalParams.get(ADDITIONAL_PARAMS_KEY)), KeyStrokeEvent.class);
    }
}
