package com.ds.level1.patterns;

public class Pattern27 {

	public static void main(String[] args) {
		int n = 5;
		int nst = 1;
		int val = 1;
		for (int i = 1; i <= 2 * n - 1; i++) {
			for (int j = 1; j <= nst; j++) {
				if (j % 2 == 0) {
					System.out.print("*\t");
				} else {
					System.out.print(val + "\t");
				}
			}
			System.out.println();

			if (i < n) {
				nst += 2;
				val++;
			} else {
				nst -= 2;
				val--;
			}
		}
	}

}
