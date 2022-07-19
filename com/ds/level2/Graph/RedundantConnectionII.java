package com.ds.level2.Graph;

import java.util.Arrays;

//leetcode 685. Redundant Connection II

/*
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which
 *  all other nodes are descendants of this node, plus every node has exactly one parent, except for the root 
 *  node which has no parents.

The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1
 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n,
  and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents
 a directed edge connecting nodes ui and vi, where ui is a parent of child vi.

Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are
 multiple answers, return the answer that occurs last in the given 2D-array.
 */

public class RedundantConnectionII {

	int dsu[];

	public int[] findRedundantDirectedConnection(int[][] edges) {

		int parent[] = new int[edges.length + 1];

		Arrays.fill(parent, -1);

		boolean twopf = false; // two parent.

		int e1[] = null;
		int e2[] = null;

		for (int i = 0; i < edges.length; i++) {

			int from = edges[i][0];
			int to = edges[i][1];

			if (parent[to] == -1) {
				parent[to] = from;
			} else {
				twopf = true;
				e2 = edges[i];
				e1 = new int[] { parent[to], to };
				break;
			}

		}

		dsu = new int[edges.length + 1];

		for (int i = 0; i <= edges.length; i++) {
			dsu[i] = i;
		}

		// if any node don't have 2 parent then find the edge creating the cycle.
		if (twopf == false) {

			int res[] = null;
			for (int i = 0; i < edges.length; i++) {
				int from = edges[i][0];
				int to = edges[i][1];

				int fromLead = find(from);
				if (to == fromLead) {
					res = edges[i];
					break;
				} else {
					dsu[to] = fromLead;
				}
			}

			return res;

		} else {
			// means 2 parent are ther.
			// check for cylce, if cycle is not present then e2 is answer.

			boolean noCycle = true;
			for (int i = 0; i < edges.length; i++) {

				if (edges[i] == e2) {
					continue;
				}

				int from = edges[i][0];
				int to = edges[i][1];

				int fromLead = find(from);
				if (to == fromLead) {
					// cycle
					noCycle = false;
					break;
				} else {
					dsu[to] = fromLead;
				}
			}

			if (noCycle) {
				return e2;
			}

			return e1;

		}

	}

	public int find(int x) {
		if (dsu[x] == x) {
			return x;
		} else {
			dsu[x] = find(dsu[x]);
			return dsu[x];
		}
	}

}
