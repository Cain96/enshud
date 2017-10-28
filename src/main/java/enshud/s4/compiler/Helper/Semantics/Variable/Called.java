package enshud.s4.compiler.Helper.Semantics.Variable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Called {
    private HashMap<Integer, HashMap<String, Integer>> declaredVariables;
    private HashMap<Integer, HashMap<Array, Integer>> declaredArrays;
    private HashMap<String, LinkedHashMap<String, Integer>> declaredFunctions;
    public boolean isArray;


    public Called(Declared declared) {
        this.declaredVariables = declared.declaredVariables;
        this.declaredArrays = declared.declaredArrays;
        this.declaredFunctions = declared.declaredFunctions;
    }

    public int semanticCheckCalledVariable(String variable, int lineNumber) {
        isArray = false;
        for (Map.Entry<Integer, HashMap<String, Integer>> entry : declaredVariables.entrySet()) {
            if (entry.getValue().containsKey(variable)) {
                return entry.getKey();
            }
        }
        for (Map.Entry<Integer, HashMap<Array, Integer>> entry : declaredArrays.entrySet()) {
            for (Array array : entry.getValue().keySet()) {
                if (array.getName().equals(variable)) {
                    isArray = true;
                    return entry.getKey();
                }
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : declaredFunctions.entrySet()) {
            if (entry.getKey().equals(variable)) {
                return 43;
            }
            for (Map.Entry<String, Integer> variableEntry : entry.getValue().entrySet()) {
                if (variableEntry.getKey().equals(variable)) {
                    return variableEntry.getValue();
                }
            }
        }
        System.err.println("Semantic error: line " + lineNumber);
        return -1;
    }

    public boolean checkArrayIndex(int id) {
        final int INT = 11;
        if (id == INT) {
            return true;
        }
        return false;
    }
}
