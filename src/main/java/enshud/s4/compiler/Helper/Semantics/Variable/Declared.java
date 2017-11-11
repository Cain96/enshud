package enshud.s4.compiler.Helper.Semantics.Variable;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Declared {
    public HashMap<Integer, HashMap<String, Integer>> declaredVariables;
    public HashMap<Integer, HashMap<Array, Integer>> declaredArrays;
    public LinkedHashMap<String, LinkedHashMap<String, Integer>> declaredFunctions;

    private static int index = 0;

    public Declared() {
        declaredVariables = new HashMap<>();
        declaredVariables.put(3, new HashMap<>());
        declaredVariables.put(4, new HashMap<>());
        declaredVariables.put(11, new HashMap<>());

        declaredArrays = new HashMap<>();
        declaredArrays.put(3, new HashMap<>());
        declaredArrays.put(4, new HashMap<>());
        declaredArrays.put(11, new HashMap<>());

        declaredFunctions = new LinkedHashMap<>();
    }

    public void setDeclared(Declared declared) {
        for (Map.Entry<Integer, HashMap<String, Integer>> entry : declaredVariables.entrySet()) {
            entry.getValue().putAll(declared.declaredVariables.get(entry.getKey()));
        }
        for (Map.Entry<Integer, HashMap<Array, Integer>> entry : declaredArrays.entrySet()) {
            entry.getValue().putAll(declared.declaredArrays.get(entry.getKey()));
        }
        declaredFunctions.putAll(declared.declaredFunctions);
    }

    public BufferedReader addVariables(BufferedReader br, int id, ArrayList<String> newVariables, int lineNumber) {
        if (br != null) {
            for (String variable : newVariables) {
                if (!checkDuplicateVariables(variable, lineNumber)) {
                    return null;
                }
            }
            addProcedureVariables(id, newVariables);
        }
        return br;
    }

    public void addProcedureVariables(int id, ArrayList<String> newVariables) {
        Map<String, Integer> variablesHash = newVariables.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> index++
                ));
        HashMap<String, Integer> variables = declaredVariables.get(id);
        if (variables != null) {
            variables.putAll(variablesHash);
        }
    }

    public BufferedReader addArray(BufferedReader br, int id, Array newVariables, int lineNumber) {
        if (br != null) {
            if (!checkDuplicateVariables(newVariables.getName(), lineNumber)) {
                return null;
            }
            HashMap variables = declaredArrays.get(id);
            if (variables != null) {
                variables.put(newVariables, index);
                index += newVariables.getMax() - newVariables.getMin();
            }
        }
        return br;
    }

    public BufferedReader addFunction(BufferedReader br, String name, LinkedHashMap<String, Integer> variables, int lineNumber) {
        if (br != null) {
            if (!checkDuplicateVariables(name, lineNumber)) {
                return null;
            }
            declaredFunctions.put(name, variables);
        }
        return br;
    }

    private boolean checkDuplicateVariables(String name, int lineNumber) {
        if (hasDuplicateVariables(name)) {
            System.err.println("Semantic error: line " + lineNumber);
            return false;
        }
        return true;
    }

    private boolean hasDuplicateVariables(String name) {
        for (HashMap<String, Integer> variables : declaredVariables.values()) {
            if (variables.containsKey(name)) {
                return true;
            }
        }
        for (HashMap<Array, Integer> arrays : declaredArrays.values()) {
            for (Array array : arrays.keySet()) {
                if (array.getName().equals(name)) {
                    return true;
                }
            }
        }
        for (String function : declaredFunctions.keySet()) {
            if (function.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String getIndex() {
        return "" + index;
    }
}
