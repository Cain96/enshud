package enshud.s2.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import enshud.s2.parser.Parser;

/**
 * !!! このコードは編集禁止 !!!
 * 
 * Parserの単体テストクラス
 * ここに記述された全ての単体テストが正しく動作するようにParser.run()メソッドを開発すること
 * 
 * テストクラスの読み方はTrialTest.javaのコメントを確認すること．
 * 
 * 基本的にはparser.run("data/ts/XXXX.ts")を実行し，以下を確認している．
 * - XXXXがnormalXXの場合： "OK"と出力されるか，
 * - XXXXがsynerrXXの場合： "Syntax error: line X"と正しく出力されるか，
 * - XXXXがsemerrXXの場合： "OK"と出力されるか，
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParserTest {
	@Rule
	public final Timeout globalTimeout = Timeout.seconds(10);
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	private ByteArrayOutputStream out;
	private ByteArrayOutputStream err;

	@Before
	public void before() {
		out = new ByteArrayOutputStream();
		err = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		System.setErr(new PrintStream(err));
	}

	@After
	public void after() throws IOException {
		out.close();
		err.close();
	}

	@Test
	public void testNormal01() {
		new Parser().run("data/ts/normal01.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal02() {
		new Parser().run("data/ts/normal02.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal03() {
		new Parser().run("data/ts/normal03.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal04() {
		new Parser().run("data/ts/normal04.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal05() {
		new Parser().run("data/ts/normal05.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal06() {
		new Parser().run("data/ts/normal06.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal07() {
		new Parser().run("data/ts/normal07.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal08() {
		new Parser().run("data/ts/normal08.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal09() {
		new Parser().run("data/ts/normal09.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testNormal10() {
		new Parser().run("data/ts/normal10.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testSynerr01() {
		new Parser().run("data/ts/synerr01.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 1");
	}

	@Test
	public void testSynerr02() {
		new Parser().run("data/ts/synerr02.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 3");
	}

	@Test
	public void testSynerr03() {
		new Parser().run("data/ts/synerr03.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 8");
	}

	@Test
	public void testSynerr04() {
		new Parser().run("data/ts/synerr04.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 10");
	}

	@Test
	public void testSynerr05() {
		new Parser().run("data/ts/synerr05.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 11");
	}

	@Test
	public void testSynerr06() {
		new Parser().run("data/ts/synerr06.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 13");
	}

	@Test
	public void testSynerr07() {
		new Parser().run("data/ts/synerr07.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 29");
	}

	@Test
	public void testSynerr08() {
		new Parser().run("data/ts/synerr08.ts");
		assertThat(err.toString().trim()).isEqualTo("Syntax error: line 31");
	}

	////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testSemerr01() {
		new Parser().run("data/ts/semerr01.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr02() {
		new Parser().run("data/ts/semerr02.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr03() {
		new Parser().run("data/ts/semerr03.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr04() {
		new Parser().run("data/ts/semerr04.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr05() {
		new Parser().run("data/ts/semerr05.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr06() {
		new Parser().run("data/ts/semerr06.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr07() {
		new Parser().run("data/ts/semerr07.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	@Test
	public void testSemerr08() {
		new Parser().run("data/ts/semerr08.ts");
		assertThat(out.toString().trim()).isEqualTo("OK");
	}

	////////////////////////////////////////////////////////////////////////////////

	/**
	 *  入力ファイルが存在しない場合に正しく動作するか
	 */
	@Test
	public void test_InputFileNotFound() {
		new Parser().run("data/ts/xxxxxxxx.ts");
		assertThat(err.toString().trim()).isEqualTo("File not found");
	}
}
