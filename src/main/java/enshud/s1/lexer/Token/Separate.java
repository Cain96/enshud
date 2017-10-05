package enshud.s1.lexer.Token;


import enshud.s1.lexer.Helper.OutputHelper;

import java.io.PrintWriter;

/**
 * Created by Cain96 on 2017/02/05.
 */
public class Separate {
	private OutputHelper outputHelper;

	private int i;
	private String word;
	private char ch;

	public Separate(OutputHelper outputHelper) {
		this.outputHelper = outputHelper;
	}

	public void separateLine(String line, int lineNumber, PrintWriter pw) {
		for (i = 0; i < line.length(); i++) {
			word = null;
			ch = line.charAt(i);
			if (ch == ' ' || ch == '\t') {
				continue;
			} else if (ch == '{') {
				while (ch != '}') {
					i++;
					ch = line.charAt(i);
				}
				continue;
			} else if (Character.isLetter(ch)) {    //文字の場合
				try {
					while (Character.isLetterOrDigit(ch)) {
						combineChar(line);
					}
				} catch (StringIndexOutOfBoundsException e) {

				}
				i--;
			} else if (Character.isDigit(ch)) {        //数字の場合
				try {
					while (Character.isDigit(ch)) {
						combineChar(line);
					}
				} catch (StringIndexOutOfBoundsException e) {

				}
				i--;
			} else if (ch == '\'') {                //文字列の場合
				try {
					do {
						combineChar(line);
					} while (ch != '\'');
					word = word + String.valueOf(ch);
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			} else {                                //記号の場合
				int j = i + 1;
				try {
					char chr = line.charAt(j);
					if (ch == '<' && (chr == '>' || chr == '=')) {
						combineSymbol(chr);
						outputHelper.outputToken(word, lineNumber, pw);
						continue;
					} else if ((ch == '>' || ch == ':') && (chr == '=')) {
						combineSymbol(chr);
						outputHelper.outputToken(word, lineNumber, pw);
						continue;
					} else if ((ch == '.') && (chr == '.')) {
						combineSymbol(chr);
						outputHelper.outputToken(word, lineNumber, pw);
						continue;
					}
				} catch (StringIndexOutOfBoundsException e) {
				}
				word = String.valueOf(ch);
			}
			outputHelper.outputToken(word, lineNumber, pw);
		}
	}

	private void combineChar(String line) {
		if (word != null) {
			word = word + String.valueOf(ch);
		} else {
			word = String.valueOf(ch);
		}
		i++;
		ch = line.charAt(i);
	}

	private void combineSymbol(char chr) {
		word = String.valueOf(ch) + String.valueOf(chr);
		i++;
	}
}
