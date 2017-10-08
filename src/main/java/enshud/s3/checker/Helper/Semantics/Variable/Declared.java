package enshud.s3.checker.Helper.Semantics.Variable;

import enshud.s3.checker.Helper.Semantics.Variable.Array;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Declared {
    public HashMap<Integer, ArrayList<String>> declaredVariables;
    public HashMap<Integer, ArrayList<Array>> declaredArrays;
    public ArrayList<String> declaredFunctions;

    public Declared() {
        declaredVariables = new HashMap<>();
        declaredVariables.put(3, new ArrayList<>());
        declaredVariables.put(4, new ArrayList<>());
        declaredVariables.put(11, new ArrayList<>());

        declaredArrays = new HashMap<>();
        declaredArrays.put(3, new ArrayList<>());
        declaredArrays.put(4, new ArrayList<>());
        declaredArrays.put(11, new ArrayList<>());

        declaredFunctions = new ArrayList<>();
    }

    public void setDeclared(Declared declared) {
        for (Map.Entry<Integer, ArrayList<String>> entry : declaredVariables.entrySet()){
            entry.getValue().addAll(declared.declaredVariables.get(entry.getKey()));
        }
        for (Map.Entry<Integer, ArrayList<Array>> entry : declaredArrays.entrySet()){
            entry.getValue().addAll(declared.declaredArrays.get(entry.getKey()));
        }
    }

    public BufferedReader addVariables(BufferedReader br, int id, ArrayList<String> newVariables, int lineNumber) {
        if (br != null) {
            for (String variable : newVariables) {
                if (!checkDuplicateVariables(variable, lineNumber)) {
                    return null;
                }
            }
            ArrayList<String> variables = declaredVariables.get(id);
            if (variables != null) {
                variables.addAll(newVariables);
            }
        }
        return br;
    }

    public BufferedReader addArray(BufferedReader br, int id, Array newVariables, int lineNumber) {
        if (br != null) {
            if (!checkDuplicateVariables(newVariables.getName(), lineNumber)) {
                return null;
            }
            ArrayList variables = declaredArrays.get(id);
            if (variables != null) {
                variables.add(newVariables);
            }
        }
        return br;
    }

    public BufferedReader addFunction(BufferedReader br, String name, int lineNumber) {
        if (br != null) {
            if (!checkDuplicateVariables(name, lineNumber)) {
                return null;
            }
            declaredFunctions.add(name);
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
        for (ArrayList<String> variables : declaredVariables.values()) {
            if (variables.contains(name)) {
                return true;
            }
        }
        for (ArrayList<Array> arrays : declaredArrays.values()) {
            for (Array array : arrays) {
                if (array.getName().equals(name)) {
                    return true;
                }
            }
        }
        if (declaredFunctions.contains(name)) {
            return true;
        }
        return false;
    }
}
