package com.ds.level2.bitManipulation;

import java.util.Scanner;

/*
 * 1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
 */
public class BasicOfBitManipulation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int i = scn.nextInt();
		int j = scn.nextInt();
		int k = scn.nextInt();
		int m = scn.nextInt();

		// write your code here

		int bm = (1 << i);
		System.out.println(n | bm);

		bm = (1 << j);
		bm = ~(bm);
		System.out.println(n & bm);

		bm = (1 << k);
		System.out.println(n ^ bm);

		bm = (1 << m);

		int ans = (n & bm);
		if (ans == 0) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}

	}

}
