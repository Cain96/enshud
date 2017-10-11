package enshud.s3.checker.Helper.Syntax.Statement.Basic;


import enshud.s3.checker.Helper.Semantics.Operator.Operator;
import enshud.s3.checker.Helper.Semantics.Variable.Called;
import enshud.s3.checker.Helper.Semantics.Variable.Declared;
import enshud.s3.checker.Helper.Syntax.Core.Core;
import enshud.s3.checker.Helper.Syntax.Elements.Elements;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class CalledVariableExpression extends Core {

    Called called;
    Operator operator;
    private String val;

    public CalledVariableExpression(Declared declared) {
        this.called = new Called(declared);
        this.operator = new Operator(declared);
    }

    BufferedReader checkCalledVariable(BufferedReader br, String variable, int lineNumber) {
        /**変数のcheck**/
        if (called.semanticCheckCalledVariable(variable, lineNumber) < 0) {
            return null;
        }
        if (hasOption(br, 35)) {
            br = idCheck(br, 35);
            br = checkExpression(br);
            br = idCheck(br, 36);
        }
        return br;
    }

    public BufferedReader checkExpression(BufferedReader br) {
        /**式のcheck**/
        br = checkSimpleExpression(br);
        String prev = val;
        while (hasOption(br, new Integer[]{24, 25, 26, 27, 28, 29})) {/**関係演算子**/
            br = idCheck(br, new Integer[]{24, 25, 26, 27, 28, 29});
            int mid = id;
            br = checkSimpleExpression(br);
            String follow = val;
            if ((prev = operator.check(prev, mid, follow, lineNumber)).equals("ERROR")) {
                return null;
            }
        }
        return br;
    }

    private BufferedReader checkSimpleExpression(BufferedReader br) {
        /**単純式のcheck**/
        if (hasOption(br, new Integer[]{30, 31})) {/**符号**/
            br = idCheck(br, new Integer[]{30, 31});
        }
        br = checkTerm(br);
        String prev = val;
        while (hasOption(br, new Integer[]{15, 30, 31})) {/**加法演算子**/
            br = idCheck(br, new Integer[]{15, 30, 31});
            int mid = id;
            br = checkTerm(br);
            String follow = val;
            if ((prev = operator.check(prev, mid, follow, lineNumber)).equals("ERROR")) {
                return null;
            }
        }
        val = prev;
        return br;
    }

    private BufferedReader checkTerm(BufferedReader br) {
        /**項のcheck**/
        br = checkFactor(br);
        String prev = val;
        while (hasOption(br, new Integer[]{0, 5, 12, 32})) {/**乗法演算子**/
            br = idCheck(br, new Integer[]{0, 5, 12, 32});
            int mid = id;
            br = checkFactor(br);
            String follow = val;
            if ((prev = operator.check(prev, mid, follow, lineNumber)).equals("ERROR")) {
                return null;
            }
        }
        val = prev;
        return br;
    }

    private BufferedReader checkFactor(BufferedReader br) {
        /**因子のcheck**/
        if (hasOption(br, 43)) {
            /**変数**/
            br = idCheck(br, 43);
            val = string;
            br = checkCalledVariable(br, string, lineNumber);
        } else if (hasOption(br, new Integer[]{9, 20, 44, 45})) {
            /**定数**/
            br = idCheck(br, new Integer[]{9, 20, 44, 45});
            val = string;
        } else if (hasOption(br, 33)) {
            /**"("式")"**/
            br = idCheck(br, 33);
            br = checkExpression(br);
            br = idCheck(br, 34);
        } else if (hasOption(br, 13)) {
            /**"not" 因子**/
            br = idCheck(br, 13);
            br = checkFactor(br);
        } else {
            System.err.println("Syntax error: line " + lineNumber);
            return null;
        }
        return br;
    }
}
