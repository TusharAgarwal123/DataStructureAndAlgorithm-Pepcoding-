package com.ds.level1.basic;

public class DigitsOfNumber {

	// you have to print digit of number.
	public static void main(String[] args) {

		int n = 456789;
		int temp = n;
		int div = 1;
		while (temp >= 10) {
			temp = temp / 10;
			div = div * 10;
		}

		temp = n;
		while (div >= 1) {

			int q = n / div;
			System.out.println(q);
			n = n % div;
			div = div / 10;

		}

		// printDigits(n);
	}

	// using recursion
	public static void printDigits(int n) {

		if (n == 0) {
			return;
		}

		int res = n % 10;
		printDigits(n / 10);
		System.out.println(res);

	}

}
