package com.ds.level1.patterns;

public class Pattern28 {

	public static void main(String[] args) {
		int n = 5;
		int nos = n - 1;
		int nst = 1;
		int val;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}
			val = 1;
			for (int j = 1; j <= nst; j++) {
				System.out.print(val + "\t");
				if (j <= nst / 2) {
					val++;
				} else {
					val--;
				}
			}

			System.out.println();
			nos--;
			nst += 2;
		}

	}

}
