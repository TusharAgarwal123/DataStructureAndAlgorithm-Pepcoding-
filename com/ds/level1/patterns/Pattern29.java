package com.ds.level1.patterns;

public class Pattern29 {

	public static void main(String[] args) {
		int n = 5;
		int nos = n - 1;
		int nst = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= nst; j++) {
				if (j % 2 == 0) {
					System.out.print("!\t");
				} else {
					System.out.print("*\t");
				}
			}

			System.out.println();
			nos--;
			nst += 2;

		}
	}

}
