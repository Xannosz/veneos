package hu.xannosz.veneos.trie;

import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.structure.Page;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseBody {

    public ResponseBody(Page page) {
        this.page = page.getSyntax();
        hasPage = true;
    }

    public ResponseBody(ComponentStruct... components) {
        this.components = Arrays.asList(components);
        hasComponents = true;
    }

    public ResponseBody(Collection<ComponentStruct> components) {
        this.components = new ArrayList<>(components);
        hasComponents = true;
    }

    private boolean hasPage = false;
    private boolean hasComponents = false;
    private String page;
    private List<ComponentStruct> components;

    @Data
    @NoArgsConstructor
    public static class ComponentStruct {

        public ComponentStruct(HtmlClass clazz, HtmlComponent component) {
            this.clazz = clazz.getSyntax();
            this.component = component.getSyntax();
        }

        private String clazz;
        private String component;
    }
}
