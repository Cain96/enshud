package enshud.s3.checker.Helper.Semantics.Operator;

import enshud.s3.checker.Helper.Semantics.Variable.Array;
import enshud.s3.checker.Helper.Semantics.Variable.Declared;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Operator {

    final int BOOL = 3;
    final int CHAR = 4;
    final int INT = 11;

    Declared declared;
    Arithmetic arithmetic;
    Logic logic;

    public Operator(Declared declared) {
        this.declared = declared;
        this.arithmetic = new Arithmetic(declared);
        this.logic = new Logic(declared);
    }

    List<Integer> arithmeticList = Arrays.asList(new Integer[]{5, 12, 30, 31, 32});
    List<Integer> logicList = Arrays.asList(new Integer[]{0, 15});
    List<Integer> relationList = Arrays.asList(new Integer[]{24, 25, 26, 27, 28, 29});

    public String check(String prev, int mid, String follow, int lineNumber) {

        if (prev != null && follow != null) {
            if (arithmeticList.contains(mid) && arithmetic.check(prev, follow, lineNumber)) {
                return "INT";
            } else if (logicList.contains(mid)) {
                return "BOOL";
            } else if (relationList.contains(mid)) {
                return "BOOL";
            }
        }
        return "ERROR";
    }
}
