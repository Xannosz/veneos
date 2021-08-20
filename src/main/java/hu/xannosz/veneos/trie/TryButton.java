package hu.xannosz.veneos.trie;

import hu.xannosz.veneos.next.OneButtonForm;
import hu.xannosz.veneos.util.Scripts;

import java.util.HashMap;
import java.util.Map;

public class TryButton extends OneButtonForm {
/*    public TryButton(String token, HtmlComponent element, Page page ) {
        super(action, element, true);
    }*/

    public TryButton(String eventId, String element) {
        this(eventId, new HashMap<>(), element);
    }
    public TryButton(String eventId, Map<String, Object> additionalParams, String element) {
        super(Scripts.getScriptAsSelfExecutor(Scripts.getCallRestScript(
                RequestTypes.BUTTON_REQUEST,  eventId, additionalParams)),
                element, true);
    }
}
