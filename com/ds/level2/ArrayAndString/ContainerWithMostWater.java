package com.ds.level2.ArrayAndString;

//11. Container With Most Water

/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the 
 * two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {

		int i = 0;
		int j = height.length - 1;

		int maxArea = Integer.MIN_VALUE;

		while (i < j) {

			int width = j - i;
			int ht = Math.min(height[i], height[j]);
			maxArea = Math.max(maxArea, (width * ht));

			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}

		}

		return maxArea;

	}

}
