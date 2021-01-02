package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.SingleHtmlComponent;

public class Input extends SingleHtmlComponent {

    public Input(String type) {
        putMeta("type", type);
    }

    public Input setName(String name) {
        return (Input) putMeta("name", name);
    }

    public Input setValue(String value) {
        return (Input) putMeta("value", value);
    }

    @Override
    protected String getTag() {
        return "input";
    }

}
