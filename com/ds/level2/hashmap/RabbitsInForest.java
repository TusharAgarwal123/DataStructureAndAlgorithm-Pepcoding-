package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

Given the array answers, return the minimum number of rabbits that could be in the forest.


 */
public class RabbitsInForest {

	public int numRabbits(int[] answers) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x : answers) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int ans = 0;
		for (int key : map.keySet()) {
			int gs = key + 1;
			int reportees = map.get(key);

			int ng = (int) Math.ceil(reportees * 1.0 / gs * 1.0);
			ans += ng * gs;
		}
		return ans;

	}

}
