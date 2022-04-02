package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given four arrays(A1,A2,A3,A4) of integers. All arrays are of same length(N).
2. You have to find the count of all unique quadruplets(a,b,c,d) such that - 
   A1[a] + A2[b] + A3[c] + A4[d] = 0.
 */
public class QuadrupletSum2 {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// write your code here

		int n = A.length;
		if (n == 0) {
			return 0;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map.put(A[i] + B[j], map.getOrDefault((A[i] + B[j]), 0) + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += map.getOrDefault(-1 * (C[i] + D[j]), 0);
			}
		}

		return ans;
	}

}
