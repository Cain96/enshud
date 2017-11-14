package enshud.s4.compiler.Helper.Syntax.Statement.Basic;

import enshud.s4.compiler.Helper.Output.Argument;
import enshud.s4.compiler.Helper.Output.IO;
import enshud.s4.compiler.Helper.Output.Variables;
import enshud.s4.compiler.Helper.Output.Write;
import enshud.s4.compiler.Helper.Semantics.Variable.Declared;
import enshud.s4.compiler.Helper.Syntax.Core.Core;
import enshud.s4.compiler.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import static enshud.s4.compiler.Helper.FileRead.output;
import static enshud.s4.compiler.Helper.SyntaxCheck.functionHash;

/**
 * Created by Cain96 on 2017/03/06.
 */
public class Basic extends Core {
    public CalledVariableExpression calledVariableExpression;
    public Variables variables;
    public Declared declared;
    public Write write;
    public static IO io;

    public Basic(Declared declared) {
        this.write = new Write();
        this.variables = new Variables(declared, write);
        this.calledVariableExpression = new CalledVariableExpression(declared);
        this.declared = declared;
        this.io = new IO();
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
                Iterator<Map.Entry<String, Integer>> functionIterator = declared.declaredFunctions.get(variableName).entrySet().iterator();
                ArrayList<Argument> arguments = new ArrayList<>();
                write.addLabel(";========== Function ===========");
                br = idCheck(br, 33);
                br = calledVariableExpression.checkExpression(br);
                if (functionIterator.hasNext()) {
                    Map.Entry functionEntry = functionIterator.next();
                    if ((Integer)functionEntry.getValue() != calledVariableExpression.val){
                        System.err.println("Semantic error: line " + lineNumber);
                        return null;
                    }
                    arguments.add(new Argument((String)functionEntry.getKey(), isArray));
                } else {
                    System.err.println("Semantic error: line " + lineNumber);
                    return null;
                }
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkExpression(br);
                    if (functionIterator.hasNext()) {
                        Map.Entry functionEntry = functionIterator.next();
                        if ((Integer)functionEntry.getValue() != calledVariableExpression.val){
                            System.err.println("Semantic error: line " + lineNumber);
                            return null;
                        }
                        arguments.add(new Argument((String)functionEntry.getKey(), isArray));
                    } else {
                        System.err.println("Semantic error: line " + lineNumber);
                        return null;
                    }
                }
                Collections.reverse(arguments);
                /** 逆順にpushされるので、その対策 **/
                for (Argument argument : arguments){
                    variables.store(argument.getName(), argument.isArray(), functionHash.get(variableName).getDeclared());
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
            } else {
                variables.callFunction(variableName);
            }
        } else if (hasOption(br, 18)) {
            /**入力文のcheck**/
            write.addLabel(";============= input ===============");
            br = idCheck(br, 18);
            if (hasOption(br, 33)) {
                br = idCheck(br, 33);
                br = idCheck(br, 43);
                br = calledVariableExpression.checkAssignedVariable(br, string, lineNumber);
                io.input(variables.getVariableIndex(string), calledVariableExpression.called.isArray);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = idCheck(br, 43);
                    br = calledVariableExpression.checkAssignedVariable(br, string, lineNumber);
                    io.input(variables.getVariableIndex(string), calledVariableExpression.called.isArray);
                }
                br = idCheck(br, 34);
            }
        } else if (hasOption(br, 23)) {
            /**出力文のcheck**/
            write.addLabel(";============= output ===============");
            br = idCheck(br, 23);
            if (hasOption(br, 33)) {
                br = idCheck(br, 33);
                br = calledVariableExpression.checkExpression(br);
                io.setWriteBuf(calledVariableExpression.getAllArray());
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = calledVariableExpression.checkExpression(br);
                    io.setWriteBuf(calledVariableExpression.getAllArray());
                }
                br = idCheck(br, 34);
            }
            io.endWrite();
        } else if (hasOption(br, 2)) {
            /**複合文のcheck**/
            Compound cs = new Compound(declared);
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
