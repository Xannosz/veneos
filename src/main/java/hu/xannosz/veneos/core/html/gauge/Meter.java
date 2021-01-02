package hu.xannosz.veneos.core.html.gauge;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Meter extends InlineComponent {

    public Meter(String element, int value) {
        super(element);
        putMeta("value", value);
    }

    public Meter(HtmlComponent element, int value) {
        super(element);
        putMeta("value", value);
    }

    public Meter setMin(int min){
        putMeta("min", min);
        return this;
    }

    public Meter setMax(int max){
        putMeta("max", max);
        return this;
    }

    public Meter setOptimum(int optimum){
        putMeta("optimum", optimum);
        return this;
    }

    @Override
    protected String getTag() {
        return "meter";
    }

}
