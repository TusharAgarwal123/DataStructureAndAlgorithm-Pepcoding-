package com.ds.level1.recursion;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the last index at which x occurs in array a.
5. If x exists in array, print the last index where it is found otherwise print -1.

 */
public class LastIndex {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int x = sc.nextInt();

		System.out.println(lastIndex(ar, 0, x));
	}

	public static int lastIndex(int[] arr, int idx, int x) {

		if (idx == arr.length) {
			return -1;
		}

		int val = lastIndex(arr, idx + 1, x);
		if (val == -1) {
			if (arr[idx] == x) {
				return idx;
			}
		}
		return val;
	}

}
