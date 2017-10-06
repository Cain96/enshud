package enshud.s1.lexer.Token;

/**
 * Created by Cain96 on 2017/02/05.
 */
public class Check {

    public int getId(String kwargs) {
        switch (kwargs) {
            case "and":
                return 0;
            case "array":
                return 1;
            case "begin":
                return 2;
            case "boolean":
                return 3;
            case "char":
                return 4;
            case "div":
            case "/":
                return 5;
            case "do":
                return 6;
            case "else":
                return 7;
            case "end":
                return 8;
            case "false":
                return 9;
            case "if":
                return 10;
            case "integer":
                return 11;
            case "mod":
                return 12;
            case "not":
                return 13;
            case "of":
                return 14;
            case "or":
                return 15;
            case "procedure":
                return 16;
            case "program":
                return 17;
            case "readln":
                return 18;
            case "then":
                return 19;
            case "true":
                return 20;
            case "var":
                return 21;
            case "while":
                return 22;
            case "writeln":
                return 23;
            case "=":
                return 24;
            case "<>":
                return 25;
            case "<":
                return 26;
            case "<=":
                return 27;
            case ">=":
                return 28;
            case ">":
                return 29;
            case "+":
                return 30;
            case "-":
                return 31;
            case "*":
                return 32;
            case "(":
                return 33;
            case ")":
                return 34;
            case "[":
                return 35;
            case "]":
                return 36;
            case ";":
                return 37;
            case ":":
                return 38;
            case "..":
                return 39;
            case ":=":
                return 40;
            case ",":
                return 41;
            case ".":
                return 42;
            default:
                if (isNum(kwargs)) {     //整数型チェック
                    return 44;
                } else if (kwargs.startsWith("'") && kwargs.endsWith("'")) {        //文字列チェック
                    return 45;
                } else {
                    return 43;
                }
        }
    }

    private boolean isNum(String keyword) {
        try {
            Integer.parseInt(keyword);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
