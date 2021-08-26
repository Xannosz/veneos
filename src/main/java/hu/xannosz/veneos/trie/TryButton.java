package hu.xannosz.veneos.trie;

import hu.xannosz.veneos.core.html.form.Button;
import hu.xannosz.veneos.util.Scripts;

import java.util.HashMap;
import java.util.Map;

public class TryButton extends Button {
/*    public TryButton(String token, HtmlComponent element, Page page ) {
        super(action, element, true);
    }*/

    public TryButton(String eventId, String element) {
        this(eventId, new HashMap<>(), element);
    }

    public TryButton(String eventId, Map<String, Object> additionalParams, String element) {
        super(element, Scripts.getScriptAsSelfExecutor(Scripts.getCallRestScript(
                RequestTypes.BUTTON_REQUEST, eventId, additionalParams)));
    }
}
