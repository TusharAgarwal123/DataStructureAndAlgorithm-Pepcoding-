package com.ds.level1.array;

import java.util.Scanner;

/*
 * you are given an array, you have to find the equilibrium index, equilibrium index is index where sum of
 * all element to it's left is equal to sum of all element to it's right.
 */

public class EquilibriumIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		System.out.println(equilibriumIndex(ar));

	}

	// this is optimize approach
	public static int equilibriumIndex(int[] ar) {

		int ls = 0;
		int rs = 0;
		for (int i = 1; i < ar.length; i++) {
			rs += ar[i];
		}

		// checking first index
		if (ls == rs) {
			return 0;
		}

		for (int i = 1; i < ar.length; i++) {
			ls = ls + ar[i - 1];
			rs = rs - ar[i];

			if (ls == rs) {
				return i;
			}
		}
		return -1;

	}

//	this is brute force approach
//	public static int equilibriumIndex(int[] ar) {
//
//		for (int i = 0; i < ar.length; i++) {
//			int ls = 0;
//			// left sum
//			for (int j = 0; j < i; j++) {
//				ls += ar[j];
//			}
//
//			int rs = 0;
//			// right sum
//			for (int k = i + 1; k < ar.length; k++) {
//				rs += ar[k];
//			}
//			
//			if(ls==rs) {
//				return i;
//			}
//		}
//		
//		return -1;
//
//	}

}
