package hu.xannosz.veneos.demo;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.box.*;
import hu.xannosz.veneos.core.html.form.*;
import hu.xannosz.veneos.core.html.gauge.Meter;
import hu.xannosz.veneos.core.html.gauge.Progress;
import hu.xannosz.veneos.core.html.list.Data;
import hu.xannosz.veneos.core.html.list.DescriptionList;
import hu.xannosz.veneos.core.html.list.List;
import hu.xannosz.veneos.core.html.media.Object;
import hu.xannosz.veneos.core.html.media.*;
import hu.xannosz.veneos.core.html.misc.Iframe;
import hu.xannosz.veneos.core.html.misc.Time;
import hu.xannosz.veneos.core.html.ruby.Rt;
import hu.xannosz.veneos.core.html.ruby.Ruby;
import hu.xannosz.veneos.core.html.str.*;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.core.html.table.Table;

public class DefaultHtmlPage {
    public static Page createDefaultHtmlPage() {
        Page page = new Page();
        page.setTitle("TEST HTML PAGE");
        page.addMetaTag("description", "Most of HTML5 tags");
        page.addMetaTag("keywords", "HTML5, tags");
        page.addMetaTag("author", "xannosz");
        page.addMetaTag("viewport", "width=device-width, initial-scale=1.0");
        page.addComponent(createHeader());
        page.addComponent(createMain());
        page.addComponent(new P("This is a ").add(StringModifiers.Q.set("short quote")));
        page.addComponent(new Blockquote("Some People", "This instead is a long quote that is going to use a lot of words and also cite who said that."));
        page.addComponent(new List(List.ListType.OL)
                .add(new Data("21053", "data tag"))
                .add(new Data("23452", "data tag"))
                .add(new Data("42545", "data tag"))
                .add("List item").add("List item").add("List item")
        );
        page.addComponent(new List(List.ListType.UL)
                .add("List item").add("List item").add("List item")
                .add("List item").add("List item").add("List item")
        );
        page.addComponent(StringModifiers.HR.toString());
        page.addComponent(new Template().add(new H(2, "Hidden content (after page loaded).")));
        page.addComponent(createVideo());
        page.addComponent(new Object("flashmovie.swf").setType("application/x-shockwave-flash").add("Please install the Shockwave plugin to watch this movie."));
        page.addComponent(StringModifiers.PRE.set(" \n" +
                "                                       _,'/\n" +
                "                                  _.-''._:\n" +
                "                          ,-:`-.-'    .:.|\n" +
                "                         ;-.''       .::.|\n" +
                "          _..------.._  / (:.       .:::.|\n" +
                "       ,'.   .. . .  .`/  : :.     .::::.|\n" +
                "     ,'. .    .  .   ./    \\ ::. .::::::.|\n" +
                "   ,'. .  .    .   . /      `.,,::::::::.;\\\n" +
                "  /  .            . /       ,',';_::::::,:_:\n" +
                " / . .  .   .      /      ,',','::`--'':;._;\n" +
                ": .             . /     ,',',':::::::_:'_,'\n" +
                "|..  .   .   .   /    ,',','::::::_:'_,'\n" +
                "|.              /,-. /,',':::::_:'_,'\n" +
                "| ..    .    . /) /-:/,'::::_:',-'\n" +
                ": . .     .   // / ,'):::_:',' ;\n" +
                " \\ .   .     // /,' /,-.','  ./\n" +
                "  \\ . .  `::./,// ,'' ,'   . /\n" +
                "   `. .   . `;;;,/_.'' . . ,'\n" +
                "    ,`. .   :;;' `:.  .  ,'\n" +
                "   /   `-._,'  ..  ` _.-'\n" +
                "  (     _,'``------'' \n" +
                "   `--''\n" +
                " \n" +
                "  "));
        page.addComponent(StringModifiers.CODE.set("// code tag\n" +
                "    #include <iostream>\n" +
                " \n" +
                "    using namespace std;\n" +
                " \n" +
                "    int main()\n" +
                "    {\n" +
                "        cout << \"Hello World!\" << endl;\n" +
                "        return 0;\n" +
                "    }"));
        page.addComponent(new P(StringModifiers.VAR.set(" variable ") + " = 1000;")
                .add(StringModifiers.SAMP.set("Traceback (most recent call last):"
                        + StringModifiers.BR + "NameError: name 'variabl' is not defined"
                )));
        page.addComponent(createTable());
        page.addComponent(new P("A " + StringModifiers.DFN.set("definition") + " is an explanation of the meaning of a word or phrase."));
        page.addComponent(new Details().addSummary("Summary of content below")
                .add(new P("Content 1"))
                .add(new P("Content 2"))
                .add(new P("Content 3"))
                .add(new P("Content 4"))
        );
        page.addComponent(new Section().add(new H(1, "Content")).add(new P("Informations about content.")));
        page.addComponent(new Progress(33, 100));
        page.addComponent(new Meter("25 out of 45", 11).setMin(0).setMax(45).setOptimum(40));
        page.addComponent(new P("2+2 = ").add(new Output("4", "").add("4")));
        page.addComponent(new Select("select1").add(
                new Optgroup("Choice [1-3]").add(new Option("1", "One"))
                        .add(new Option("2", "Two")).add(new Option("3", "Three"))
                ).add(
                new Optgroup("Choice [4-6]").add(new Option("4", "Four"))
                        .add(new Option("5", "Five")).add(new Option("6", "Six"))
                )
        );
        page.addComponent(new Div().add(new Div().add(new P("div > div > p"))));
        page.addComponent(new Svg(100, 100)
                .addCircle(50, 50, 40, "green", 4, "yellow"));
        page.addComponent(StringModifiers.BR.toString());
        page.addComponent(new Audio().addControls().add("I'm sorry. You're browser doesn't support HTML5 " +
                StringModifiers.CODE.set("audio") + ".")
                .add(new Source("https://archive.org/download/ReclaimHtml5/ReclaimHtml5.ogg", "audio/ogg"))
                .add(new Source("https://archive.org/download/ReclaimHtml5/ReclaimHtml5.mp3", "audio/mpeg")));
        page.addComponent(new Iframe("https://open.spotify.com/embed?uri=spotify%3Atrack%3A67HxeUADW4H3ERfaPW59ma?si=PogFcGg9QqapyoPbn2lVOw", "iFrameTitle")
                .putMeta("width", 300).putMeta("height", 380).putMeta("frameborder", 0).putMeta("allowtransparency", "true")
        );
        page.addComponent(createArticle());
        page.addComponent(createForm1());
        page.addComponent(new Aside().add(new P("P inside ASIDE tag")));
        page.addComponent(new Map("shapesmap").add(new Area("rect", "29,32,230,215", "#square", "Square"))
                .add(new Area("circle", "360,130,100", "#circle", "Circle"))
        );
        page.addComponent(new Img("https://placehold.it/100x100"));
        page.addComponent(createForm2());
        return page;
    }

