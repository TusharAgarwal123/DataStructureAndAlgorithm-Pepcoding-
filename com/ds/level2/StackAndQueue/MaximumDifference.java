package com.ds.level2.StackAndQueue;

import java.util.Stack;

//Maximum Difference on gfg

/*
 * Given array A[] of integers, the task is to complete the function findMaxDiff which finds the maximum absolute
 *  difference between nearest left and right smaller element of every element in array.If the element is the
 *   leftmost element, nearest smaller element on left side is considered as 0. Similarly if the element is
 *    the rightmost elements, smaller element on right side is considered as 0.
 */

public class MaximumDifference {

	int findMaxDiff(int ar[], int n) {
		// Your code here

		int[] left = nearestLeft(ar);
		int[] right = nearestRight(ar);

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int diff = Math.abs(left[i] - right[i]);
			max = Math.max(max, diff);
		}

		return max;

	}

	public int[] nearestLeft(int[] ar) {

		Stack<Integer> st = new Stack<>();

		int[] ans = new int[ar.length];

		ans[0] = 0;
		st.push(0);

		for (int i = 1; i < ar.length; i++) {

			while (st.size() > 0 && ar[st.peek()] >= ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = 0;
			} else {
				ans[i] = ar[st.peek()];
			}

			st.push(i);

		}

		return ans;

	}

	public int[] nearestRight(int[] ar) {

		Stack<Integer> st = new Stack<>();

		int[] ans = new int[ar.length];

		ans[ans.length - 1] = 0;
		st.push(ar.length - 1);

		for (int i = ar.length - 2; i >= 0; i--) {

			while (st.size() > 0 && ar[st.peek()] >= ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = 0;
			} else {
				ans[i] = ar[st.peek()];
			}

			st.push(i);

		}

		return ans;

	}

}
