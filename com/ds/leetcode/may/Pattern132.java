package com.ds.leetcode.may;

import java.util.Stack;

//leetcode 456. 132 Pattern
public class Pattern132 {

	public boolean find132pattern(int[] nums) {

		int min[] = new int[nums.length];

		int n = nums.length;

		min[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			min[i] = Math.min(nums[i], min[i - 1]);
		}

		Stack<Integer> st = new Stack<>();

		boolean found = false;

		for (int j = n - 1; j >= 0; j--) {

			while (st.size() > 0 && st.peek() <= min[j]) {
				st.pop();
			}

			if (st.size() > 0 && st.peek() < nums[j]) {
				found = true;
				break;
			}

			st.push(nums[j]);

		}

		return found;

	}

}
