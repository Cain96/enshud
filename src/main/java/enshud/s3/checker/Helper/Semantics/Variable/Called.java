package enshud.s3.checker.Helper.Semantics.Variable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Called {
    public HashMap<Integer, ArrayList<String>> declaredVariables;
    public HashMap<Integer, ArrayList<Array>> declaredArrays;
    public ArrayList<String> declaredFunctions;


    public Called(Declared declared) {
        this.declaredVariables = declared.declaredVariables;
        this.declaredArrays = declared.declaredArrays;
        this.declaredFunctions = declared.declaredFunctions;
    }

    public boolean semanticCheckCalledVariable(String variable, int lineNumber) {
        if (!hasCalledVariable(variable)) {
            System.err.println("Semantic error: line " + lineNumber);
            return false;
        }
        return true;
    }

    private boolean hasCalledVariable(String element) {
        for (ArrayList<String> variables : declaredVariables.values()) {
            if (variables.contains(element)) {
                return true;
            }
        }
        for (ArrayList<Array> variables : declaredArrays.values()) {
            for (Array variable : variables) {
                if (variable.getName().equals(element)) {
                    return true;
                }
            }
        }
        if (declaredFunctions.contains(element)) {
            return true;
        }
        return false;
    }
}
