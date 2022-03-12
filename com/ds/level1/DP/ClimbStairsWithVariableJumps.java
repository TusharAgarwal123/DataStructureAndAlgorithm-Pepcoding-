package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
 */

public class ClimbStairsWithVariableJumps {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		System.out.println(countJumps(n, ar));

	}

	// tabulation
	// here we are start solving the problem from last bcoz smaller problem is at
	// last. we can also solve this problem from top to bottom then we have to
	// change the meaning of dp.
	public static int countJumps(int n, int ar[]) {

		int dp[] = new int[n + 1];

		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= ar[i] && i + j < dp.length; j++) {
				dp[i] = dp[i] + dp[i + j];
			}
		}

		return dp[0];

	}

}
