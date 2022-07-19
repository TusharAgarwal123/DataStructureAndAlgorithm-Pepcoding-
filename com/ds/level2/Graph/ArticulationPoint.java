package com.ds.level2.Graph;

import java.util.ArrayList;

/*
 * Given an undirected graph (not necessarily connected) with V vertices and adjacency list adj.
 * 
 *  You are required to find all the vertices removing which (and edges through it) disconnects the graph into
 *   2 or more components, or in other words, removing which increases the number of connected components.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.
 */
public class ArticulationPoint {

	public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here

		boolean[] vis = new boolean[V];
		int[] dis = new int[V];
		int[] low = new int[V];
		boolean[] aps = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (vis[i] == false) {
				dfs(adj, vis, dis, low, aps, i, -1);
			}
		}

		int count = 0;
		for (boolean ap : aps) {
			if (ap) {
				count++;
			}
		}

		if (count == 0) {
			return new int[] { -1 };
		} else {
			int res[] = new int[count];
			int idx = 0;
			for (int i = 0; i < aps.length; i++) {
				if (aps[i] == true) {
					res[idx] = i;
					idx++;
				}
			}

			return res;
		}

	}

	int time = 0;

	public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dis, int[] low, boolean[] aps, int u,
			int p) {

		vis[u] = true;
		dis[u] = low[u] = ++time;

		int c = 0;
		for (int v : adj.get(u)) {
			if (v == p) {
				// parent
				continue;
			} else if (vis[v]) {
				// visited neighbor (not parent)
				low[u] = Math.min(low[u], dis[v]);
			} else {
				// unvisited neighbors
				c++;
				dfs(adj, vis, dis, low, aps, v, u);
				low[u] = Math.min(low[u], low[v]);

				if (p != -1 && low[v] >= dis[u]) {
					aps[u] = true;
				}
			}
		}

		if (p == -1 && c > 1) {
			aps[u] = true;
		}

	}

}
