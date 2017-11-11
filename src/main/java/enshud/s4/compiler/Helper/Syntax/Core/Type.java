package enshud.s4.compiler.Helper.Syntax.Core;

import enshud.s4.compiler.Helper.Semantics.Variable.Array;
import enshud.s4.compiler.Helper.Semantics.Variable.Declared;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Type extends Number {

    protected BufferedReader typeCheck(BufferedReader br, ArrayList<String> variables, Declared declared) {
        /**型のcheck**/
        if (br != null) {
            if (hasOption(br, new Integer[]{3, 4, 11})) {
                /**標準型のcheck**/
                br = idCheck(br, new Integer[]{3, 4, 11});
                br = declared.addVariables(br, id, variables, lineNumber);
                return br;
            } else if (!hasOption(br, 1)) {
                System.err.println("Syntax error: line " + lineNumber);
                return null;
            }

            /**配列型のcheck**/
            br = idCheck(br, 1);
            br = idCheck(br, 35);
            br = numberCheck(br, true);
            br = idCheck(br, 39);
            br = numberCheck(br, false);
            br = idCheck(br, 36);
            br = idCheck(br, 14);
            br = idCheck(br, new Integer[]{3, 4, 11});
            br = declared.addArray(br, id, new Array(variables.get(0), min, max), lineNumber);
        }
        return br;
    }

    protected BufferedReader procedureTypeCheck(BufferedReader br, ArrayList<String> variables, Declared declared) {
        /**型のcheck**/
        if (br != null) {
            if (hasOption(br, new Integer[]{3, 4, 11})) {
                /**標準型のcheck**/
                br = idCheck(br, new Integer[]{3, 4, 11});
                declared.addProcedureVariables(id, variables);
                return br;
            } else if (!hasOption(br, 1)) {
                System.err.println("Syntax error: line " + lineNumber);
                return null;
            }
        }
        return br;
    }
}
