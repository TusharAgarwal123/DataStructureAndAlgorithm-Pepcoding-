package com.ds.level2.ArrayAndString;

//453. Minimum Moves to Equal Array Elements

/*
 * Given an integer array nums of size n, return the minimum number of moves required to make all array 
 * elements equal.

In one move, you can increment n - 1 elements of the array by 1.


 */

public class MinimumMovesToEqualArrayElements {

	public int minMoves(int[] nums) {

		int min = Integer.MAX_VALUE;
		for (int x : nums) {
			min = Math.min(min, x);
		}

		int res = 0;

		for (int x : nums) {
			res += (x - min);
		}

		return res;

	}

}
