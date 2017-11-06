package enshud.s4.compiler.Helper;

import enshud.s4.compiler.Helper.Output.End;
import enshud.s4.compiler.Helper.Syntax.Core.Core;
import enshud.s4.compiler.Helper.Syntax.DeclaredVariable;
import enshud.s4.compiler.Helper.Syntax.Procedure;
import enshud.s4.compiler.Helper.Syntax.Program;
import enshud.s4.compiler.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;

import static enshud.s4.compiler.Helper.FileRead.output;

/**
 * Created by Cain96 on 2017/02/06.
 */
public class SyntaxCheck extends Core {
    Program program;
    DeclaredVariable declaredVariable;
    Compound compoundStatement;
    End end;

    public SyntaxCheck() {
        this.program = new Program();
        this.declaredVariable = new DeclaredVariable();
        this.compoundStatement = new Compound(declaredVariable.declared);
        this.end = new End();
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

        output.addFile(end.getBuf());

        return br;
    }
}
