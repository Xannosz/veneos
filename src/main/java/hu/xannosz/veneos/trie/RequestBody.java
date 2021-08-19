package hu.xannosz.veneos.trie;

import lombok.Data;

import java.util.Map;

@Data
public class RequestBody {
    private String requestType;

    private String sessionId;
    private String eventId;

    private Map<String,Object> additionalParams;
}
