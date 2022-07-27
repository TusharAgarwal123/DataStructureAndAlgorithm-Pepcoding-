package com.ds.level2.ArrayAndString;

//leetcode 204.

public class CountPrimes {

	public int countPrimes(int n) {

		if (n <= 2) {
			return 0;
		}

		boolean ar[] = new boolean[n];

		for (int i = 2; i * i < ar.length; i++) {

			if (ar[i] == false) {

				for (int j = i; i * j < ar.length; j++) {
					ar[i * j] = true;
				}

			}

		}

		int c = 0;
		for (int i = 2; i < ar.length; i++) {
			if (ar[i] == false) {
				c++;
			}
		}

		return c;

	}

}
