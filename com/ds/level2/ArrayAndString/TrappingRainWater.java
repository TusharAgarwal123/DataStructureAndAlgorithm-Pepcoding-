package com.ds.level2.ArrayAndString;

//42. Trapping Rain Water

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
 *  how much water it can trap after raining.
 */

public class TrappingRainWater {

	public int trap(int[] height) {

		int left[] = new int[height.length];

		for (int i = 0; i < height.length; i++) {
			if (i == 0) {
				left[i] = height[i];
			} else {
				left[i] = Math.max(height[i], left[i - 1]);
			}
		}

		int right[] = new int[height.length];

		for (int i = height.length - 1; i >= 0; i--) {
			if (i == height.length - 1) {
				right[i] = height[i];
			} else {
				right[i] = Math.max(height[i], right[i + 1]);
			}
		}

		int totalWater = 0;

		for (int i = 0; i < height.length; i++) {
			totalWater += Math.min(left[i], right[i]) - height[i];
		}

		return totalWater;

		// on each point we are calculating how much water can come on each point.

	}

}
