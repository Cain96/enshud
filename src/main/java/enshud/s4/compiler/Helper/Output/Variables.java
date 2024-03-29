package enshud.s4.compiler.Helper.Output;

import enshud.s4.compiler.Helper.Semantics.Variable.Array;
import enshud.s4.compiler.Helper.Semantics.Variable.Declared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static enshud.s4.compiler.Helper.SyntaxCheck.functionHash;

public class Variables {
    private Declared declared;
    public Write write;
    private Array array;


    private static int arrayIndex = 0;

    public Variables(Declared declared, Write write) {
        this.declared = declared;
        this.write = write;
    }

    public static int getArrayIndex() {
        return arrayIndex;
    }

    public static void incArrayIndex() {
        arrayIndex++;
    }

    public void store(String variable, boolean isArray) {
        write.addLine("POP", "GR1");
        int num = getVariableIndex(variable);
        if (isArray) {
            write.addLine("LD", "GR2, =" + (num - array.getMin()));
            write.addLine("POP", "GR3");
            write.addLine("ADDA", "GR2, GR3");
        } else {
            write.addLine("LD", "GR2, =" + num);
        }
        write.addLine("ST", "GR1, VAR, GR2");
    }

    public void store(String variable, boolean isArray, Declared declared) {
        write.addLine("POP", "GR1");
        int num = getVariableIndex(variable, declared);
        write.addLine("LD", "GR2, =" + num);
        if (isArray) {
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

    public void callAllArray(String variable) {
        int num = getVariableIndex(variable);
        for (HashMap arrayMap : declared.declaredArrays.values()) {
            for (Array array : new ArrayList<Array>(arrayMap.keySet())) {
                if (array.getName().equals(variable)) {
                    int min = array.getMin();
                    int max = array.getMax();
                    write.addLine("LD", "GR3, =0");
                    write.addLabel("ARRAY" + arrayIndex);
                    write.addLine("CPA", "GR3, =" + (max - min + 1));
                    write.addLine("JZE", "EARRAY" + arrayIndex);
                    write.addLine("LD", "GR4, =" + num);
                    write.addLine("ADDA", "GR4, GR3");
                    write.addLine("LD", "GR1, VAR, GR4");
                    write.addLine("PUSH", "0, GR1");
                    return;
                }
            }
        }
    }

    public void callArray(String variable) {
        int num = getVariableIndex(variable);
        write.addLine("LD", "GR2, =" + (num - array.getMin()));
        write.addLine("POP", "GR1");
        write.addLine("ADDA", "GR2, GR1");
        write.addLine("LD", "GR1, VAR, GR2");
        write.addLine("PUSH", "0, GR1");
    }

    public void callFunction(String variable) {
        try {
            int index = functionHash.get(variable).getIndex();
            write.addLine("CALL", "FUNC" + index);
        } catch (NullPointerException e) {

        }
    }

    public int getVariableIndex(String variable) {
        for (HashMap<String, Integer> variables : declared.declaredVariables.values()) {
            if (variables.containsKey(variable)) {
                return variables.get(variable);
            }
        }

        for (HashMap<Array, Integer> variables : declared.declaredArrays.values()) {
            for (Map.Entry<Array, Integer> entry : variables.entrySet()) {
                if (entry.getKey().getName().equals(variable)) {
                    array = entry.getKey();
                    return entry.getValue();
                }
            }
        }
        return -1;
    }

    private int getVariableIndex(String variable, Declared declared) {
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
