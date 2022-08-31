package com.ds.level2.ArrayAndString;

//903 · Range Addition  on lintcode.

public class RangeAddition {

	public int[] getModifiedArray(int length, int[][] updates) {
		// Write your code here
		int[] res = new int[length];

		for (int[] up : updates) {
			int start = up[0];
			int end = up[1];
			int delta = up[2];

			res[start] += delta;

			if (end + 1 < length) {
				res[end + 1] -= delta;
			}
		}

		for (int i = 1; i < length; i++) {
			res[i] += res[i - 1];
		}

		return res;
	}

}
