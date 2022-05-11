package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.
 */
public class LargestNumberPossibleAfterAtMostKSwaps {

	static String max;

	//on level we have no of swaps that is k, and on each level we have n^2 option.
	public static void findMaximum(String str, int k) {
		// write your code here

		if (Integer.parseInt(str) > Integer.parseInt(max)) {
			max = str;
		}

		if (k == 0) {
			return;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) > str.charAt(i)) {
					String swappedStr = swap(str, i, j);
					findMaximum(swappedStr, k - 1);
					// need not to make backtracking call bcoz we have not
					// changed in original string.
				}
			}
		}

	}

	public static String swap(String str, int i, int j) {

		char ith = str.charAt(i);
		char jth = str.charAt(j);

		String left = str.substring(0, i);
		String middle = str.substring(i + 1, j);
		String right = str.substring(j + 1);

		return left + jth + middle + ith + right;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}
