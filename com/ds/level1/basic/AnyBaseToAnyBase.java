package com.ds.level1.basic;

public class AnyBaseToAnyBase {

	public static void main(String[] args) {
		/*
		 * 1. You are given a number n. 2. You are given a base b1. n is a number on
		 * base b. 3. You are given another base b2. 4. You are required to convert the
		 * number n of base b1 to a number in base b2.
		 * 
		 */

		int n = 111001;
		int b = 2;
		int b1 = 3;
		int f = anyBaseToDecimal(n, b);

		int ans = decimalToAnyBase(f, b1);
		System.out.println(ans);
	}

	public static int decimalToAnyBase(int n, int b) {

		int ans = 0;
		int p = 1;

		while (n != 0) {
			int rem = n % b;
			n = n / b;
			ans += rem * p;
			p = p * 10;

		}
		return ans;

	}

	public static int anyBaseToDecimal(int n, int b) {
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
