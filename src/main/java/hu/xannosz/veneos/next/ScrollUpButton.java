package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.Page;
import hu.xannosz.veneos.core.html.HtmlComponent;

public class ScrollUpButton extends FixedButton {

    public ScrollUpButton(HtmlComponent element, ButtonPosition position, Page page) {
        this(element, position, page, 60);
    }

    public ScrollUpButton(HtmlComponent element, ButtonPosition position, Page page, int seeAfter) {
        super("topFunction()", element, position,true);
        page.addScript("window.onscroll = function() {\n" +
                "\tscrollFunction()\n" +
                "};\n" +
                "\n" +
                "function scrollFunction() {\n" +
                "\tif (document.body.scrollTop > " + seeAfter + " || document.documentElement.scrollTop > " + seeAfter + ") {\n" +
                "\t\tdocument.getElementById(\"" + getID().getSyntax() + "\").style.display = \"block\";\n" +
                "\t} else {\n" +
                "\t\tdocument.getElementById(\"" + getID().getSyntax() + "\").style.display = \"none\";\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function topFunction() {\n" +
                "\tdocument.body.scrollTop = 0;\n" +
                "\tdocument.documentElement.scrollTop = 0;\n" +
                "}");
    }

    public ScrollUpButton(String element, ButtonPosition position, Page page) {
        this(element, position, page, 60);
    }

    public ScrollUpButton(String element, ButtonPosition position, Page page, int seeAfter) {
        super("topFunction()", element, position,true);
        page.addScript("window.onscroll = function() {\n" +
                "\tscrollFunction()\n" +
                "};\n" +
                "\n" +
                "function scrollFunction() {\n" +
                "\tif (document.body.scrollTop > " + seeAfter + " || document.documentElement.scrollTop > " + seeAfter + ") {\n" +
                "\t\tdocument.getElementById(\"" + getID().getSyntax() + "\").style.display = \"block\";\n" +
                "\t} else {\n" +
                "\t\tdocument.getElementById(\"" + getID().getSyntax() + "\").style.display = \"none\";\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function topFunction() {\n" +
                "\tdocument.body.scrollTop = 0;\n" +
                "\tdocument.documentElement.scrollTop = 0;\n" +
                "}");
    }
}
