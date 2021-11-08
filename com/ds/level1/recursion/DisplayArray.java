package com.ds.level1.recursion;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the elements of array from beginning to end each in a separate line.
 */
public class DisplayArray {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		displayArr(ar, 0);
	}

	public static void displayArr(int[] arr, int idx) {

		if (idx == arr.length) {
			return;
		}

		System.out.println(arr[idx]);
		displayArr(arr, idx + 1);

	}

}
