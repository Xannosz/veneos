package hu.xannosz.veneos.core.html.box;

import hu.xannosz.veneos.core.html.AbstractBox;
import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.InlineComponent;

public class Details extends AbstractBox {

    public void addSummary(String summary) {
        add(new Summary(summary));
    }

    public void addSummary(HtmlComponent summary) {
        add(new Summary(summary));
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
