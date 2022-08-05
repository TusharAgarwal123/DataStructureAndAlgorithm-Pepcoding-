package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//56. Merge Intervals

/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

public class MergeIntervals {

	// using arrow function.
	public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> {
			return a[0] - b[0];
		});

		ArrayList<int[]> st = new ArrayList<>(); // stack

		for (int i = 0; i < intervals.length; i++) {
			if (i == 0) {
				st.add(intervals[i]);
			} else {
				int top[] = st.get(st.size() - 1);
				if (intervals[i][0] > top[1]) {
					st.add(intervals[i]);
				} else {
					top[1] = Math.max(top[1], intervals[i][1]);
				}

			}
		}

		int res[][] = new int[st.size()][2];

		for (int i = 0; i < st.size(); i++) {
			res[i] = st.get(i);
		}

		return res;

	}

	// using pair class.
	public int[][] merge2(int[][] intervals) {

		// int[][] res = new int[intervals.length][
		Pair[] pairs = new Pair[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
		}

		Arrays.sort(pairs);

		Stack<Pair> st = new Stack<>();

		for (int i = 0; i < pairs.length; i++) {
			if (i == 0) {
				st.push(pairs[i]);
			} else {
				Pair top = st.peek();
				if (pairs[i].start > top.end) {
					st.push(pairs[i]);
				} else {
					top.end = Math.max(top.end, pairs[i].end);
				}
			}

		}

		Stack<Pair> resultStack = new Stack<>();

		while (st.size() > 0) {
			resultStack.push(st.pop());
		}

		int[][] res = new int[resultStack.size()][2];

		for (int i = 0; i < res.length; i++) {

			Pair inter = resultStack.pop();
			res[i][0] = inter.start;
			res[i][1] = inter.end;

		}

		return res;
	}

	class Pair implements Comparable<Pair> {
		int start;
		int end;

		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Pair other) {
			if (this.start != other.start) {
				return this.start - other.start;
			} else {
				return this.end - other.end;
			}
		}
	}

}
