package com.ds.level2.Graph;

import java.util.HashMap;

//leetcode 2316. Count Unreachable Pairs of Nodes in an Undirected Graph.

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

	int parent[];
	int rank[];

	public long countPairs(int n, int[][] edges) {

		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int ed[] : edges) {
			int v1 = ed[0];
			int v2 = ed[1];

			int v1Lead = find(v1);
			int v2Lead = find(v2);

			if (v1Lead != v2Lead) {
				union(v1Lead, v2Lead);
			}
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int pi = find(i);
			map.put(pi, map.getOrDefault(pi, 0) + 1);
		}

		if (map.size() == 1) {
			return 0;
		}

		long c = 0;

		for (int key : map.keySet()) {

			long val = map.get(key);

			long cc = n - val;
			c = c + (val * cc);

		}

		return c / 2;

	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}

	public void union(int v1, int v2) {
		if (rank[v1] < rank[v2]) {
			parent[v1] = v2;
		} else if (rank[v2] < rank[v1]) {
			parent[v2] = v1;
		} else {
			parent[v1] = v2;
			rank[v2]++;
		}
	}

}
