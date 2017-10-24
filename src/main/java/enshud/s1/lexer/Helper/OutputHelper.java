package enshud.s1.lexer.Helper;


import enshud.s1.lexer.Token.Check;
import enshud.s1.lexer.Token.TokenList;

import java.io.PrintWriter;

/**
 * Created by Cain96 on 2017/02/05.
 */
public class OutputHelper {
    Check check;
    TokenList tokenList;

    public OutputHelper(TokenList tokenList, Check check) {
        this.tokenList = tokenList;
        this.check = check;
    }

    public void outputToken(String word, int lineNumber, PrintWriter pw) {
        int id = check.getId(word);
        String tokenName = tokenList.getName(id);
        pw.println(word + "\t" + tokenName + "\t" + id + "\t" + lineNumber);
    }
}
