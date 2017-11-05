package enshud.s4.compiler.Helper.Syntax.Statement.Basic;


import enshud.s4.compiler.Helper.Output.Calculation;
import enshud.s4.compiler.Helper.Output.Variables;
import enshud.s4.compiler.Helper.Output.Write;
import enshud.s4.compiler.Helper.Semantics.Operator.Operator;
import enshud.s4.compiler.Helper.Semantics.Variable.Called;
import enshud.s4.compiler.Helper.Semantics.Variable.Declared;
import enshud.s4.compiler.Helper.Syntax.Core.Core;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class CalledVariableExpression extends Core {

    Called called;
    Operator operator;
    Calculation calculation;
    Variables variables;
    public int val;

    private boolean minus = false;

    public CalledVariableExpression(Declared declared, Write write, Variables variables) {
        this.called = new Called(declared);
        this.operator = new Operator();
        this.calculation = new Calculation(write);
        this.variables = variables;
    }

    BufferedReader checkAssignedVariable(BufferedReader br, String variable, int lineNumber) {
        /**代入文の変数check***/

        if ((val = called.semanticCheckCalledVariable(variable, lineNumber)) < 0) {
            return null;
        }
        if (called.isArray) {
            int valTmp = val;
            if (hasOption(br, 35)) {
                br = idCheck(br, 35);
                br = checkExpression(br);
                if (!called.checkArrayIndex(val)) {
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
                br = idCheck(br, 36);
            } else {
                System.err.println("Semantic error: line " + lineNumber);
                return null;
            }
            val = valTmp;
        }
        return br;
    }

    BufferedReader checkCalledVariable(BufferedReader br, String variable, int lineNumber) {
        /**変数のcheck**/

        if ((val = called.semanticCheckCalledVariable(variable, lineNumber)) < 0) {
            return null;
        }
        if (hasOption(br, 35)) {
            br = idCheck(br, 35);
            br = checkExpression(br);
            if (!called.checkArrayIndex(val)) {
                System.err.println("Semantic error: line " + lineNumber);
                return null;
            }
            br = idCheck(br, 36);
            variables.callArray(variable);
        } else {
            variables.call(variable);
        }
        return br;
    }

    public BufferedReader checkExpression(BufferedReader br) {
        /**式のcheck**/
        br = checkSimpleExpression(br);
        int prev = val;
        while (hasOption(br, new Integer[]{24, 25, 26, 27, 28, 29})) {/**関係演算子**/
            br = idCheck(br, new Integer[]{24, 25, 26, 27, 28, 29});
            int mid = id;
            br = checkSimpleExpression(br);
            int follow = val;
            if ((prev = operator.check(prev, mid, follow)) < 0) {
                return null;
            }
            switch (mid) {
                case 24:
                    calculation.equal();
                    break;
                case 25:
                    calculation.notEqual();
                    break;
                case 26:
                    calculation.moreThan();
                    break;
                case 27:
                    calculation.above();
                    break;
                case 28:
                    calculation.below();
                    break;
                case 29:
                    calculation.lessThan();
                    break;
            }
        }
        val = prev;
        return br;
    }

    private BufferedReader checkSimpleExpression(BufferedReader br) {
        /**単純式のcheck**/
        minus = false;
        if (hasOption(br, new Integer[]{30, 31})) {
            /**符号**/
            br = idCheck(br, new Integer[]{30, 31});
            if (id == 31) {
                minus = true;
            }
        }
        br = checkTerm(br);
        int prev = val;
        while (hasOption(br, new Integer[]{15, 30, 31})) {/**加法演算子**/
            br = idCheck(br, new Integer[]{15, 30, 31});
            int mid = id;
            br = checkTerm(br);
            int follow = val;
            if ((prev = operator.check(prev, mid, follow)) < 0) {
                return null;
            }
            switch (mid) {
                case 15:
                    calculation.or();
                    break;
                case 30:
                    calculation.add();
                    break;
                case 31:
                    calculation.sub();
                    break;
            }
        }
        val = prev;
        return br;
    }

    private BufferedReader checkTerm(BufferedReader br) {
        /**項のcheck**/
        br = checkFactor(br);
        int prev = val;
        while (hasOption(br, new Integer[]{0, 5, 12, 32})) {/**乗法演算子**/
            br = idCheck(br, new Integer[]{0, 5, 12, 32});
            int mid = id;
            br = checkFactor(br);
            int follow = val;
            if ((prev = operator.check(prev, mid, follow)) < 0) {
                return null;
            }
            switch (mid) {
                case 0:
                    calculation.and();
                    break;
                case 5:
                    calculation.div();
                    break;
                case 12:
                    calculation.mod();
                    break;
                case 32:
                    calculation.mult();
                    break;
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
            br = checkCalledVariable(br, string, lineNumber);
        } else if (hasOption(br, new Integer[]{9, 20, 44, 45})) {
            /**定数**/
            br = idCheck(br, new Integer[]{9, 20, 44, 45});
            if (id == 44) {
                if (minus) {
                    string = "-" + string;
                }
                calculation.pushNum(string);
                val = 11;
            } else if (id == 45) {

                val = 4;
            } else if (id == 20) {
                calculation.push("#0000");
                val = 3;
            } else {
                calculation.push("#FFFF");
                val = 3;
            }
        } else if (hasOption(br, 33)) {
            /**"("式")"**/
            br = idCheck(br, 33);
            br = checkExpression(br);
            br = idCheck(br, 34);
        } else if (hasOption(br, 13)) {
            /**"not" 因子**/
            br = idCheck(br, 13);
            br = checkFactor(br);
            calculation.not();
        } else if (br != null) {
            System.err.println("Syntax error: line " + lineNumber);
            return null;
        }
        return br;
    }
}
