package enshud.s3.checker.Helper.Syntax.Statement;


import enshud.s3.checker.Helper.Semantics.Expression.Expression;
import enshud.s3.checker.Helper.Semantics.Variable.Declared;
import enshud.s3.checker.Helper.Syntax.Core.Core;
import enshud.s3.checker.Helper.Syntax.Statement.Basic.Basic;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/03/06.
 */
public class Compound extends Core {
    private Basic basic;
    private Expression expression;

    public Compound(Declared declared) {
        this.basic = new Basic(declared);
        this.expression = new Expression();
    }

    public BufferedReader checkCompoundStatement(BufferedReader br) {
        /**複合文のcheck**/
        if (br != null) {
            br = idCheck(br, 2);
            br = statementChecker(br);
            while (hasOption(br, 37)) {
                br = idCheck(br, 37);
                br = statementChecker(br);
            }
            br = idCheck(br, 8);
        }
        return br;
    }

    private BufferedReader statementChecker(BufferedReader br) {
        /**文のcheck**/
        if (br != null) {
            if (hasOption(br, 10)) {
                /**if分のcheck**/
                br = idCheck(br, 10);
                br = basic.calledVariableExpression.checkExpression(br);
                if (!expression.checkBool(basic.calledVariableExpression.val)){
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
                br = idCheck(br, 19);
                br = checkCompoundStatement(br);
                if (hasOption(br, 7)) {
                    br = idCheck(br, 7);
                    br = checkCompoundStatement(br);
                }
            } else if (hasOption(br, 22)) {
                /**while分のcheck**/
                br = idCheck(br, 22);
                br = basic.calledVariableExpression.checkExpression(br);
                if (!expression.checkBool(basic.calledVariableExpression.val)){
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
                br = idCheck(br, 6);
                br = basic.basicStatementChecker(br);
            } else {
                /**基本文のcheck**/
                br = basic.basicStatementChecker(br);
            }
        }
        return br;
    }
}
