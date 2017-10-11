package enshud.s3.checker.Helper.Semantics.Operator;

import java.util.Arrays;
import java.util.List;

public class Operator {

    private final int INT = 11, BOOL = 3, EQUAL = 40, ERROR = -1;

    List<Integer> arithmeticList = Arrays.asList(new Integer[]{5, 12, 30, 31, 32});
    List<Integer> logicList = Arrays.asList(new Integer[]{0, 15});
    List<Integer> relationList = Arrays.asList(new Integer[]{24, 25, 26, 27, 28, 29});

    public int check(int prev, int mid, int follow, int lineNumber) {
        if (prev == follow) {
            if (arithmeticList.contains(mid)) {
                return INT;
            } else if (logicList.contains(mid) || relationList.contains(mid)) {
                return BOOL;
            } else if (mid == EQUAL){
                return EQUAL;
            }
        }

        return ERROR;
    }
}
