package com.ds.level1.basic;

public class N_1thLargest {

	// you have n digit no you have to find the n-1 digit max no from that no
	// without rearrangement.

	// so we will remove one digit number from given number and find the largest no.

	public static void main(String[] args) {
		int n = 10827;
		int temp = n;
		int c = 0;
		while (temp != 0) {
			temp = temp / 10;
			c++;
		}

		int q = (int) Math.pow(10, c);
		int r = (int) Math.pow(10, c - 1);
		int i = 1;
		int max = Integer.MIN_VALUE;

		while (i <= c) {

			int ans = ((n / q) * r) + (n % r);

			q = q / 10;
			r = r / 10;

			if (ans > max) {
				max = ans;
			}
			i++;

		}

		System.out.println(max);

	}

}
