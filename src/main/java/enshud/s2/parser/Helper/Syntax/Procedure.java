package enshud.s2.parser.Helper.Syntax;


import enshud.s2.parser.Helper.Syntax.Core.Core;
import enshud.s2.parser.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Procedure extends Core {
    DeclaredVariable declaredVariable;
    Compound compoundStatement;

    public Procedure() {
        this.declaredVariable = new DeclaredVariable();
        this.compoundStatement = new Compound();
    }

    public BufferedReader checkProcedure(BufferedReader br) {
        br = idCheck(br, 16);
        br = idCheck(br, 43);
        if (hasOption(br, 33)) {
            br = idCheck(br, 33);
            br = idCheck(br, 43);
            while (hasOption(br, 41)) {
                br = idCheck(br, 41);
                br = idCheck(br, 43);
            }
            br = idCheck(br, 38);
            br = idCheck(br, new Integer[]{3, 4, 11});
            while (hasOption(br, 37)) {
                br = idCheck(br, 37);
                br = idCheck(br, 43);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = idCheck(br, 43);
                }
                br = idCheck(br, 38);
                br = idCheck(br, new Integer[]{3, 4, 11});
            }
            br = idCheck(br, 34);
        }

        br = idCheck(br, 37);

        /** 変数宣言のcheck **/
        if (hasOption(br, 21)) {
            br = declaredVariable.checkDeclaredVariable(br);
        }

        /** 複合文のcheck **/
        br = compoundStatement.checkCompoundStatement(br);

        br = idCheck(br, 37);
        return br;
    }
}
