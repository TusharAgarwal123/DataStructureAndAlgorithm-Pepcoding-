package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
 */

//on gfg
public class MotherVertex {

	// this is good approach, time complexity is O(v+e).
	public int findMotherVertex2(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here

		int mv = -1;
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				dfs2(i, adj, visited);
				mv = i;
			}

		}

		Arrays.fill(visited, false);
		dfs2(mv, adj, visited);

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				return -1;
			}
		}

		return mv;

	}

	public void dfs2(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {

		if (visited[v] == true) {
			return;
		}

		visited[v] = true;

		for (int vt : adj.get(v)) {
			dfs(vt, adj, visited);
		}

	}

	// this approach is good as it is taking v*(v+e) time.
	Stack<Integer> st = null;

	public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here

		st = new Stack<>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			st = new Stack<>();
			dfs(i, adj, visited);
			if (st.size() == V) {
				return i;
			}
		}

		return -1;

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
