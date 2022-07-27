package com.ds.level2.ArrayAndString;

//849. Maximize Distance to Closest Person

/*
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the
 *  ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.


 */

public class MaximizeDistanceToClosestPerson {

	public int maxDistToClosest(int[] seats) {

		int res = 0;
		int n = seats.length;
		int last = -1;

		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				res = last < 0 ? i : Math.max(res, (i - last) / 2);
				last = i;
			}
		}

		res = Math.max(res, n - last - 1);
		return res;

	}

}
