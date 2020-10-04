package hu.xannosz.veneos.core.html;

import java.util.Map;

public class Form extends AbstractBox {

    public Form(String action) {
        meta.put("action", action);
        meta.put("method", "post");
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
