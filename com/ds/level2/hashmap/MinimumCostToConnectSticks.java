package com.ds.level2.hashmap;

import java.util.PriorityQueue;

/*
 * You have some number of sticks with positive integer lengths. These lengths are given
 *  as an array sticks, where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y.
 You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.
 */
public class MinimumCostToConnectSticks {

	public static int connectSticks(int[] sticks) {

		// Code Here

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int x : sticks) {
			pq.add(x);
		}

		int cost = 0;

		while (pq.size() > 1) {
			int x1 = pq.remove();
			int x2 = pq.remove();

			int sum = x1 + x2;
			cost += sum;

			pq.add(sum);
		}

		return cost;

	}

}
