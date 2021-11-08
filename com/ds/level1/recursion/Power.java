package com.ds.level1.recursion;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(power(x, n));
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		return x * power(x, n - 1);
	}

	// using log(n)
	public static int power2(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnb2 = power(x, n / 2);
		int xn = xpnb2 * xpnb2;
		if (n % 2 == 1) {
			xn = xn * x;
		}
		return xn;

	}

}
