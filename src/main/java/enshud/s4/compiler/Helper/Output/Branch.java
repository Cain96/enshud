package enshud.s4.compiler.Helper.Output;

import java.util.ArrayList;

import static enshud.s4.compiler.Helper.FileRead.output;

public class Branch {
    private static int branch = 0;
    private static ArrayList<Integer> branchList = new ArrayList<>();


    public void addIf() {
        Write write = new Write();
        write.addLine("POP", "GR2");
        write.addLine("LAD", "GR1, #0000");
        write.addLine("XOR", "GR2, GR1");
        write.addLine("JNZ", "IF" + branch);
        output.addFile(write.getBuf());
        branchList.add(branch);
        branch++;
    }

    public void addEndif() {
        Write write = new Write();
        int i = branchList.size() - 1;
        write.addLabel("IF" + branchList.get(i));
        branchList.remove(i);
        output.addFile(write.getBuf());
    }

    public void addElse() {
        Write write = new Write();
        int i = branchList.size() - 1;
        write.addLine("JUMP", "ELSE" + branchList.get(i));
        write.addLabel("IF" + branchList.get(i));
        output.addFile(write.getBuf());
    }

    public void addEndElse() {
        Write write = new Write();
        int i = branchList.size() - 1;
        write.addLabel("ELSE" + branchList.get(i));
        branchList.remove(i);
        output.addFile(write.getBuf());
    }

    public void addStartWhile() {
        Write write = new Write();
        write.addLabel("WHL" + branch);
        branchList.add(branch);
        output.addFile(write.getBuf());
        branch++;
    }

    public void addWhile() {
        Write write = new Write();
        write.addLine("POP", "GR2");
        write.addLine("LAD", "GR1, #0000");
        write.addLine("XOR", "GR2, GR1");
        write.addLine("JNZ", "WHLEND" + branchList.get(branchList.size() - 1));
        output.addFile(write.getBuf());
    }

    public void addEndWhile() {
        Write write = new Write();
        int i = branchList.size() - 1;
        write.addLine("JUMP", "WHL" + branchList.get(i));
        write.addLabel("WHLEND" + branchList.get(i));
        branchList.remove(i);
        output.addFile(write.getBuf());
    }
}
