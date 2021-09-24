package com.ds.level1.patterns;

public class Pattern23 {

	public static void main(String[] args) {
		int n = 5;
		int nst = 1;
		int nos = n - 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}

			int k = i;
			for (int j = 1; j <= nst; j++) {

				if (j < i) {
					System.out.print(k + "\t");
					k++;
				} else {
					System.out.print(k + "\t");
					k--;
				}

			}

			System.out.println();
			nst += 2;
			nos--;
		}
	}

}
