package enshud.s4.compiler.Helper.Syntax;

import enshud.s4.compiler.Helper.Semantics.Variable.Declared;
import enshud.s4.compiler.Helper.Syntax.Core.Type;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class DeclaredVariable extends Type {

    public Declared declared;

    public DeclaredVariable(int index) {
        this.declared = new Declared(index);
    }

    public BufferedReader checkDeclaredVariable(BufferedReader br) {
        ArrayList<String> variables = new ArrayList<>();

        br = idCheck(br, 21);
        br = idCheck(br, 43);
        variables.add(limitWordCount(string));
        while (hasOption(br, 41)) {
            br = idCheck(br, 41);
            br = idCheck(br, 43);
            variables.add(limitWordCount(string));
        }
        br = idCheck(br, 38);
        br = typeCheck(br, variables, declared);
        br = idCheck(br, 37);

        while (hasOption(br, 43)) {
            variables.clear();
            br = idCheck(br, 43);
            variables.add(limitWordCount(string));
            while (hasOption(br, 41)) {
                br = idCheck(br, 41);
                br = idCheck(br, 43);
                variables.add(limitWordCount(string));
            }
            br = idCheck(br, 38);
            br = typeCheck(br, variables, declared);
            br = idCheck(br, 37);
        }
        return br;
    }

    private String limitWordCount(String str) {
        if (str.length() > 8) {
            str = str.substring(0, 9);
        }
        return str;
    }
}
