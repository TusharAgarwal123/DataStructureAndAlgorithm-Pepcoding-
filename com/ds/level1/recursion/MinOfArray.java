package com.ds.level1.recursion;

import java.util.Scanner;

public class MinOfArray {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		System.out.println(minOfArray(ar, 0));
	}

	public static int minOfArray(int[] arr, int idx) {

		if (idx == arr.length - 1) {
			return arr[idx];
		}

		int maxValue = minOfArray(arr, idx + 1);
		return Math.min(maxValue, arr[idx]);
	}
}
