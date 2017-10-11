package enshud.s3.checker.Helper.Semantics.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public int semanticCheckCalledVariable(String variable, int lineNumber) {
        for (Map.Entry<Integer, ArrayList<String>> entry : declaredVariables.entrySet()) {
            if (entry.getValue().contains(variable)) {
                return entry.getKey();
            }
        }
        for (Map.Entry<Integer, ArrayList<Array>> entry : declaredArrays.entrySet()) {
            for (Array array : entry.getValue()) {
                if (array.getName().equals(variable)) {
                    return entry.getKey();
                }
            }
        }
        if (declaredFunctions.contains(variable)) {
            return 43;
        }
        System.err.println("Semantic error: line " + lineNumber);
        return -1;
    }

}
