package hu.xannosz.veneos.trie;

import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.handler.HttpHandler;
import hu.xannosz.veneos.core.html.structure.Page;

import java.util.Map;

public class DefaultTryHttpHandler implements HttpHandler {
    @Override
    public Douplet<Integer, Page> getResponse(RequestMethod requestMethod, String requestURI, Map<String, String> requestMap) {
        Page page = new Page();

        page.setTitle("title");
        page.addScript(
                "function createCookie(name, value, days) {\n" +
                        "    var expires;\n" +
                        "    if (days) {\n" +
                        "        var date = new Date();\n" +
                        "        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));\n" +
                        "        expires = \"; expires=\" + date.toGMTString();\n" +
                        "    } else {\n" +
                        "        expires = \"\";\n" +
                        "    }\n" +
                        "    document.cookie = name + \"=\" + value + expires + \"; path=/\";\n" +
                        "}\n" +
                        "\n" +
                        "function getCookie(name) {\n" +
                        "    var dc = document.cookie;\n" +
                        "    var prefix = name + \"=\";\n" +
                        "    var begin = dc.indexOf(\"; \" + prefix);\n" +
                        "    if (begin == -1) {\n" +
                        "        begin = dc.indexOf(prefix);\n" +
                        "        if (begin != 0) return null;\n" +
                        "    } else {\n" +
                        "        begin += 2;\n" +
                        "        var end = document.cookie.indexOf(\";\", begin);\n" +
                        "        if (end == -1) {\n" +
                        "            end = dc.length;\n" +
                        "        }\n" +
                        "    }\n" +
                        "    return decodeURI(dc.substring(begin + prefix.length, end));\n" +
                        "} \n" +
                        "\n" +
                        "function loading() {\n" +
                        "    var veneosCookie = getCookie('veneosSessionID');\n" +
                        "\n" +
                        "    if (veneosCookie == null) {\n" +
                        "        console.log('null');\n" +
                        "        createCookie('veneosSessionID', 'value', 2);\n" +
                        "    } else {\n" +
                        "        console.log(veneosCookie);\n" +
                        "    }\n" +
                        "}\n" +

                        "window.onload = loading;"

        );

        return new Douplet<>(200, page);
    }
}
