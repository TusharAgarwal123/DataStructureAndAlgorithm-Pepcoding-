package com.ds.level2.Graph;

import java.util.ArrayList;

/*
 * Eulerian Path is a path in a graph that visits every edge exactly once. Eulerian Circuit is an Eulerian
 *  Path that starts and ends on the same vertex. Given the number of vertices V and adjacency list adj
 *   denoting the graph. Your task is to find that there exists the Euler circuit or not

Note that: Given graph is connected.

 */

public class EulerCircuitInAnUndirectedGraph {

	public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		int c = 0;
		for (int v = 0; v < V; v++) {
			if (adj.get(v).size() % 2 == 1) {
				c++;
			}
		}

		return c == 0;

	}

}
