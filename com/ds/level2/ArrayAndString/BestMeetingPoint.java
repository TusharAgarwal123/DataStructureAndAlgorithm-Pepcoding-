package com.ds.level2.ArrayAndString;

import java.util.ArrayList;

//Best Meeting Point on pepcoding.

/*
 * 1. A group of two or more people wants to meet and minimize the total travel distance.
2. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
3. Return min distance where distance is calculated using 'Manhattan Distance', 
where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 */

public class BestMeetingPoint {

	public static int minTotalDistance(int[][] grid) {
		// Write your code here

		ArrayList<Integer> xcord = new ArrayList<>();
		ArrayList<Integer> ycord = new ArrayList<>();

		// for row coordinates.

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					xcord.add(r);
				}
			}
		}

		// for col coordinates.

		for (int c = 0; c < grid[0].length; c++) {
			for (int r = 0; r < grid.length; r++) {
				if (grid[r][c] == 1) {
					ycord.add(c);
				}
			}
		}

		int x = xcord.get(xcord.size() / 2);
		int y = ycord.get(ycord.size() / 2);

		// calculate distance

		int dist = 0;

		for (int i = 0; i < xcord.size(); i++) {
			dist += Math.abs(xcord.get(i) - x) + Math.abs(ycord.get(i) - y);
		}

		return dist;

	}

}
