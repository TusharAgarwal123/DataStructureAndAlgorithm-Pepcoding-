package com.ds.level2.recursion_backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given an array of n integers.
2. You have to divide these n integers into 2 subsets such that the difference of sum of two subsets 
     is as minimum as possible.
3. If n is even, both set will contain exactly n/2 elements. If  is odd, one set will contain (n-1)/2 and 
    other set will contain (n+1)/2 elements.
3. If it is not possible to divide, then print "-1".
 */

//minimum subset sum difference on leetcode.
public class TugOfWar {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);
	}

	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";

	// on level we will put elements of array and each element will have two choice
	// to come in first set or to
	// come in second set.
	public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		if (vidx == arr.length) {
			if (Math.abs(soset1 - soset2) < mindiff) {
				mindiff = Math.abs(soset1 - soset2);
				ans = set1 + " " + set2;
			}
			return;
		}

		if (set1.size() < (arr.length + 1) / 2) {
			set1.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
			set1.remove(set1.size() - 1);
		}

		if (set2.size() < (arr.length + 1) / 2) {
			set2.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
			set2.remove(set2.size() - 1);
		}
	}

}
