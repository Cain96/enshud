package enshud.s4.compiler.Helper.Output;

public class End extends Write {
    private static int i = 0;

    public End() {
        buf += "\tRET\n";
        addLine("LIBBUF", "DS", "256");
    }

    public void addString(String string) {
        addLine("STR" + i, "DC", string);
        i++;
    }

    public void addEnd() {
        buf += "\tEND\n";
    }
}
