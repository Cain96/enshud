package enshud.s3.checker.Helper.Syntax.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Type extends Number {

    protected BufferedReader typeCheck(BufferedReader br) {
        /**型のcheck**/
        String line = null;

        if (br != null) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getElements(line);
            if (Arrays.asList(new Integer[]{3, 4, 11}).contains(id)) {
                /**標準型のcheck**/
                return br;
            } else if (id != 1) {
                System.err.println("Syntax error: line " + lineNumber);
                return null;
            }

            /**配列型のcheck**/
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
