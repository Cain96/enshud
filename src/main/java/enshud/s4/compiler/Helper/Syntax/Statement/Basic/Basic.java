package enshud.s4.compiler.Helper.Syntax.Statement.Basic;

import enshud.s4.compiler.Helper.Output.Output;
import enshud.s4.compiler.Helper.Output.Variables;
import enshud.s4.compiler.Helper.Output.Write;
import enshud.s4.compiler.Helper.Semantics.Variable.Declared;
import enshud.s4.compiler.Helper.Syntax.Core.Core;
import enshud.s4.compiler.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;
import java.util.Iterator;

/**
 * Created by Cain96 on 2017/03/06.
 */
public class Basic extends Core {
    public CalledVariableExpression calledVariableExpression;
    public Declared declared;
    private Variables variables;
    private Output output;
    public Write write;

    public Basic(Declared declared, Output output) {
        this.write = new Write();
        this.variables = new Variables(declared, write);
        this.calledVariableExpression = new CalledVariableExpression(declared, write, variables);
        this.declared = declared;
        this.output = output;
    }

    public BufferedReader basicStatementChecker(BufferedReader br) {
        if (hasOption(br, 43)) {
            br = idCheck(br, 43);
            String variableName = string;
            int variableLine = lineNumber;
            br = calledVariableExpression.checkAssignedVariable(br, variableName, variableLine);
            boolean isArray = calledVariableExpression.called.isArray;

            if (hasOption(br, 33)) {
                /**手続き呼び出し文のオプションcheck**/
                Iterator<Integer> function = declared.declaredFunctions.get(variableName).values().iterator();
                br = idCheck(br, 33);
                br = calledVariableExpression.checkExpression(br);
                if (function.hasNext() && (function.next() != calledVariableExpression.val)) {
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkExpression(br);
                    if (function.hasNext() && (function.next() != calledVariableExpression.val)) {
                        System.err.println("Semantic error: line " + lineNumber);
                        return null;
                    }
                }
                br = idCheck(br, 34);
                variables.callFunction(variableName);
            } else if (hasOption(br, 40)) {
                /**代入文のcheck**/
                int prev = calledVariableExpression.val;
                br = idCheck(br, 40);
                int mid = id;
                br = calledVariableExpression.checkExpression(br);
                int follow = calledVariableExpression.val;
                if (calledVariableExpression.operator.check(prev, mid, follow) < 0) {
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
                variables.store(variableName, isArray);
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
            Compound cs = new Compound(declared, output);
            br = cs.checkCompoundStatement(br);
            return br;
        } else if (br != null) {
            System.err.println("Syntax error: line " + lineNumber);
            return null;
        }
        /**複合文以外の基本文を書き込み**/
        output.addFile(write.getBuf());
        return br;
    }
}
