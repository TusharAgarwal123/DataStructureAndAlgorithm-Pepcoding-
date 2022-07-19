package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of 
 * all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
 
 */

public class DistanceFromTheSourceBellmanFordAlgorithm {

	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {
		// Write your code here

		int res[] = new int[V];

		Arrays.fill(res, 100000000);
		res[S] = 0;

		for (int i = 1; i <= V - 1; i++) {
			for (ArrayList<Integer> edge : adj) {
				int u = edge.get(0);
				int v = edge.get(1);
				int p = edge.get(2);

				if (res[u] == 100000000) {
					continue;
				} else if (res[v] == 100000000) {
					res[v] = res[u] + p;
				} else {
					res[v] = Math.min(res[v], res[u] + p);
				}
			}
		}

		return res;

	}

}
