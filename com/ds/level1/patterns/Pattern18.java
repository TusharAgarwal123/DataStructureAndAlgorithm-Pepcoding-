package com.ds.level1.patterns;

public class Pattern18 {

	public static void main(String[] args) {

		int n = 7;
		int nos = 0;
		int nst = n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= nst; j++) {

				if (i >= 2 && i <= n / 2) { // this condition is for upper empty

					// if (i >= (n / 2) + 2 && i <= n - 1) { //this condition is for lower empty

					if (j == 1 || j == nst) {
						System.out.print("*\t");
					} else {
						System.out.print("\t");
					}

				} else {

					System.out.print("*\t");
				}
			}

			System.out.println();

			if (i <= n / 2) {
				nos++;
				nst -= 2;
			} else {
				nos--;
				nst += 2;
			}
		}

	}

}
