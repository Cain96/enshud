package enshud.s2.parser.Helper.Syntax.Statement;


import enshud.s2.parser.Helper.Syntax.Core.Core;
import enshud.s2.parser.Helper.Syntax.Statement.Basic.Basic;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/03/06.
 */
public class Compound extends Core {
	private Basic basic;

	public Compound() {
		this.basic = new Basic();
	}

	public BufferedReader checkCompoundStatement(BufferedReader br) {
		/**複合文のcheck**/
		br = statementChecker(br);
		while (hasOption(br, 37)) {
			br = idCheck(br, 37);
			br = statementChecker(br);
		}
		br = idCheck(br, 8);
		return br;
	}

	private BufferedReader statementChecker(BufferedReader br) {
		/**文のcheck**/
		if (hasOption(br, 10)) {
			/**if分のcheck**/
			br = idCheck(br, 10);
			br = basic.calledVariableExpression.checkExpression(br);
			br = idCheck(br, 19);
			br = idCheck(br, 2);
			br = checkCompoundStatement(br);
			if (hasOption(br, 7)) {
				br = idCheck(br, 7);
				br = idCheck(br, 2);
				br = checkCompoundStatement(br);
			}
		} else if (hasOption(br, 22)) {
			/**while分のcheck**/
			br = idCheck(br, 22);
			br = basic.calledVariableExpression.checkExpression(br);
			br = idCheck(br, 6);
			br = statementChecker(br);
		} else {
			/**基本文のcheck**/
			br = basic.basicStatementChecker(br);
		}
		return br;
	}
}
