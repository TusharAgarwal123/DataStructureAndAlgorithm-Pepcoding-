package com.ds.level1.basic;

public class ReverseOfNumber {

	public static void main(String[] args) {

		int n = 34564;

		while (n != 0) {
			System.out.println(n % 10);
			n = n / 10;
		}

		// printDigitsInReverse(n);
	}

	public static void printDigitsInReverse(int n) {

		if (n == 0) {
			return;
		}

		int res = n % 10;
		System.out.println(res);
		printDigitsInReverse(n / 10);

	}

}
