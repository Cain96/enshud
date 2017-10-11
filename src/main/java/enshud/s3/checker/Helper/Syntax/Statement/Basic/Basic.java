package enshud.s3.checker.Helper.Syntax.Statement.Basic;

import enshud.s3.checker.Helper.Semantics.Variable.Declared;
import enshud.s3.checker.Helper.Syntax.Core.Core;
import enshud.s3.checker.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/03/06.
 */
public class Basic extends Core {
    public CalledVariableExpression calledVariableExpression;
    public Declared declared;

    public Basic(Declared declared) {
        this.calledVariableExpression = new CalledVariableExpression(declared);
        this.declared = declared;
    }

    public BufferedReader basicStatementChecker(BufferedReader br) {
        if (hasOption(br, 43)) {
            br = idCheck(br, 43);
            String variableName = string;
            int variableLine = lineNumber;
            br = calledVariableExpression.checkAssignedVariable(br, variableName, variableLine);

            if (hasOption(br, 33)) {
                /**手続き呼び出し文のオプションcheck**/
                br = idCheck(br, 33);
                br = calledVariableExpression.checkExpression(br);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkExpression(br);
                }
                br = idCheck(br, 34);
            } else if (hasOption(br, 40)) {
                /**代入文のcheck**/
                int prev = calledVariableExpression.val;
                br = idCheck(br, 40);
                int mid = id;
                br = calledVariableExpression.checkExpression(br);
                int follow = calledVariableExpression.val;
                if (calledVariableExpression.operator.check(prev, mid, follow, lineNumber) < 0) {
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
            }
        } else if (hasOption(br, 18)) {
            /**入力文のcheck**/
            br = idCheck(br, 18);
            if (hasOption(br, 33)) {
                br = idCheck(br, 33);
                br = idCheck(br, 43);
                br = calledVariableExpression.checkCalledVariable(br, string, lineNumber);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkCalledVariable(br, string, lineNumber);
                }
                br = idCheck(br, 34);
            }
        } else if (hasOption(br, 23)) {
            /**出力文のcheck**/
            br = idCheck(br, 23);
            if (hasOption(br, 33)) {
                br = idCheck(br, 33);
                br = calledVariableExpression.checkExpression(br);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkExpression(br);
                }
                br = idCheck(br, 34);
            }
        } else if (hasOption(br, 2)) {
            /**複合文のcheck**/
            Compound cs = new Compound(declared);
            br = cs.checkCompoundStatement(br);
        } else if (br != null) {
            System.err.println("Syntax error: line " + lineNumber);
            return null;
        }
        return br;
    }
}
