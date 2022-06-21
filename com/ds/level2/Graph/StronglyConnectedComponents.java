package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.Stack;

//Strongly Connected Components (Kosaraju's Algo)  on GFG.

public class StronglyConnectedComponents {

	Stack<Integer> st = null;

	public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here

		st = new Stack<>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				dfs(i, adj, visited);
			}
		}

		// transpose
		ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			newAdj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < V; i++) {
			ArrayList<Integer> vx = adj.get(i);
			for (int x : vx) {
				newAdj.get(x).add(i);
			}
		}

		int c = 0;

		visited = new boolean[V];

		while (st.size() > 0) {

			int vtx = st.pop();

			if (visited[vtx] == false) {
				dfs2(vtx, newAdj, visited);
				c++;
			}

		}

		return c;

	}

	public void dfs2(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {

		if (visited[v] == true) {
			return;
		}

		visited[v] = true;

		for (int vt : adj.get(v)) {
			dfs2(vt, adj, visited);
		}

	}

	public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {

		if (visited[v] == true) {
			return;
		}

		visited[v] = true;

		for (int vt : adj.get(v)) {
			dfs(vt, adj, visited);
		}

		st.push(v);

	}

}
