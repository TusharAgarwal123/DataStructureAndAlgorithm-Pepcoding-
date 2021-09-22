package com.ds.level1.basic;

public class PrimeFactor {

	public static void main(String[] args) {
		// write your code here

		int n = 20;

		for (int i = 2; i * i <= n; i++) {

			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}

		}

		if (n > 1) {
			System.out.println(n);
		}

	}

}
