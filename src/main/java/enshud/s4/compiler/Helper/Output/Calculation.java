package enshud.s4.compiler.Helper.Output;

import static enshud.s4.compiler.Helper.FileRead.output;

public class Calculation {
    static int branch = 0;

    public void minus(){
        Write write = new Write();
        write.addLine("POP", "GR1");
        write.addLine("XOR", "GR1, =#FFFF");
        write.addLine("ADDL", "GR1, =1");
        write.addLine("PUSH", "0, GR1");
        output.addFile(write.getBuf());
    }

    public void add() {
        Write write = calculateHelp();
        write.addLine("ADDA", "GR1, GR2");
        write.addLine("PUSH", "0, GR1");
        output.addFile(write.getBuf());
    }

    public void sub() {
        Write write = calculateHelp();
        write.addLine("SUBA", "GR1, GR2");
        write.addLine("PUSH", "0, GR1");
        output.addFile(write.getBuf());
    }

    public void mult() {
        Write write = calculateHelp();
        write.addLine("CALL", "MULT");
        write.addLine("PUSH", "0, GR2");
        output.addFile(write.getBuf());
    }

    public void div() {
        Write write = calculateHelp();
        write.addLine("CALL", "DIV");
        write.addLine("PUSH", "0, GR2");
        output.addFile(write.getBuf());
    }

    public void mod() {
        Write write = calculateHelp();
        write.addLine("CALL", "DIV");
        write.addLine("PUSH", "0, GR1");
        output.addFile(write.getBuf());
    }

    public void and() {
        Write write = calculateHelp();
        write.addLine("AND", "GR2, GR1");
        write.addLine("PUSH", "0, GR2");
        output.addFile(write.getBuf());
    }

    public void or() {
        Write write = calculateHelp();
        write.addLine("OR", "GR2, GR1");
        write.addLine("PUSH", "0, GR2");
        output.addFile(write.getBuf());
    }


    public void not() {
        Write write = new Write();
        write.addLine("POP", "GR2");
        write.addLine("XOR", "GR2, =#FFFF");
        write.addLine("PUSH", "0, GR2");
        output.addFile(write.getBuf());
    }

    public void equal() {
        Write write = relateHelp();
        write.addLine("JZE", "EQUAL" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("EQUAL" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        output.addFile(write.getBuf());
        branch++;
    }

    public void notEqual() {
        Write write = relateHelp();
        write.addLine("JNZ", "NEQUAL" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("NEQUAL" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        output.addFile(write.getBuf());
        branch++;
    }

    public void moreThan() {
        Write write = relateHelp();
        write.addLine("JMI", "MORE" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("MORE" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        output.addFile(write.getBuf());
        branch++;
    }

    public void above() {
        Write write = relateHelp();
        write.addLine("JPL", "ABOVE" + branch);
        write.addLine("LAD", "GR1, #0000");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("ABOVE" + branch, "LAD", "GR1, #FFFF");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        output.addFile(write.getBuf());
        branch++;
    }

    public void below() {
        Write write = relateHelp();
        write.addLine("JMI", "BELOW" + branch);
        write.addLine("LAD", "GR1, #0000");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("BELOW" + branch, "LAD", "GR1, #FFFF");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        output.addFile(write.getBuf());
        branch++;
    }

    public void lessThan() {
        Write write = relateHelp();
        write.addLine("JPL", "LESS" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("LESS" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        output.addFile(write.getBuf());
        branch++;
    }


    public void pushNum(String variable) {
        Write write = new Write();
        write.addLine("LD", "GR1, =" + variable);
        write.addLine("PUSH", "0, GR1");
        output.addFile(write.getBuf());
    }

    public void push(String variable) {
        Write write = new Write();
        write.addLine("PUSH", variable);
        output.addFile(write.getBuf());
    }

    private Write calculateHelp() {
        Write write = new Write();
        write.addLine("POP", "GR2");
        write.addLine("POP", "GR1");
        return write;
    }

    private Write relateHelp() {
        Write write = calculateHelp();
        write.addLine("CPA", "GR1, GR2");
        return write;
    }
}
