package com.ds.level2.ArrayAndString;

import java.util.Arrays;
import java.util.List;

//919 · Meeting Rooms II on lintcode.

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.)
 */

public class MeetingRoomsII {

	public class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public int minMeetingRooms(List<Interval> intervals) {
		// Write your code here

		int[] start = new int[intervals.size()];
		int[] end = new int[intervals.size()];

		int i = 0;

		for (Interval inv : intervals) {
			start[i] = inv.start;
			end[i] = inv.end;
			i++;
		}

		Arrays.sort(start);
		Arrays.sort(end);

		i = 0;
		int j = 0;
		int count = 0;
		int reqd = 0;

		while (i < start.length && j < end.length) {
			if (start[i] < end[j]) {
				i++;
				count++;
			} else {
				j++;
				count--;
			}

			reqd = Math.max(count, reqd);
		}

		return reqd;
	}

}
