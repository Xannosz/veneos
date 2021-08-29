package hu.xannosz.veneos.core.html.form;

import hu.xannosz.veneos.core.html.AbstractBox;

import java.util.Map;

public class Form extends AbstractBox {

    public Form(String action, boolean useJs) {
        if (useJs) {
            putMeta("onsubmit", action);
        } else {
            putMeta("action", action);
            putMeta("method", "post");
        }
    }

    public Form setDatas(Map<String, String> datas) {
        for (Map.Entry<String, String> data : datas.entrySet()) {
            Input input = new Input("hidden");
            input.setName(data.getKey());
            input.setValue(data.getValue());
            add(input);
        }
        return this;
    }

    @Override
    protected String getTag() {
        return "form";
    }

}
