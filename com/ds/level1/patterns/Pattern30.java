package com.ds.level1.patterns;

public class Pattern30 {

	public static void main(String[] args) {

		int n = 5;
		int nos = 0;
		int nst = n;
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= nst; j++) {
				System.out.print("*\t");
			}

			System.out.println();

			if (i < n) {
				nst--;
				nos += 2;
			} else {
				nst++;
				nos -= 2;
			}
		}

	}

}
