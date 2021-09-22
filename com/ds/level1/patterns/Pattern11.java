package com.ds.level1.patterns;

public class Pattern11 {
	public static void main(String[] args) {

		int n = 5;
		int nst = 1;
		int val = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nst; j++) {
				System.out.print(val + "\t");
				val++;
			}
			System.out.println();
			nst++;

		}

	}
}
