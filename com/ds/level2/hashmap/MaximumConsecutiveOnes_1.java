package com.ds.level2.hashmap;

/*
 * 1. You are given an array(arr) which contains only 0's and 1's.
2. You have to find the maximum number of consecutive 1's in the given array 
if you can flip at most one zero.
 */
public class MaximumConsecutiveOnes_1 {

	public static int solution(int[] arr) {
		// write your code here

		int i = 0;
		int j = -1;

		int cz = 0;

		int ans = 0;

		while (i < arr.length) {
			if (arr[i] == 0) {
				cz++;
			}

			if (cz <= 1) {
				int nLen = i - j;
				ans = Math.max(ans, nLen);
			} else {
				while (true) {
					if (arr[j + 1] == 0) {
						cz--;
						j++;
						break;
					}
					j++;

				}
			}
			i++;
		}

		return ans;
	}

}
