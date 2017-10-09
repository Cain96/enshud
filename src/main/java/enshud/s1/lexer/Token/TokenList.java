package enshud.s1.lexer.Token;

import java.util.HashMap;

/**
 * Created by Cain96 on 2016/12/21.
 */
public class TokenList {
	private HashMap<Integer, String> list = new HashMap<Integer, String>();

	public TokenList() {
		list.put(0, "SAND");
		list.put(1, "SARRAY");
		list.put(2, "SBEGIN");
		list.put(3, "SBOOLEAN");
		list.put(4, "SCHAR");
		list.put(5, "SDIVD");
		list.put(6, "SDO");
		list.put(7, "SELSE");
		list.put(8, "SEND");
		list.put(9, "SFALSE");
		list.put(10, "SIF");
		list.put(11, "SINTEGER");
		list.put(12, "SMOD");
		list.put(13, "SNOT");
		list.put(14, "SOF");
		list.put(15, "SOR");
		list.put(16, "SPROCEDURE");
		list.put(17, "SPROGRAM");
		list.put(18, "SREADLN");
		list.put(19, "STHEN");
		list.put(20, "STRUE");
		list.put(21, "SVAR");
		list.put(22, "SWHILE");
		list.put(23, "SWRITELN");
		list.put(24, "SEQUAL");
		list.put(25, "SNOTEQUAL");
		list.put(26, "SLESS");
		list.put(27, "SLESSEQUAL");
		list.put(28, "SGREATEQUAL");
		list.put(29, "SGREAT");
		list.put(30, "SPLUS");
		list.put(31, "SMINUS");
		list.put(32, "SSTAR");
		list.put(33, "SLPAREN");
		list.put(34, "SRPAREN");
		list.put(35, "SLBRACKET");
		list.put(36, "SRBRACKET");
		list.put(37, "SSEMICOLON");
		list.put(38, "SCOLON");
		list.put(39, "SRANGE");
		list.put(40, "SASSIGN");
		list.put(41, "SCOMMA");
		list.put(42, "SDOT");
		list.put(43, "SIDENTIFIER");
		list.put(44, "SCONSTANT");
		list.put(45, "SSTRING");
	}

	public String getName(int id) {
		return list.get(id);
	}
}
