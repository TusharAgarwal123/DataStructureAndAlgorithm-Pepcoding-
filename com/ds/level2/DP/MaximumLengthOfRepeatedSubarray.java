package com.ds.level2.DP;

//718. Maximum Length of Repeated Subarray

/*
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both
 *  arrays.

 


 */

public class MaximumLengthOfRepeatedSubarray {

	public int findLength(int[] nums1, int[] nums2) {

		int[][] dp = new int[nums1.length + 1][nums2.length + 1];

		int ans = 0;

		for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		return ans;

	}

}
