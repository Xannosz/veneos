package hu.xannosz.veneos.trie;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.next.OneButtonForm;
import hu.xannosz.veneos.util.Scripts;

import java.util.HashMap;
import java.util.Map;

public class TryButton extends OneButtonForm {
/*    public TryButton(String token, HtmlComponent element, Page page ) {
        super(action, element, true);
    }*/

    public TryButton(String loopBackURI, String eventId, String element) {
        this(loopBackURI,  eventId, new HashMap<>(), element);
    }
    public TryButton(String loopBackURI, String eventId, Map<String, Object> additionalParams, String element) {
        super(Scripts.getScriptAsSelfExecutor(Scripts.getCallRestScript(
                loopBackURI,  RequestTypes.BUTTON_TYPE,  eventId, additionalParams,
                        ""
                )),
                element, true);
    }
}
