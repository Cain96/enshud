package enshud.s4.compiler.Helper.Output;

import static enshud.s4.compiler.Helper.FileRead.output;

public class Branch {
    private static int branch = 0;


    public void addIf() {
        Write write = new Write();
        write.addLine("POP", "GR2");
        write.addLine("LAD", "GR1, #0000");
        write.addLine("XOR", "GR2, GR1");
        write.addLine("JNZ", "IF" + branch);
        output.addFile(write.getBuf());
    }

    public void addEndif() {
        Write write = new Write();
        write.addLabel("IF" + branch);
        branch++;
        output.addFile(write.getBuf());
    }

    public void addElse() {
        Write write = new Write();
        write.addLine("JUMP", "ELSE" + branch);
        write.addLabel("IF" + branch);
        output.addFile(write.getBuf());
    }

    public void addEndElse() {
        Write write = new Write();
        write.addLabel("ELSE" + branch);
        branch++;
        output.addFile(write.getBuf());
    }

    public void addStartWhile() {
        Write write = new Write();
        write.addLabel("WHL" + branch);
        output.addFile(write.getBuf());
    }

    public void addWhile() {
        Write write = new Write();
        write.addLine("POP", "GR2");
        write.addLine("LAD", "GR1, #0000");
        write.addLine("XOR", "GR2, GR1");
        write.addLine("JNZ", "WHLEND" + branch);
        output.addFile(write.getBuf());
    }

    public void addEndWhile() {
        Write write = new Write();
        write.addLine("JUMP", "WHL" + branch);
        write.addLabel("WHLEND" + branch);
        branch++;
        output.addFile(write.getBuf());
    }
}
