package hu.xannosz.veneos.core.html.box;

import hu.xannosz.veneos.core.html.AbstractBox;
import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Details extends AbstractBox {

    public Details addSummary(String summary) {
        return (Details) add(new Summary(summary));
    }

    public Details addSummary(HtmlComponent summary) {
        return (Details) add(new Summary(summary));
    }

    @Override
    protected String getTag() {
        return "details";
    }

    private static class Summary extends InlineComponent {

        public Summary(String summary) {
            super(summary);
        }

        public Summary(HtmlComponent summary) {
            super(summary);
        }

        @Override
        protected String getTag() {
            return "summary";
        }
    }
}
