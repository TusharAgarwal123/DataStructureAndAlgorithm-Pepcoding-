package com.ds.level1.basic;

public class DecimalToAnyBase {

	/*
	 * 
	 * 1. You are given a decimal number n. 2. You are given a base b. 3. You are
	 * required to convert the number n into its corresponding value in base b.
	 * 
	 */

	public static void main(String[] args) {

		int n = 26;
		int b = 2;
		int f = solve(n, b);
		System.out.println(f);
	}

	public static int solve(int n, int b) {
		// write code here
		int ans = 0;
		int p = 1;
		while (n != 0) {
			int rem = n % b;
			n = n / b;
			ans = ans + rem * p;
			p = p * 10;
		}
		return ans;
	}

}
