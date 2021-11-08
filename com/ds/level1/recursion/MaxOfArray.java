package com.ds.level1.recursion;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the maximum of input. 
 */
public class MaxOfArray {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		System.out.println(maxOfArray(ar, 0));
	}

	public static int maxOfArray(int[] arr, int idx) {

		if (idx == arr.length) {
			return Integer.MIN_VALUE;
		}
		// or
//		if(idx==arr.length-1){
//            return arr[idx];
//        }

		int maxValue = maxOfArray(arr, idx + 1);
		return Math.max(maxValue, arr[idx]);
	}

}
