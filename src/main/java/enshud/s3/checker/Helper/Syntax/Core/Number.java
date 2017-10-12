package enshud.s3.checker.Helper.Syntax.Core;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Number extends Core {
    int min, max;

    BufferedReader numberCheck(BufferedReader br, boolean flag) {
        /**整数のcheck**/
        /**flag = true : min**/
        /**flag = false : max**/

        int num;
        boolean minus = false;

        if (hasOption(br, new Integer[]{30, 31})) {
            /**符号付き整数**/
            br = idCheck(br, new Integer[]{30, 31});
            if (string.equals("-")) {
                minus = true;
            }
        }
        /**符号なし整数**/
        if ((br = idCheck(br, 44)) != null) {

            num = Integer.parseInt(string);

            if (minus) {
                num = -num;
            }
            if (flag) {
                min = num;
            } else {
                max = num;
            }
        }

        return br;
    }
}
