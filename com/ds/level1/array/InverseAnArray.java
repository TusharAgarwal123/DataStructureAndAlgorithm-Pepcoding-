package com.ds.level1.array;

public class InverseAnArray {

	public static int[] inverse(int[] a) {
		// write your code here

		int b[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			b[a[i]] = i;
		}

		return b;
	}

}
