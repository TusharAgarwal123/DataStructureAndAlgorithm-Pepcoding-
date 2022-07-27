package com.ds.level2.ArrayAndString;

import java.util.Arrays;

//462. Minimum Moves to Equal Array Elements II

/*
 * Given an integer array nums of size n, return the minimum number of moves required to make all array 
 * elements equal.
*  In one move, you can increment or decrement an element of the array by 1.



 */

public class MinimumMovesToEqualArrayElementsII {

	public int minMoves2(int[] nums) {

//        int n=nums.length;

//        Arrays.sort(nums);

//        int median=n%2==0 ? (nums[n/2]+nums[n/2-1])/2 : nums[n/2];

//        int ans=0;

//        for(int x:nums){
//            ans+=Math.abs(x-median);
//        }

//        return ans;

		int n = nums.length;

		Arrays.sort(nums);

		int i = 0;
		int j = n - 1;

		int ans = 0;

		while (i < j) {
			ans += (nums[j] - nums[i]);
			i++;
			j--;
		}

		return ans;

		// both appraoch takes O(nlogn) time

	}

}
