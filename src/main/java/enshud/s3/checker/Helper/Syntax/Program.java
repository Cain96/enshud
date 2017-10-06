package enshud.s3.checker.Helper.Syntax;

import enshud.s3.checker.Helper.Syntax.Core.Core;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Program extends Core {
    public BufferedReader checkProgram(BufferedReader br) {
        br = idCheck(br, 43);
        br = idCheck(br, 33);
        br = idCheck(br, 43);
        while (hasOption(br, 41)) {
            br = idCheck(br, 41);
            br = idCheck(br, 43);
        }
        br = idCheck(br, 34);
        br = idCheck(br, 37);
        return br;
    }
}
