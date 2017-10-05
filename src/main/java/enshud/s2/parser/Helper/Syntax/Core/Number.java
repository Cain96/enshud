package enshud.s2.parser.Helper.Syntax.Core;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Number extends Core {

	BufferedReader numberCheck(BufferedReader br) {
		/**整数のcheck**/
		String line = null;

		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getElements(line);
		if (id == 30 || id == 31) {
			/**符号付き整数**/
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			getElements(line);
			if (id != 44) {
				System.err.println("Syntax error: line " + lineNumber);
				System.exit(-1);
			}
		} else if (id != 44) {
			/**符号なし整数**/
			System.err.println("Syntax error: line " + lineNumber);
			System.exit(-1);
		}

		return br;
	}
}
