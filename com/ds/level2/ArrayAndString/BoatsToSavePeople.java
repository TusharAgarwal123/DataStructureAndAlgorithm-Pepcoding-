package com.ds.level2.ArrayAndString;

import java.util.Arrays;

//881. Boats to Save People

/*
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of
 *  boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the
 *   same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.


 */

//just applied the two pointer algorithm.
public class BoatsToSavePeople {

	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int l = 0;
		int r = people.length - 1;

		int ans = 0;

		while (l < r) {

			int val = people[l] + people[r];

			if (val > limit) {
				ans++;
				r--;
			} else {
				ans++;
				l++;
				r--;
			}

		}

		if (l == r) {
			ans += 1;
		}

		return ans;

	}

}
