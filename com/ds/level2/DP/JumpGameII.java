package com.ds.level2.DP;

//45. Jump Game II

/*
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
 */

public class JumpGameII {

	// this is greedy approach we can also apply dp approach here.
	public int jump(int[] nums) {

		if (nums.length <= 1) {
			return 0;
		}

		int ans = 0;
		int curr = 0;

		while (curr < nums.length) {

			if (curr + nums[curr] >= nums.length - 1) {
				ans++;
				break;
			}

			int inter = curr;
			for (int j = curr + 1; j <= curr + nums[curr] && j < nums.length; j++) {
				if (j + nums[j] > inter + nums[inter]) {
					inter = j;
				}
			}

			curr = inter;
			ans++;

		}

		return ans;

	}

}
