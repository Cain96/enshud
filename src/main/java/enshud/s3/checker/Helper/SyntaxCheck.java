package enshud.s3.checker.Helper;

import enshud.s3.checker.Helper.Syntax.Core.Core;
import enshud.s3.checker.Helper.Syntax.DeclaredVariable;
import enshud.s3.checker.Helper.Syntax.Elements.Elements;
import enshud.s3.checker.Helper.Syntax.Procedure;
import enshud.s3.checker.Helper.Syntax.Program;
import enshud.s3.checker.Helper.Syntax.Statement.Compound;

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
        this.compoundStatement = new Compound(declaredVariable.declared);
    }

    BufferedReader syntaxCheck(String line, BufferedReader br) {

        /** programのcheck **/
        getElements(line);

        if (id == 17) {
            br = program.checkProgram(br);
        } else {
            System.err.println("Syntax error: line " + lineNumber);
            return null;
        }

        /** 変数宣言のcheck **/
        if (hasOption(br, 21) && (br != null)) {
            br = declaredVariable.checkDeclaredVariable(br);
        }

        /** 副プログラムのcheck **/
        while (hasOption(br, 16) && (br != null)) {
            br = new Procedure(declaredVariable.declared).checkProcedure(br);
        }

        /** 複合文のcheck **/
        if (br != null) {
            br = compoundStatement.checkCompoundStatement(br);
        }
        if (br != null) {
            br = idCheck(br, 42);
        }

        return br;
    }
}
