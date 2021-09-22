package com.ds.level1.patterns;

public class Pattern13 {

	public static void main(String[] args) {

		// this question is based on nCr concept.

		// note: nCr+1=(nCr*(n-r))/(r+1).
		// it's mean if we know the value of nCr so we can calculate value of nCr+1.

		int n = 5;

		for (int i = 0; i < n; i++) {
			int val = 1;
			for (int j = 0; j <= i; j++) {

				System.out.print(val + "\t");
				val = (val * (i - j)) / (j + 1);

			}
			System.out.println();
		}

	}

}
