package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.Json;
import lombok.Data;

import java.util.Map;

@Data
public class RequestBody {
    private String requestType;

    private String sessionId;
    private String eventId;

    private Map<String, Object> additionalParams;

    public <T> T getAdditionalParam(String key, Class<T> clazz) {
        return Json.castObjectToSpecificClass(additionalParams.get(key), clazz);
    }
}
