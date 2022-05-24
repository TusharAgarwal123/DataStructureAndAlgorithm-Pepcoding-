package com.ds.leetcode.may;

import java.util.ArrayList;
import java.util.PriorityQueue;

//743. Network Delay Time
public class NetworkDelayTime {

	static class Edge {

		int v1;
		int v2;
		int wt;

		Edge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}

		public String toString() {
			return v1 + " " + v2 + " " + wt;
		}
	}

	static class Pair implements Comparable<Pair> {
		int vtx;
		int wsf;

		Pair(int vtx, int wsf) {
			this.vtx = vtx;
			this.wsf = wsf;
		}

		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}

	}

	public int networkDelayTime(int[][] times, int N, int K) {

		ArrayList<Edge>[] graph = buildGraph(times, N);

		PriorityQueue<Pair> q = new PriorityQueue<>();

		q.add(new Pair(K - 1, 0));

		boolean visited[] = new boolean[graph.length];
		int res = Integer.MIN_VALUE;
		int c = 0;

		while (q.size() > 0) {

			Pair rem = q.remove();

			if (visited[rem.vtx]) {
				continue;
			}

			visited[rem.vtx] = true;

			c++; // counting vertices that i have visited.
			res = Math.max(res, rem.wsf);

			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					q.add(new Pair(e.v2, rem.wsf + e.wt));
				}
			}
		}

		if (res == Integer.MIN_VALUE) {
			return -1;
		}

		if (c != N) { // if any vertices remain unvisited
			return -1;
		}

		// for(boolean flag:visited){ //if any vertices remain unvisited
		// if(flag==false){
		// return -1;
		// }
		// }

		return res;
	}

	public ArrayList<Edge>[] buildGraph(int ar[][], int n) {

		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < ar.length; i++) {
			int u = ar[i][0];
			int v = ar[i][1];
			int w = ar[i][2];
			graph[u - 1].add(new Edge(u - 1, v - 1, w));
		}

		return graph;

	}

}
