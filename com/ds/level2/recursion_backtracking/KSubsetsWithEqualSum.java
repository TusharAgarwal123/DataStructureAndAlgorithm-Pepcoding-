package com.ds.level2.recursion_backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given an array of n distinct integers.
2. You have to divide these n integers into k non-empty subsets such that sum of integers of every 
     subset is same.
3. If it is not possible to divide, then print "-1".

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
 */
public class KSubsetsWithEqualSum {

	// on level we are putting the number.
	public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssssf,
			ArrayList<ArrayList<Integer>> ans) {
		// write your code here

		if (vidx == arr.length) {
			if (ssssf == k) {
				boolean allSame = true;
				int val = subsetSum[0];
				for (int i = 1; i < subsetSum.length; i++) {
					if (subsetSum[i] != val) {
						allSame = false;
						break;
					}
				}

				if (allSame) {
					for (ArrayList<Integer> ll : ans) {
						System.out.print(ll + " ");
					}

					System.out.println();
				}
			}

			return;
		}

		for (int j = 0; j < ans.size(); j++) {
			if (ans.get(j).size() > 0) {
				ans.get(j).add(arr[vidx]);
				subsetSum[j] = subsetSum[j] + arr[vidx];
				solution(arr, vidx + 1, n, k, subsetSum, ssssf, ans);
				subsetSum[j] = subsetSum[j] - arr[vidx];
				ans.get(j).remove(ans.get(j).size() - 1);
			} else {
				ans.get(j).add(arr[vidx]);
				subsetSum[j] = arr[vidx];
				solution(arr, vidx + 1, n, k, subsetSum, ssssf + 1, ans);
				subsetSum[j] = 0;
				ans.get(j).remove(ans.get(j).size() - 1);
				break;
			}
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer
		if (k == 1) {
			System.out.print("[");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		// if there are more subsets than no. of elements in array or sum of all
		// elements is not divisible by k
		if (k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr, 0, n, k, subsetSum, 0, ans);
	}

}
