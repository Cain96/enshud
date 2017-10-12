package enshud.s2.parser.Helper.Syntax.Core;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Type extends Number {

    protected BufferedReader typeCheck(BufferedReader br) {
        /**型のcheck**/
        if (br != null) {
            if (hasOption(br, new Integer[]{3, 4, 11})) {
                /**標準型のcheck**/
                br = idCheck(br, new Integer[]{3, 4, 11});
                return br;
            } else if (!hasOption(br, 1)) {
                System.err.println("Syntax error: line " + lineNumber);
                return null;
            }

            /**配列型のcheck**/
            br = idCheck(br, 1);
            br = idCheck(br, 35);
            br = numberCheck(br);
            br = idCheck(br, 39);
            br = numberCheck(br);
            br = idCheck(br, 36);
            br = idCheck(br, 14);
            br = idCheck(br, new Integer[]{3, 4, 11});
        }
        return br;
    }
}
