package hu.xannosz.veneos.trie;

import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.core.html.form.Form;
import hu.xannosz.veneos.util.Scripts;

import java.util.HashMap;
import java.util.Map;

public class TryForm extends Form {

    public TryForm(String eventId) {
        this(eventId, new HashMap<>());
    }

    public TryForm(String eventId, Map<String, Object> additionalParams) {
        this(eventId, new HtmlClass(), additionalParams);
    }

    private TryForm(String eventId, HtmlClass clazz, Map<String, Object> additionalParams) {
        super(Scripts.getScriptAsSelfExecutor(
                Scripts.getFormSenderScript(eventId, clazz, additionalParams)) + "return false;", true);
        addClass(clazz);
    }
}
