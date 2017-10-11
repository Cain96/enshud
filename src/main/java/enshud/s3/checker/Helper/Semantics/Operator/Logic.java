package enshud.s3.checker.Helper.Semantics.Operator;

import enshud.s3.checker.Helper.Semantics.Variable.Array;
import enshud.s3.checker.Helper.Semantics.Variable.Declared;

import java.util.ArrayList;
import java.util.Arrays;

public class Logic {
    ArrayList<String> boolVariables, boolCheckList;
    ArrayList<Array> boolArrayVariables;

    public Logic(Declared declared){
        this.boolVariables = declared.declaredVariables.get(3);
        this.boolArrayVariables = declared.declaredArrays.get(3);
        this.boolCheckList = new ArrayList<>(Arrays.asList("true", "false", "BOOL"));
    }

    boolean check(String prev, String follow, int lineNumber) {
        if (!isBool(prev)){
            System.err.println("Semantic error: line " + lineNumber);
            return false;
        }
        if (!isBool(follow)){
            System.err.println("Semantic error: line " + lineNumber);
            return false;
        }
        return true;
    }

    private boolean isBool(String val) {
        if (boolVariables.contains(val)) {
            return true;
        }
        for (Array array : boolArrayVariables) {
            if (array.getName().equals(val)) {
                return true;
            }
        }
        if (boolCheckList.contains(val)){
            return true;
        }
        return false;
    }
}
