package hu.xannosz.veneos.core.css.selector;

public enum HtmlSelector {
    A, ABBR, ADDRESS, AREA, ARTICLE, ASIDE, AUDIO, B, BDI, BDO,//
    BLOCKQUOTE, BODY, BUTTON, BR, CANVAS, CAPTION, CITE, CODE,
    COL, COLGROUP, DATA, DATALIST, DD, DEL, DETAILS, DFN, DIALOG, DIV,//
    DL, DT, EM, EMBED, FIELDSET, FIGCAPTION, FIGURE, FOOTER, FORM,//
    HEADER, HR, H1, H2, H3, H4, H5, H6, I, IFRAME, IMG, INPUT, INS,//
    KBD, LABEL, LEGEND, LI, MAIN, MAP, MARK, METER, NAV, NOSCRIPT, OBJECT, OL,//
    OPTGROUP, OPTION, OUTPUT, P, PICTURE, PRE, PROGRESS, Q, RP, RT,//
    RUBY, S, SAMP, SECTION, SELECT, SMALL, SPAN, STRONG, SUB,//
    SUMMARY, SUP, SVG, TABLE, TBODY, TD, TEXTAREA, TFOOT, TH, //
    THEAD, TIME, TR, U, UL, VAR, VIDEO, WBR;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public Selector getSelector() {
        return new Selector(this);
    }
}
