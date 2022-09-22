package com.ds.level2.StackAndQueue;

import java.util.Stack;

//84. Largest Rectangle in Histogram

/*
 * Given an array of integers heights representing the histogram's bar height where the width of each bar
 *  is 1, return the area of the largest rectangle in the histogram.


 */

class LargestRectangleInHistogram {

	public int largestRectangleArea(int ar[]) {
		int left[] = getSmallestIndeOnLeft(ar);
		int right[] = getSmallestIndeOnRight(ar);

		int area[] = new int[ar.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ar.length; i++) {

			int width = right[i] - left[i] - 1;
			area[i] = width * ar[i];
			if (area[i] > max) {
				max = area[i];
			}

		}

		return max;
	}

	// gives the next samller indexes on left.
	public static int[] getSmallestIndeOnLeft(int ar[]) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[ar.length];

		ans[0] = -1;
		st.push(0);
		for (int i = 1; i < ar.length; i++) {

			while (st.size() > 0 && ar[st.peek()] >= ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;

	}

	// gives the next smaller indexes on right.
	public static int[] getSmallestIndeOnRight(int ar[]) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[ar.length];

		ans[ar.length - 1] = ar.length;
		st.push(ar.length - 1);
		for (int i = ar.length - 2; i >= 0; i--) {

			while (st.size() > 0 && ar[st.peek()] >= ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = ar.length;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;

	}

}
