package enshud.s2.parser.Helper.Syntax.Statement.Basic;


import enshud.s2.parser.Helper.Syntax.Core.Core;

import java.io.BufferedReader;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class CalledVariableExpression extends Core {

	BufferedReader checkCalledVariable(BufferedReader br) {
		/**変数のcheck**/
		if (hasOption(br, 35)) {
			br = idCheck(br, 35);
			br = checkExpression(br);
			br = idCheck(br, 36);
		}
		return br;
	}

	public BufferedReader checkExpression(BufferedReader br) {
		/**式のcheck**/
		br = checkSimpleExpression(br);
		while (hasOption(br, new Integer[]{24, 25, 26, 27, 28, 29})) {/**関係演算子**/
			br = idCheck(br, new Integer[]{24, 25, 26, 27, 28, 29});
			br = checkSimpleExpression(br);
		}
		return br;
	}

	private BufferedReader checkSimpleExpression(BufferedReader br) {
		/**単純式のcheck**/
		if (hasOption(br, new Integer[]{30, 31})) {/**符号**/
			br = idCheck(br, new Integer[]{30, 31});
		}
		br = checkTerm(br);
		while (hasOption(br, new Integer[]{15, 30, 31})) {/**加法演算子**/
			br = idCheck(br, new Integer[]{15, 30, 31});
			br = checkTerm(br);
		}
		return br;
	}

	private BufferedReader checkTerm(BufferedReader br) {
		/**項のcheck**/
		br = checkFactor(br);
		while (hasOption(br, new Integer[]{0, 5, 12, 32})) {/**乗法演算子**/
			br = idCheck(br, new Integer[]{0, 5, 12, 32});
			br = checkFactor(br);
		}
		return br;
	}

	private BufferedReader checkFactor(BufferedReader br) {
		/**因子のcheck**/
		if (hasOption(br, 43)) {
			/**変数**/
			br = idCheck(br, 43);
			br = checkCalledVariable(br);
		} else if (hasOption(br, new Integer[]{9, 20, 44, 45})) {
			/**定数**/
			br = idCheck(br, new Integer[]{9, 20, 44, 45});
		} else if (hasOption(br, 33)) {
			/**"("式")"**/
			br = idCheck(br, 33);
			br = checkExpression(br);
			br = idCheck(br, 34);
		} else if (hasOption(br, 13)) {
			/**"not" 因子**/
			br = idCheck(br, 13);
			br = checkFactor(br);
		} else {
			System.err.println("Syntax error: line " + lineNumber);
			System.exit(-1);
		}
		return br;
	}
}
