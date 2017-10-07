package enshud.s3.checker.Helper.Semantics.Variable;

import enshud.s3.checker.Helper.Semantics.Variable.Array;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void setDeclared(Declared declared){
        declaredVariables = declared.declaredVariables;
        declaredArrays = declared.declaredArrays;
    }

    public void addVariables(int id, ArrayList<String> newVariables) {
        ArrayList<String> variables = declaredVariables.get(id);
        if (variables != null) {
            variables.addAll(newVariables);
        }
    }

    public void addArray(int id, Array newVariables) {
        ArrayList variables = declaredArrays.get(id);
        if (variables != null) {
            variables.add(newVariables);
        }
    }

    public void addFunction(String name){
        declaredFunctions.add(name);
    }
}
