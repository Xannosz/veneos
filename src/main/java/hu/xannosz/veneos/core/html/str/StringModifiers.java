package hu.xannosz.veneos.core.html.str;

public enum StringModifiers {

    B, BDI, BR, CITE, CODE, DEL, DFN, EM, HR, I, INS, KBD, MARK,//
    PRE, Q, S, SAMP, SMALL, STRONG, SUB, SUP, TIME, U, VAR, WBR;

    public String set(String element) {
        return "<" + name().toLowerCase() + ">" + element + "</" + name().toLowerCase() + ">";
    }

    @Override
    public String toString() {
        return "<" + name().toLowerCase() + ">";
    }
}
