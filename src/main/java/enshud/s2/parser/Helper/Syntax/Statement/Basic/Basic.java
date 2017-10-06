package enshud.s2.parser.Helper.Syntax.Statement.Basic;


import enshud.s2.parser.Helper.Syntax.Core.Core;
import enshud.s2.parser.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/03/06.
 */
public class Basic extends Core {
    public CalledVariableExpression calledVariableExpression;

    public Basic() {
        this.calledVariableExpression = new CalledVariableExpression();
    }

    public BufferedReader basicStatementChecker(BufferedReader br) {
        if (hasOption(br, 43)) {
            br = idCheck(br, 43);
            if (hasOption(br, 33)) {
                /**手続き呼び出し文のオプションcheck**/
                br = idCheck(br, 33);
                br = calledVariableExpression.checkExpression(br);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkExpression(br);
                }
                br = idCheck(br, 34);
            } else {
                /**代入文のcheck**/
                br = calledVariableExpression.checkCalledVariable(br);
                if (hasOption(br, 40)) {
                    br = idCheck(br, 40);
                    br = calledVariableExpression.checkExpression(br);
                }
            }
        } else if (hasOption(br, 18)) {
            /**入力文のcheck**/
            br = idCheck(br, 18);
            if (hasOption(br, 33)) {
                br = idCheck(br, 33);
                br = idCheck(br, 43);
                br = calledVariableExpression.checkCalledVariable(br);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkCalledVariable(br);
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
            Compound cs = new Compound();
            br = cs.checkCompoundStatement(br);
        } else if (br != null) {
            System.err.println("Syntax error: line " + lineNumber);
            return null;
        }
        return br;
    }
}
