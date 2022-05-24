package com.ds.leetcode.may;

//1641. Count Sorted Vowel Strings
public class CountSortedVowelStrings {

	public int countVowelStrings(int n) {

		if (n == 1) {
			return 5;
		}

		// return process(n,1,"aeiou",0);

		return countUsingDp(n);

	}

	public int countUsingDp(int n) {

		int c = 5;
		int dp[][] = new int[n + 1][c];

		for (int i = 0; i < c; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i < dp.length; i++) {
			for (int j = 0; j <= 3; j++) {
				int count = 0;
				for (int k = j; k <= 4; k++) {
					count += dp[i - 1][k];
				}
				dp[i][j] = count;
			}

			dp[i][4] = 1; // count of u will always be 1.
		}

		int sum = 0;
		for (int i = 0; i < c; i++) {
			sum += dp[n][i];
		}
		return sum;

	}

	// on level we have put n and in options we have valid characters.
	public int process(int n, int cs, String str, int lc) {

		if (cs > n) {
			return 1;
		}

		int c = 0;
		for (int i = lc; i < str.length(); i++) {
			char ch = str.charAt(i);
			c += process(n, cs + 1, str, i);
		}

		return c;

	}

}
