package com.ds.level1.array;

import java.util.Scanner;

public class SubSetsOfArray {

	// we have an array we have to print all it's subset, for n there are 2^n
	// subsets are there.

	// we will use concept of binary for this.
	// we will find the binary value pf each no from 0 to 2^n-1.

	public static void main(String[] args) throws Exception {

		System.out.println("--");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		int limit = (int) Math.pow(2, n);

		for (int i = 0; i < limit; i++) {

			int x = i;
			String ans = "";

			for (int j = n - 1; j >= 0; j--) {
				int r = x % 2;
				x = x / 2;
				if (r == 0) {
					ans = "-\t" + ans;
				} else {
					ans = ar[j] + "\t" + ans;
				}

			}

			System.out.println(ans);

		}

	}

}
