package enshud.s3.checker.Helper.Syntax;

import enshud.s3.checker.Helper.Syntax.Core.Type;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class DeclaredVariable extends Type {
    public BufferedReader checkDeclaredVariable(BufferedReader br) {
        br = idCheck(br, 21);
        br = idCheck(br, 43);
        while (hasOption(br, 41)) {
            br = idCheck(br, 41);
            br = idCheck(br, 43);
        }
        br = idCheck(br, 38);
        br = typeCheck(br);
        br = idCheck(br, 37);

        while (hasOption(br, 43)) {
            br = idCheck(br, 43);
            while (hasOption(br, 41)) {
                br = idCheck(br, 41);
                br = idCheck(br, 43);
            }
            br = idCheck(br, 38);
            br = typeCheck(br);
            br = idCheck(br, 37);
        }
        return br;
    }
}
