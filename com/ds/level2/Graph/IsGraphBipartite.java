package com.ds.level2.Graph;

import java.util.LinkedList;
import java.util.Queue;

//785. Is Graph Bipartite
public class IsGraphBipartite {

	static class Pair {
		int v;
		int color;

		Pair(int v, int c) {
			this.v = v;
			this.color = c;
		}
	}

	public boolean isBipartite(int[][] graph) {

		int visited[] = new int[graph.length];

		for (int v = 0; v < graph.length; v++) {
			if (visited[v] == 0) {
				// boolean isBip=isComponentBipartite(graph,visited,v);
				boolean isBip = isComponentBipartiteUsingDFS(graph, visited, v, 1);
				if (isBip == false) {
					return false;
				}
			}
		}

		return true;

	}

	// using DFS complexity is O(v+e)
	public boolean isComponentBipartiteUsingDFS(int[][] graph, int visited[], int v, int color) {

		visited[v] = color;

		for (int nbr : graph[v]) {
			if (visited[nbr] == 0) {
				boolean isBip = isComponentBipartiteUsingDFS(graph, visited, nbr, color * -1);
				if (isBip == false) {
					return false;
				}
			} else {
				int oc = visited[nbr];
				int nc = color * -1;

				if (oc != nc) {
					return false;
				}
			}
		}

		return true;

	}

	// using bfs complexity is O(v+e)
	public boolean isComponentBipartite(int[][] graph, int visited[], int v) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(v, 1));

		while (q.size() > 0) {

			Pair rem = q.remove();

			// if already visited.
			if (visited[rem.v] != 0) {

				int oc = visited[rem.v];
				int nc = rem.color;

				if (oc == nc) {
					continue;
				} else {
					// if have different color.
					return false;
				}

			}

			visited[rem.v] = rem.color;
			for (int nbr : graph[rem.v]) {
				if (visited[nbr] == 0) {
					q.add(new Pair(nbr, rem.color * -1));
				}
			}

		}

		return true;

	}

}
