package enshud.s1.lexer.Token;

/**
 * Created by Cain96 on 2017/02/05.
 */
public class Check {

	public int checkId(String kwargs) {
		if (kwargs.equals("and")) {
			return 0;
		} else if (kwargs.equals("array")) {
			return 1;
		} else if (kwargs.equals("begin")) {
			return 2;
		} else if (kwargs.equals("boolean")) {
			return 3;
		} else if (kwargs.equals("char")) {
			return 4;
		} else if (kwargs.equals("div")) {
			return 5;
		} else if (kwargs.equals("do")) {
			return 6;
		} else if (kwargs.equals("else")) {
			return 7;
		} else if (kwargs.equals("end")) {
			return 8;
		} else if (kwargs.equals("false")) {
			return 9;
		} else if (kwargs.equals("if")) {
			return 10;
		} else if (kwargs.equals("integer")) {
			return 11;
		} else if (kwargs.equals("mod")) {
			return 12;
		} else if (kwargs.equals("not")) {
			return 13;
		} else if (kwargs.equals("of")) {
			return 14;
		} else if (kwargs.equals("or")) {
			return 15;
		} else if (kwargs.equals("procedure")) {
			return 16;
		} else if (kwargs.equals("program")) {
			return 17;
		} else if (kwargs.equals("readln")) {
			return 18;
		} else if (kwargs.equals("then")) {
			return 19;
		} else if (kwargs.equals("true")) {
			return 20;
		} else if (kwargs.equals("var")) {
			return 21;
		} else if (kwargs.equals("while")) {
			return 22;
		} else if (kwargs.equals("writeln")) {
			return 23;
		} else if (kwargs.equals("=")) {
			return 24;
		} else if (kwargs.equals("<>")) {
			return 25;
		} else if (kwargs.equals("<")) {
			return 26;
		} else if (kwargs.equals("<=")) {
			return 27;
		} else if (kwargs.equals(">=")) {
			return 28;
		} else if (kwargs.equals(">")) {
			return 29;
		} else if (kwargs.equals("+")) {
			return 30;
		} else if (kwargs.equals("-")) {
			return 31;
		} else if (kwargs.equals("*")) {
			return 32;
		} else if (kwargs.equals("(")) {
			return 33;
		} else if (kwargs.equals(")")) {
			return 34;
		} else if (kwargs.equals("[")) {
			return 35;
		} else if (kwargs.equals("]")) {
			return 36;
		} else if (kwargs.equals(";")) {
			return 37;
		} else if (kwargs.equals(":")) {
			return 38;
		} else if (kwargs.equals("..")) {
			return 39;
		} else if (kwargs.equals(":=")) {
			return 40;
		} else if (kwargs.equals(",")) {
			return 41;
		} else if (kwargs.equals(".")) {
			return 42;
		} else if (isNum(kwargs)) {        //整数型チェック
			return 44;
		} else if (kwargs.startsWith("'")&&kwargs.endsWith("'")) {        //文字列チェック
			return 45;
		} else {
			return 43;
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
