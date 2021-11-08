package com.ds.level1.recursion;

import java.util.Scanner;

/*
 * you are given a number you have to print the sum of all odd digit in it.
 */
public class OddSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));
	}

	public static int solve(int n) {

		if (n == 0) {
			return 0;
		}
		int sum = solve(n / 10);
		if ((n % 10) % 2 == 1) {
			sum += (n % 10);
		}
		return sum;

	}

}
