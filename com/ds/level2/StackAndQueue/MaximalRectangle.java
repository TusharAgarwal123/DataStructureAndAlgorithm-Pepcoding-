package com.ds.level2.StackAndQueue;

import java.util.Stack;

//85. Maximal Rectangle

/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only
 *  1's and return its area.


 */

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {

		int[] ht = new int[matrix[0].length];

		for (int j = 0; j < matrix[0].length; j++) {
			ht[j] = matrix[0][j] == '0' ? 0 : 1;
		}

		int res = largestRectangleArea(ht);

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				ht[j] = matrix[i][j] == '0' ? 0 : ht[j] + 1;
			}

			int res2 = largestRectangleArea(ht);
			res = Math.max(res, res2);
		}

		return res;

	}

	public int largestRectangleArea(int ar[]) {
		int left[] = getSmallestIndeOnLeft(ar);
		int right[] = getSmallestIndeOnRight(ar);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ar.length; i++) {

			int width = right[i] - left[i] - 1;
			int area = width * ar[i];
			if (area > max) {
				max = area;
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
