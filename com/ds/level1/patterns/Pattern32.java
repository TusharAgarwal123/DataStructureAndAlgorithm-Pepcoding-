package com.ds.level1.patterns;

public class Pattern32 {

	public static void main(String[] args) {
		int n = 5;
		int nos = n - 1;
		int nst = 1;
		int val;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}
			val = i;
			for (int j = 1; j <= nst; j++) {
				if (j == 1 || j==nst) {
					System.out.print(val + "\t");
				} else {
					System.out.print("0\t");
				}
			}

			System.out.println();
			nos--;
			nst += 2;

		}
	}

}
