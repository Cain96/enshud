package enshud.s2.parser.Helper.Syntax.Core;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Number extends Core {

    BufferedReader numberCheck(BufferedReader br) {
        /**整数のcheck**/
        if (br != null) {
            if (hasOption(br, new Integer[]{30, 31})) {
                /**符号付き整数**/
                br = idCheck(br, new Integer[]{30, 31});
            }
            /**符号なし整数**/
            br = idCheck(br, 44);
        }
        return br;
    }
}
