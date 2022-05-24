package com.ds.leetcode.may;

import java.util.ArrayList;
import java.util.List;

//1192. Critical Connections in a Network
public class CriticalConnectionsInANetwork {

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		ArrayList<ArrayList<Integer>> graph = createGraph(n, connections);

		List<List<Integer>> ans = new ArrayList();

		int[] dis = new int[n];
		int[] minDis = new int[n];

		int[] timer = new int[] { 1 };

		dfs(0, -1, graph, dis, minDis, timer, ans);

		return ans;
	}

	private ArrayList<ArrayList<Integer>> createGraph(int n, List<List<Integer>> edges) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList();

		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList());

		for (List<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		return adjList;
	}

	private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, int[] dis, int[] minDis, int[] timer,
			List<List<Integer>> ans) {

		minDis[node] = dis[node] = timer[0]++;

		for (int adj : adjList.get(node)) {

			if (adj == parent)
				continue;

			if (dis[adj] == 0)
				dfs(adj, node, adjList, dis, minDis, timer, ans);

			minDis[node] = Math.min(minDis[node], minDis[adj]);
		}

		if (parent != -1 && minDis[node] > dis[parent]) {
			ans.add(new ArrayList() {
				{
					add(parent);
					add(node);
				}
			});
		}

	}

}
