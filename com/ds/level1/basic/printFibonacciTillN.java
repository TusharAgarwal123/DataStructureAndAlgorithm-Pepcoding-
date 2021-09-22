package com.ds.level1.basic;

public class printFibonacciTillN {

	public static void main(String[] args) {

		int n = 6;

		int a = 0;
		int b = 1;

		for (int i = 1; i <= n; i++) {

			System.out.println(a);
			int c = a + b;
			a = b;
			b = c;

		}

	}

}
