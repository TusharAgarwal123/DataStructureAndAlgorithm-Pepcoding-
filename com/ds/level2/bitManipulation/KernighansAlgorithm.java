package com.ds.level2.bitManipulation;

import java.util.Scanner;

/*
 * 1. You are given a number n.
2. You have to count the number of set bits in the given number.
 */
public class KernighansAlgorithm {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int c = 0;

		while (n != 0) {
			int rb = (n & -n);
			c++;
			n = n - rb;

		}

		System.out.println(c);

		// write your code here
	}

}
