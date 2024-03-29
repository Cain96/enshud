package enshud.s3.checker.Helper.Syntax;

import enshud.s3.checker.Helper.Semantics.Variable.Declared;
import enshud.s3.checker.Helper.Syntax.Core.Type;
import enshud.s3.checker.Helper.Syntax.Statement.Compound;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Procedure extends Type {
    private DeclaredVariable declaredVariable;
    private Compound compoundStatement;
    private Declared declared;

    public Procedure(Declared declared) {
        this.declaredVariable = new DeclaredVariable();
        this.declared = declared;
        this.compoundStatement = new Compound(declaredVariable.declared);
    }

    public BufferedReader checkProcedure(BufferedReader br) {
        ArrayList<String> list = new ArrayList<>();
        LinkedHashMap<String, Integer> variables = new LinkedHashMap<>();

        br = idCheck(br, 16);
        br = idCheck(br, 43);
        String procedureName = string;
        if (hasOption(br, 33)) {
            br = idCheck(br, 33);
            br = idCheck(br, 43);
            list.add(string);
            while (hasOption(br, 41)) {
                br = idCheck(br, 41);
                br = idCheck(br, 43);
                list.add(string);
            }
            br = idCheck(br, 38);
            br = procedureTypeCheck(br);
            /**Listをmapへ変換**/
            variables.putAll(list.stream().collect(Collectors.toMap(s -> s, i -> id)));
            while (hasOption(br, 37)) {
                list.clear();
                br = idCheck(br, 37);
                br = idCheck(br, 43);
                list.add(string);
                while (hasOption(br, 41)) {
                    br = idCheck(br, 41);
                    br = idCheck(br, 43);
                    list.add(string);
                }
                br = idCheck(br, 38);
                br = procedureTypeCheck(br);
                variables.putAll(list.stream().collect(Collectors.toMap(s -> s, i -> id)));
            }
            br = idCheck(br, 34);
        }
        br = declared.addFunction(br, procedureName, variables, lineNumber);

        br = idCheck(br, 37);

        /** 変数宣言のcheck **/
        if (hasOption(br, 21)) {
            br = declaredVariable.checkDeclaredVariable(br);
        }

        declaredVariable.declared.setDeclared(declared);

        /** 複合文のcheck **/
        br = compoundStatement.checkCompoundStatement(br);

        br = idCheck(br, 37);
        return br;
    }

    private String limitWordCount(String str) {
        if (str.length() > 8) {
            str = str.substring(0, 9);
        }
        return str;
    }
}