    private static HtmlComponent createHeader() {
        Header header = new Header();
        Nav nav = new Nav();
        nav.add(new P("HEADER"));
        nav.add(new A("http://www.google.com", "Google"));
        header.add(nav);
        return header;
    }

    private static HtmlComponent createMain() {
        Main main = new Main();
        main.add(new H(1, "Heading..."));
        main.add(new H(2, "Heading..."));
        main.add(new H(3, "Heading..."));
        main.add(new H(4, "Heading..."));
        main.add(new H(5, "Heading..."));
        main.add(new H(6, "Heading..."));
        P paragraph = new P("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus nisi lacus, auctor sit amet purus vel, gravida luctus lectus. Aenean rhoncus dapibus enim, sit amet faucibus leo ornare vitae." + StringModifiers.BR);
        paragraph.add(new Span("span"))
                .add("\n" + StringModifiers.B.set("Bold word"))
                .add("\n" + StringModifiers.I.set("italic"))
                .add("\n" + StringModifiers.EM.set("emphasis"))
                .add("\n" + StringModifiers.MARK.set("mark"))
                .add("\n" + StringModifiers.SMALL.set("small"))
                .add("\n" + StringModifiers.SUB.set("sub"))
                .add("\n" + StringModifiers.SUP.set("sup"))
                .add("\n" + StringModifiers.U.set("Statements..."))
                .add(new Abbr("National Aeronautics and Space Administration", "NASA"))
                .add(new Span(StringModifiers.DEL.set("deprecated info") + StringModifiers.INS.set("new info")))
                .add(StringModifiers.S.set("not relevant"))
                .add(new A("#link", "link"))
                .add(new Time("2020-08-17 08:00", "Monday at 8:00 AM"))
                .add(new Ruby().add("ruby base").add(new Rt().add("annotation")))
                .add(StringModifiers.BR.toString())
                .add(StringModifiers.KBD.set("CTRL") + "+" + StringModifiers.KBD.set("ALT") + "+" + StringModifiers.KBD.set("CANC"))
        ;
        main.add(paragraph);
        return main;
    }

