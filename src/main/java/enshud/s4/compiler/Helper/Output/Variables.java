package enshud.s4.compiler.Helper.Output;

import enshud.s4.compiler.Helper.Semantics.Variable.Array;
import enshud.s4.compiler.Helper.Semantics.Variable.Declared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Variables {
    private Declared declared;
    private Write write;
    private ArrayList<String> functionNames;

    public Variables(Declared declared, Write write) {
        this.declared = declared;
        this.write = write;
        this.functionNames = new ArrayList<>(declared.declaredFunctions.keySet());
    }

    public void store(String variable, boolean isArray) {
        write.addLine("POP", "GR1");
        int num = getVariableIndex(variable);
        write.addLine("LD", "GR2, =" + num);
        if (isArray){
            write.addLine("POP", "GR3");
            write.addLine("ADDA", "GR2, GR3");
        }
        write.addLine("ST", "GR1, VAR, GR2");
    }

    public void call(String variable) {
        int num;
        if ((num = getVariableIndex(variable)) >= 0) {
            write.addLine("LD", "GR2, =" + num);
            write.addLine("LD", "GR1, VAR, GR2");
            write.addLine("PUSH", "0, GR1");
        }
    }

    public void callArray(String variable) {
        int num = getVariableIndex(variable);
        write.addLine("LD", "GR2, =" + num);
        write.addLine("POP", "GR1");
        write.addLine("ADDA", "GR2, GR1");
        write.addLine("LD", "GR1, VAR, GR2");
    }

    public void callFunction(String variable) {
        int num = functionNames.indexOf(variable);
        write.addLine("CALL", "FUNC" + num);
    }

    private int getVariableIndex(String variable) {
        for (HashMap<String, Integer> variables : declared.declaredVariables.values()) {
            if (variables.containsKey(variable)) {
                return variables.get(variable);
            }
        }

        for (HashMap<Array, Integer> variables : declared.declaredArrays.values()) {
            for (Map.Entry<Array, Integer> entry : variables.entrySet()) {
                if (entry.getKey().getName().equals(variable)) {
                    return entry.getValue();
                }
            }
        }

        return -1;
    }

}
