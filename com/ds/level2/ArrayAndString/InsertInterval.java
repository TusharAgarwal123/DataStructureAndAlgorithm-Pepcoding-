package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;

//57. Insert Interval

/*
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
 * You are also given an interval newInterval = [start, end] that represents the start and end of another
 *  interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
 intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
 */

public class InsertInterval {

	// optimized approach. O(n) time
	public int[][] insert1(int[][] intervals, int[] newInterval) {

		ArrayList<int[]> res = new ArrayList<>();

		int i = 0;

		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			res.add(intervals[i]);
			i++;
		}

		int[] interval = newInterval;

		while (i < intervals.length && intervals[i][0] <= interval[1]) {
			interval[0] = Math.min(intervals[i][0], interval[0]);
			interval[1] = Math.max(intervals[i][1], interval[1]);
			i++;
		}

		res.add(interval);

		while (i < intervals.length) {
			res.add(intervals[i]);
			i++;
		}

		return res.toArray(new int[res.size()][2]);

	}

	// O(nlogn)
	public int[][] insert2(int[][] inter, int[] newInterval) {

		int intervals[][] = new int[inter.length + 1][2];
		for (int i = 0; i < inter.length; i++) {
			intervals[i] = inter[i];
		}

		intervals[intervals.length - 1] = newInterval;

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

//	         int res[][]=new int[st.size()][2];

//	         for(int i=0;i<st.size();i++){
//	             res[i]=st.get(i);
//	         }

//	         return res;

		return st.toArray(new int[st.size()][2]);

	}

}
