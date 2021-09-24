package com.ds.level1.patterns;

public class Pattern22 {

	public static void main(String[] args) {

		int n = 7;
		int nst = 1;
		int nos = (2 * n) - 1;

		for (int i = 1; i <= 2 * n; i++) {
			for (int j = 1; j <= nst; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= nos; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= nst; j++) {
				System.out.print("*");
			}

			if (i < n) {
				nos -= 2;
				nst++;
			} else {
				nos += 2;
				nst--;
			}

			// special case.
			if (i == n) {
				nos -= 2;
				nst++;
			}

			System.out.println();
		}
	}

}
