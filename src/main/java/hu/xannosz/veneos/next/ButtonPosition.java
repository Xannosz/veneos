package hu.xannosz.veneos.next;

import lombok.Setter;

public class ButtonPosition {

    @Setter
    private String bottom;
    @Setter
    private String top;
    @Setter
    private String right;
    @Setter
    private String left;

    public ButtonPosition() {

    }

    public ButtonPosition(String bottom, String right) {
        this.bottom = bottom;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("position:fixed;");

        if (bottom != null) {
            builder.append("bottom:").append(bottom).append(";");
        }
        if (top != null) {
            builder.append("top:").append(top).append(";");
        }
        if (right != null) {
            builder.append("right:").append(right).append(";");
        }
        if (left != null) {
            builder.append("left:").append(left).append(";");
        }

        return builder.toString();
    }
}
