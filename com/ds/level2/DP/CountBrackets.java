package com.ds.level2.DP;

/*
 * 1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing
 brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))

 */

//it is based on catalan number
public class CountBrackets {

	static int numberOfBracket(int N) {

		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int right = i - j - 1;
				int val = (dp[j] * dp[right]);
				dp[i] = (dp[i] + val);

			}
		}

		return dp[N];

	}

}
