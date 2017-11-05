package enshud.s4.compiler.Helper.Output;

public class Write {
    private String buf;

    void addLine(String label, String order, String op) {
        if (buf != null) {
            buf += label + "\t" + order + "\t" + op + "\n";
        } else {
            buf = label + "\t" + order + "\t" + op + "\n";
        }
    }

    void addLine(String order, String op) {
        if (buf != null) {
            buf += "\t" + order + "\t" + op + "\n";
        } else {
            buf = "\t" + order + "\t" + op + "\n";
        }
    }

    void addLabel(String label) {
        buf += label;
    }

    public String getBuf() {
        return buf;
    }
}
