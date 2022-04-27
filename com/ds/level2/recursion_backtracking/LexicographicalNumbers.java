package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are given a number.
2. You have to print all the numbers from 1 to n in lexicographical order.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
 */
public class LexicographicalNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		// write your code here

		for (int i = 1; i <= 9; i++) {
			dfs(i, n);
		}
	}

	public static void dfs(int i, int n) {
		if (i > n) {
			return;
		}

		System.out.println(i);

		for (int j = 0; j <= 9; j++) {
			dfs(i * 10 + j, n);
		}

	}

}
