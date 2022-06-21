package com.ds.level1.heap;

import java.util.PriorityQueue;

//leetcode 1642. Furthest Building You Can Reach
public class FurthestBuildingYouCanReach {

	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// we will use ladder for largest jump and bricks for small jumps.

		for (int i = 0; i < heights.length - 1; i++) {
			int diff = heights[i + 1] - heights[i];

			if (diff > 0) {
				pq.add(diff);
			}

			if (pq.size() > ladders) {
				bricks = bricks - pq.remove();
			}

			if (bricks < 0) {
				return i;
			}
		}

		return heights.length - 1;

	}

}
