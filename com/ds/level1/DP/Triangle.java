package com.ds.level1.DP;

import java.util.ArrayList;
import java.util.List;

//leetcode 120. Triangle

/*
 * Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally,
 if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle.size() == 0 || triangle.get(0).size() == 0) {
			return 0;
		}

		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < triangle.size(); i++) {
			dp.add(new ArrayList<>());
		}

		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {

				if (i == triangle.size() - 1) {
					dp.get(i).add(triangle.get(i).get(j));
				} else {
					int val = Math.min(dp.get(i + 1).get(j), dp.get(i + 1).get(j + 1));
					dp.get(i).add(val + triangle.get(i).get(j));
				}

			}
		}

		// System.out.println(dp);
		// System.out.println(dp.size());

		return dp.get(0).get(0);

	}

}
