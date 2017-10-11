package enshud.s3.checker.Helper.Semantics.Operator;

import enshud.s3.checker.Helper.Semantics.Variable.Array;
import enshud.s3.checker.Helper.Semantics.Variable.Declared;

import java.util.ArrayList;

public class Arithmetic {
    ArrayList<String> intVariables;
    ArrayList<Array> intArrayVariables;

    public Arithmetic(Declared declared) {
        this.intVariables = declared.declaredVariables.get(11);
        this.intArrayVariables = declared.declaredArrays.get(11);
    }

    boolean check(String prev, String follow, int lineNumber) {
        if (!isInt(prev)){
            System.err.println("Semantic error: line " + lineNumber);
            return false;
        }
        if (!isInt(follow)){
            System.err.println("Semantic error: line " + lineNumber);
            return false;
        }
        return true;
    }

    private boolean isInt(String num) {
        if (intVariables.contains(num)) {
            return true;
        }
        for (Array array : intArrayVariables) {
            if (array.getName().equals(num)) {
                return true;
            }
        }
        if (num.equals("INT")){
            return true;
        }
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
