package hu.xannosz.veneos.trie;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.next.OneButtonForm;

public class TryButton extends OneButtonForm {
/*    public TryButton(String token, HtmlComponent element, Page page ) {
        super(action, element, true);
    }*/

    public TryButton(String token, String element) {
        super("(function (){\n" +

                "const response =  fetch('http://localhost:8000/internal/token', {\n" +
                "    method: 'POST',\n" +
                "    body: '{}', // string or object\n" +
                "    headers: {\n" +
                "      'Content-Type': 'application/json'\n" +
                "    }\n" +
                "  }).then(response => response.json())\n" +
                ".then(data => {\n" +
                "  console.log('Success:', data);\n" +
                "  console.log('Success:', data.refresh);\n" +
                "        document.open();\n" +
                "        document.write(data.refresh);\n" +
                "        document.close();\n"+
                "})\n" +

/*"<!--"+
                "        document.open();\n" +
                "        document.write('<html><head></head><body>New Content</body></html>');\n" +
                "        document.close();\n"+
"-->"+*/

/*                "             newHTML = document.open(\"text/html\", \"replace\");\n" +
                        "            newHTML.write('<html><head></head><body>New Content</body></html>');\n" +
                        "            newHTML.close();"+*/

                "\n})()", element, true);
    }
}
