package com.ds.level2.ArrayAndString;

import java.util.Arrays;

/*
 * Given arrival and departure times of all trains that reach a railway station. Find the minimum number
 *  of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure
 time can never be the same for a train but we can have arrival time of one train equal to departure time of 
 the other. At any given instance of time, same platform can not be used for both departure of a train and 
 arrival of another train. In such cases, we need different platforms.


 */

//on gfg.
public class MinimumPlatforms {

	static int findPlatform(int arr[], int dep[], int n) {
		// add your code here

		Arrays.sort(arr);
		Arrays.sort(dep);

		int c = 0; // c is denoting the number of train standing.
		int max = 0;

		int i = 0;
		int j = 0;

		while (i < arr.length && j < dep.length) {
			if (arr[i] <= dep[j]) {
				i++;
				c++;
			} else {
				j++;
				c--;
			}

			max = Math.max(c, max);

		}

		return max;

	}

}
