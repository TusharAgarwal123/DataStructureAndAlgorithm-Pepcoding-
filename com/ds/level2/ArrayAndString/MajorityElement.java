package com.ds.level2.ArrayAndString;

//169. Majority Element

/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority
 element always exists in the array.


 */

public class MajorityElement {

	public int majorityElement(int[] nums) {

		int majority = nums[0];
		int c = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == majority) {
				c++;
			} else {
				c--;
			}

			if (c == 0) {
				majority = nums[i];
				c = 1;
			}
		}

		return majority;

	}

}
