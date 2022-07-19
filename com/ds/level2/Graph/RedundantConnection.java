package com.ds.level2.Graph;

//leetcode 684. Redundant Connection

/*
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. 
 The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is 
 an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple
 answers, return the answer that occurs last in the input.


 */

public class RedundantConnection {

	int parent[];
	int rank[];

	// O(Edges)
	public int[] findRedundantConnection(int[][] edges) {

		parent = new int[edges.length + 1];
		rank = new int[edges.length + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int ed[] : edges) {

			int x = ed[0];
			int y = ed[1];

			int xLead = find(x);
			int yLead = find(y);

			if (xLead != yLead) {
				union(xLead, yLead);
			} else { // means there is a cycle.
				return ed;
				// return new int[]{x,y};
			}

		}

		return new int[] {};

	}

	// O(1)
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

	// O(1)
	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}

}
