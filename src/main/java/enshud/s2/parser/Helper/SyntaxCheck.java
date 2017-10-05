package enshud.s2.parser.Helper;

import enshud.s2.parser.Helper.Syntax.Core.Core;
import enshud.s2.parser.Helper.Syntax.DeclaredVariable;
import enshud.s2.parser.Helper.Syntax.Elements.Elements;
import enshud.s2.parser.Helper.Syntax.Procedure;
import enshud.s2.parser.Helper.Syntax.Program;
import enshud.s2.parser.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Cain96 on 2017/02/06.
 */
public class SyntaxCheck extends Core {
    Program program;
    DeclaredVariable declaredVariable;
    Procedure procedure;
    Compound compoundStatement;

    public SyntaxCheck() {
        this.program = new Program();
        this.declaredVariable = new DeclaredVariable();
        this.procedure = new Procedure();
        this.compoundStatement = new Compound();
    }

    BufferedReader syntaxCheck(String line, BufferedReader br) {

        /** programのcheck **/
        getElements(line);

        if (id == 17) {
            br = program.checkProgram(br);
        } else {
            System.err.println("NG Line" + lineNumber);
            System.exit(-1);
        }

        /** 変数宣言のcheck **/
        if (hasOption(br, 21)) {
            br = declaredVariable.checkDeclaredVariable(br);
        }

        /** 副プログラムのcheck **/
        while (hasOption(br, 16)) {
            br = procedure.checkProcedure(br);
        }

        /** 複合文のcheck **/
        br = compoundStatement.checkCompoundStatement(br);

        br = idCheck(br, 42);

        return br;
    }
}
