package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Kahn's Algorithm use to find the topological sorting and detect the cycle in directed graph. 

public class KahnsAlgorithm {

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

		int tsort[] = new int[V];

		int in[] = new int[V];

		for (int v = 0; v < V; v++) {
			for (int n : adj.get(v)) {
				in[n]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int v = 0; v < V; v++) {
			if (in[v] == 0) { // adding only those which don't have any dependency.
				q.add(v);
			}
		}

		int idx = 0;

		while (q.size() > 0) {
			int v = q.remove();
			tsort[idx] = v;
			idx++;

			for (int n : adj.get(v)) {
				in[n]--;

				if (in[n] == 0) {
					q.add(n);
				}
			}
		}

		if (idx < V) {
			return new int[] {};
		}

		return tsort;

	}

}
