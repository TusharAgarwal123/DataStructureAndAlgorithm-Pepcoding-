package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
 */
public class MaximumSumNonAdjacentElements {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		int inc = ar[0];
		int exc = 0;

		for (int i = 1; i < ar.length; i++) {
			int ninc = exc + ar[i];
			int nexc = Math.max(inc, exc);
			inc = ninc;
			exc = nexc;
		}

		System.out.println(Math.max(inc, exc));

	}

}