    private static HtmlComponent createVideo() {
        Video video = new Video().setWidth(640).setHeight(480).addControls()
                .setSrc("https://archive.org/download/Popeye_forPresident/Popeye_forPresident_512kb.mp4");
        video.add(new Track("subtitles_de.vtt", "subtitles", "de", "Subtitle de"));
        video.add(new Track("subtitles_en.vtt", "subtitles", "en", "Subtitle en"));
        video.add(new Track("subtitles_ja.vtt", "subtitles", "ja", "Subtitle ja"));
        video.add("Sorry, your browser doesn't support HTML5 <code>video</code>, but you can download this video from the ");
        video.add(new A("https://archive.org/details/Popeye_forPresident", "Internet Archive").setTarget("_blank"));
        return video;
    }

    private static HtmlComponent createTable() {
        Table table = new Table();
        table.addHeadCell("Numbers").addHeadCell("Letters").addHeadCell("Colors");
        table.addFootCell("123").addFootCell("ABC").addFootCell("RGB");
        table.addCell("1").addCell("A").addCell("Red").newRow();
        table.addCell("2").addCell("B").addCell("Green").newRow();
        table.addCell("3").addCell("C").addCell("Blue").newRow();
        return table;
    }

    private static HtmlComponent createArticle() {
        Article article = new Article();
        article.add(new Header()
                .add(new H(2, "Title of Article"))
                .add(new Span("by Arthur T. Writer"))
        );
        article.add(new P("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat sollicitudin nisi, at convallis nunc semper et. Donec ultrices odio ac purus facilisis, at mollis urna finibus."));
        article.add(new Figure().add(new Img("https://placehold.it/600x300"))
                .add(new Figcaption("Caption.")));
        article.add(new Footer().add(new DescriptionList().add("Published", "17 August 2020")
                .add("Tags", "Sample Posts, html example")));
        return article;
    }

    private static HtmlComponent createForm1() {
        Fieldset fieldset = new Fieldset();
        fieldset.add(new Legend("Personal Information"));
        fieldset.add(new Label("name", "Name"));
        fieldset.add(StringModifiers.BR.toString());
        fieldset.add(new Input("text").setName("name"));
        fieldset.add(StringModifiers.BR.toString());
        fieldset.add(new Label("dob", "Date of Birth"));
        fieldset.add(StringModifiers.BR.toString());
        fieldset.add(new Input("date").setName("dob"));
        return new Form("", false).add(fieldset);
    }

    private static HtmlComponent createForm2() {
        Form form = (Form) new Form("", false).putMeta("method", "get");
        form.add(new Label("browser", "Choose your browser from the list:"));
        form.add(new Input("list").putMeta("list", "browsers")
                .putMeta("name", "browser")
        );
        form.add(new DataList()
                .add(new Option("Edge", "Edge"))
                .add(new Option("Firefox", "Firefox"))
                .add(new Option("Chrome", "Chrome"))
                .add(new Option("Opera", "Opera"))
                .add(new Option("Safari", "Safari"))
                .putMeta("id", "browsers"));
        form.add(new Input("submit"));
        return form;
    }
}
