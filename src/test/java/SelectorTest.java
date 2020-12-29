import hu.xannosz.veneos.core.css.selector.HtmlSelector;
import hu.xannosz.veneos.core.css.selector.PseudoClass;
import hu.xannosz.veneos.core.css.selector.PseudoElement;
import org.junit.Assert;
import org.junit.Test;

public class SelectorTest {

    @Test
    public void testAttributeSelector() {
        Assert.assertEquals("a[target]:hover", HtmlSelector.A.getSelector().withAttribute("target").addPseudoClass(PseudoClass.HOVER).getSyntax());
        Assert.assertEquals("div[test=\"testValue\"]::first-letter", HtmlSelector.DIV.getSelector().withAttributeEquals("test", "testValue").addPseudoElement(PseudoElement.FIRST_LETTER).getSyntax());
    }
}
