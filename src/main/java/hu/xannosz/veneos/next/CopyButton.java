package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.structure.Page;

import java.util.UUID;

public class CopyButton extends OneButtonForm {

    public CopyButton(HtmlComponent element, Page page, String text) {
        super(addCopyFunction(page, text), element, true);
    }

    public CopyButton(String element, Page page, String text) {
        super(addCopyFunction(page, text), element, true);
    }

    private static String addCopyFunction(Page page, String text) {
        String action = "func" + UUID.randomUUID().toString().replace("-", "") + "()";
        page.addScript(
                "function " + action + "{" +
                        "const elem = document.createElement('textarea');\n" +
                        "   elem.value = '" + text + "';\n" +
                        "   document.body.appendChild(elem);\n" +
                        "   elem.select();\n" +
                        "   elem.setSelectionRange(0, 99999); /* For mobile devices */\n" +
                        "   document.execCommand('copy');\n" +
                        "   document.body.removeChild(elem);}");
        return action;
    }
}
