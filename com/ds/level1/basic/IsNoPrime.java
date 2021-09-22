package com.ds.level1.basic;

import java.util.Scanner;

public class IsNoPrime {

	public static void main(String[] args) {

		int n = 10;

		boolean isPrime = true;
		for (int div = 2; div * div <= n; div++) {
			int rem = n % div;
			if (rem == 0) {
				isPrime = false;
				break;
			}
		}

		if (isPrime == true) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}
}
