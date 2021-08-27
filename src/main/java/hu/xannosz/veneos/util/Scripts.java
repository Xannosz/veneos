package hu.xannosz.veneos.util;

import hu.xannosz.microtools.FileResourcesUtils;
import hu.xannosz.microtools.Json;
import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.trie.RequestTypes;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static hu.xannosz.veneos.trie.KeyStrokeEvent.ADDITIONAL_PARAMS_KEY;
import static hu.xannosz.veneos.trie.RequestTypes.REFRESH_REQUEST;

@UtilityClass
public class Scripts {

    public static String getScriptAsSelfExecutor(String script) {
        return "(function (){\n" + script + "\n})()";
    }

    public static String getCallRestScript(String requestType, String eventId) {
        return getCallRestScript(requestType, eventId, new HashMap<>());
    }

    public static String getCallRestScript(String requestType, String eventId, Map<String, Object> additionalParams) {
        return getCallRestScript(requestType, eventId, additionalParams, "");
    }

    public static String getCallRestScript(String requestType, String eventId, Map<String, Object> additionalParams, String additionalScript) {
        return getCookieScript() +
                "\n" +
                "req = {};\n" +
                "req.requestType = '" + requestType + "';\n" +
                "req.sessionId = getCookie('veneosSessionID');\n" +
                "req.eventId = '" + eventId + "';\n" +
                "req.additionalParams = " + Json.writeData(additionalParams) + ";\n\n" +

                additionalScript +

                "\n\ndata = {\n" +
                "  method: 'POST',\n" +
                "  headers: {\n" +
                "    'Content-Type': 'application/json'\n" +
                "  }\n" +
                "};" +
                "data.body = JSON.stringify(req);\n" +

                "const response = fetch('/internal', data).then(function(response) {\n" +
                "  response.json().then(function(data) {\n" +
                "    if(data.hasPage){\n" +
                "      document.open();\n" +
                "      document.write(data.page);\n" +
                "      document.close();\n" +
                "    }\n" +
                "    if(data.hasComponents){\n" +
                "      for (const comp of data.components) {\n" +
                "        for (const elem of document.getElementsByClassName(comp.clazz)) {\n" +
                "          div = document.createElement('div');\n" +
                "          div.innerHTML = comp.component.trim();\n" +
                "          elem.replaceWith(div.firstChild);\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  });\n" +
                "});\n";
    }

    public static String getCookieScript() {
        return FileResourcesUtils.getFileFromResourceAsString("js/getCookie.js");
    }

    public static String getStarterScript() {
        return "function loading() {\n" +
                "    var veneosCookie = getCookie('veneosSessionID');\n" +
                "    if (veneosCookie == '') {\n" +
                "        document.cookie = 'veneosSessionID=veneosSessionID" +
                ("" + UUID.randomUUID() + UUID.randomUUID() + UUID.randomUUID()).replace("-", "") +
                "; path=/';\n" +
                "    }\n" +
                getCallRestScript(REFRESH_REQUEST, "veneosInternalRefresh") +
                "\n}\n" +
                "window.onload = loading;";
    }

    public static String getAutomaticRefreshScript(int interval) {
        return "window.setTimeout(function() {\n" +
                getCallRestScript(REFRESH_REQUEST, "veneosInternalRefresh") +
                "\n}, " + interval + ");";
    }

    public static String getKeyDownListenerScript(Map<String, Object> additionalParams) {
        return getKeyListenerScript("keydown", additionalParams);
    }

    public static String getKeyPressListenerScript(Map<String, Object> additionalParams) {
        return getKeyListenerScript("keypress", additionalParams);
    }

    public static String getKeyUpListenerScript(Map<String, Object> additionalParams) {
        return getKeyListenerScript("keyup", additionalParams);
    }

    private static String getKeyListenerScript(String event, Map<String, Object> additionalParams) {
        return "document.addEventListener('" + event + "', (event) => {\n" +
                getCallRestScript(RequestTypes.KEY_STROKE_REQUEST, event, additionalParams,
                        "req.additionalParams." + ADDITIONAL_PARAMS_KEY + " = {};\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".altKey = event.altKey;\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".ctrlKey = event.ctrlKey;\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".metaKey = event.metaKey;\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".shiftKey = event.shiftKey;\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".key = event.key;\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".code = event.code;\n" +
                                "req.additionalParams." + ADDITIONAL_PARAMS_KEY + ".keyCode = event.keyCode;\n"
                ) +
                "}, false);";
    }

    public static String getFormSenderScript(String event, HtmlClass clazz, Map<String, Object> additionalParams) {
        return "console.log('start script');"+
                "var formData = new FormData(document.querySelector('."+clazz.getSyntax()+"'));" +
                        "console.log(formData);"+
                getCallRestScript("formData", event, additionalParams,
                        "req.additionalParams.formData = formData;"
                );
    }
}
