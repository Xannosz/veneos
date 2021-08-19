package hu.xannosz.veneos.util;

import hu.xannosz.microtools.Json;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class Scripts {

    public static String getScriptAsSelfExecutor(String script) {
        return "(function (){\n" + script + "\n})()";
    }

    public static String getCallRestScript(String loopBackURI, String requestType, String eventId, Map<String, Object> additionalParams, String additionalScript) {
        return "req = {};\n" +
                "req.requestType = '" + requestType + "';\n" +
                "req.sessionId = 'sessionId';\n" +
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

                "const response = fetch('" + loopBackURI + "/internal', data).then(response => response.json()).then(data => {\n" +
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
                "  })\n";
    }
}
