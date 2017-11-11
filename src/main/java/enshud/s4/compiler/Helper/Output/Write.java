package enshud.s4.compiler.Helper.Output;

public class Write {
    String buf;

    public void addLine(String label, String order, String op) {
        if (buf != null) {
            buf += label + "\t" + order + "\t" + op + "\n";
        } else {
            buf = label + "\t" + order + "\t" + op + "\n";
        }
    }

    public void addLine(String order, String op) {
        if (buf != null) {
            buf += "\t" + order + "\t" + op + "\n";
        } else {
            buf = "\t" + order + "\t" + op + "\n";
        }
    }

    public void addLabel(String label) {
        if (buf != null) {
            buf += label + "\tNOP\n";
        } else {
            buf = label + "\tNOP\n";
        }
    }

    public String getBuf() {
        return buf;
    }
}
