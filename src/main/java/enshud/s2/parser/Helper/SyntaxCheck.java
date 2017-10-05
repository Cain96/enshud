package enshud.s2.parser.Helper;

import enshud.s2.parser.Helper.Syntax.DeclaredVariable;
import enshud.s2.parser.Helper.Syntax.Procedure;
import enshud.s2.parser.Helper.Syntax.Program;
import enshud.s2.parser.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/02/06.
 */
public class SyntaxCheck {
    private int id;
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
        String[] elements = line.split("\t");
        try {
            id = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        /** programのcheck **/
        if (id == 17) {
            br = program.checkProgram(br);
        }

        /** 変数宣言のcheck **/
        if (id == 21) {
            br = declaredVariable.checkDeclaredVariable(br);
        }

        /** 副プログラムのcheck **/
        if (id == 16) {
            br = procedure.checkProcedure(br);
        }

        /** 複合文のcheck **/
        if (id == 2) {
            br = compoundStatement.checkCompoundStatement(br);
        }

        return br;
    }
}
