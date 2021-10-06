package com.ds.level1.basic;

public class AnyBaseAddition {

	/*
	 * 
	 * 1. You are given a base b. 2. You are given two numbers n1 and n2 of base b.
	 * 3. You are required to add the two numbes and print their value in base b.
	 */

	public static void main(String[] args) {

		int b = 8;
		int n1 = 777;
		int n2 = 1;

		int d = getSum(b, n1, n2);
		System.out.println(d);
	}

	public static int getSum(int b, int n1, int n2) {

		int c = 0;
		int ans = 0;
		int p = 1;
		while (n1 > 0 || n2 > 0 || c > 0) {
			int r1 = n1 % 10;
			n1 = n1 / 10;

			int r2 = n2 % 10;
			n2 = n2 / 10;

			int d = r1 + r2 + c;

			c = d / b;
			d = d % b;

			ans += d * p;
			p = p * 10;
		}
		return ans;
	}

}
