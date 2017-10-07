package enshud.s3.checker.Helper.Semantics.Variable;

/**
 * Created by Cain96 on 2017/10/01.
 */
public class Array {
	String name;
	int min, max;

	public Array(String name, int min, int max) {
		this.name = name;
		this.min = min;
		this.max = max;
	}

	public String getName() {
		return name;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}
