package com.ds.level1.basic;

public class AnyBaseToDecimal {

	/*
	 * 
	 * 1. You are given a number n. 2. You are given a base b. n is a number on base
	 * b. 3. You are required to convert the number n into its corresponding value
	 * in decimal number system.
	 * 
	 */
	public static void main(String[] args) {

		int n = 111001;
		int b = 2;
		int f = solve(n, b);
		System.out.println(f);
	}

	public static int solve(int n, int b) {
		// write code here
		int ans = 0;
		int p = 1;
		while (n != 0) {
			int rem = n % 10;
			n = n / 10;
			ans = ans + rem * p;
			p = p * b;
		}
		return ans;
	}
}
