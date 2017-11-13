package enshud.s4.compiler.Helper.Output;

public class Calculation {
    public Write write;
    static int branch = 0;

    public Calculation(Write write) {
        this.write = write;
    }

    public void minus(){
        write.addLine("POP", "GR1");
        write.addLine("XOR", "GR1, =#FFFF");
        write.addLine("ADDL", "GR1, =1");
        write.addLine("PUSH", "0, GR1");
    }

    public void add() {
        calculateHelp();
        write.addLine("ADDA", "GR1, GR2");
        write.addLine("PUSH", "0, GR1");
    }

    public void sub() {
        calculateHelp();
        write.addLine("SUBA", "GR1, GR2");
        write.addLine("PUSH", "0, GR1");
    }

    public void mult() {
        calculateHelp();
        write.addLine("CALL", "MULT");
        write.addLine("PUSH", "0, GR2");
    }

    public void div() {
        calculateHelp();
        write.addLine("CALL", "DIV");
        write.addLine("PUSH", "0, GR2");
    }

    public void mod() {
        calculateHelp();
        write.addLine("CALL", "DIV");
        write.addLine("PUSH", "0, GR1");
    }

    public void and() {
        calculateHelp();
        write.addLine("AND", "GR2, GR1");
        write.addLine("PUSH", "0, GR2");
    }

    public void or() {
        calculateHelp();
        write.addLine("OR", "GR2, GR1");
        write.addLine("PUSH", "0, GR2");
    }


    public void not() {
        write.addLine("POP", "GR2");
        write.addLine("XOR", "GR2, =#FFFF");
        write.addLine("PUSH", "0, GR2");
    }

    public void equal() {
        relateHelp();
        write.addLine("JZE", "EQUAL" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("EQUAL" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        branch++;
    }

    public void notEqual() {
        relateHelp();
        write.addLine("JNZ", "NEQUAL" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("NEQUAL" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        branch++;
    }

    public void moreThan() {
        relateHelp();
        write.addLine("JMI", "MORE" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("MORE" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        branch++;
    }

    public void above() {
        relateHelp();
        write.addLine("JPL", "ABOVE" + branch);
        write.addLine("LAD", "GR1, #0000");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("ABOVE" + branch, "LAD", "GR1, #FFFF");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        branch++;
    }

    public void below() {
        relateHelp();
        write.addLine("JMI", "BELOW" + branch);
        write.addLine("LAD", "GR1, #0000");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("BELOW" + branch, "LAD", "GR1, #FFFF");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        branch++;
    }

    public void lessThan() {
        relateHelp();
        write.addLine("JPL", "LESS" + branch);
        write.addLine("LAD", "GR1, #FFFF");
        write.addLine("JUMP", "ALL" + branch);
        write.addLine("LESS" + branch, "LAD", "GR1, #0000");
        write.addLine("ALL" + branch, "PUSH", "0, GR1");
        branch++;
    }


    public void pushNum(String variable) {
        write.addLine("LD", "GR1, =" + variable);
        write.addLine("PUSH", "0, GR1");
    }

    public void push(String variable) {
        write.addLine("PUSH", variable);
    }

    private void calculateHelp() {
        write.addLine("POP", "GR2");
        write.addLine("POP", "GR1");
    }

    private void relateHelp() {
        calculateHelp();
        write.addLine("CPA", "GR1, GR2");
    }


}
