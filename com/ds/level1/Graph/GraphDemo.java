package com.ds.level1.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphDemo {

	static class Edge {
		int v1; // vertices 1
		int v2; // vertices 2
		int wt;

		public Edge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v1 = v2;
			this.wt = wt;
		}

	}

	static class Pair implements Comparable<Pair> {
		int wsf;
		String psf;

		Pair(int wsf, String psf) {
			this.wsf = wsf;
			this.psf = psf;
		}

		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	static class Pair2 {
		int vtx;
		String psf;

		Pair2(int vtx, String psf) {
			this.vtx = vtx;
			this.psf = psf;
		}

	}

	static class Pair3 implements Comparable<Pair> {
		int vtx;
		String psf;
		int wsf;

		Pair3(int vtx, String psf, int wsf) {
			this.vtx = vtx;
			this.wsf = wsf;
			this.psf = psf;
		}

		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	static class Pair4 {
		int vtx;
		int level;

		Pair4(int vtx, int level) {
			this.vtx = vtx;
			this.level = level;
		}

	}

	// this is DFS(Depth first search)
	public static boolean hasPath(ArrayList<Edge>[] graph, boolean[] visted, int src, int dest) {

		if (src == dest) {
			return true;
		}

		visted[src] = true;

		for (int i = 0; i < graph[src].size(); i++) {

			Edge edge = graph[src].get(i);
			int nbr = edge.v2;

			if (visted[nbr] == false) {

				boolean pathExists = hasPath(graph, visted, nbr, dest);
				if (pathExists) {
					return true;
				}

			}

		}

		return false;

	}

	public static void printAllPath(ArrayList<Edge>[] graph, boolean[] visted, String ans, int src, int dest) {

		if (src == dest) {
			System.out.println(ans);
			return;
		}

		visted[src] = true;

		for (int i = 0; i < graph[src].size(); i++) {

			Edge edge = graph[src].get(i);
			int nbr = edge.v2;

			if (visted[nbr] == false) {

				printAllPath(graph, visted, ans + nbr, nbr, dest);

			}

		}
		visted[src] = false;

	}

	public static void printAllPathWithWt(ArrayList<Edge>[] graph, boolean[] visted, String ans, int wsf, int src,
			int dest) {

		if (src == dest) {
			System.out.println(ans + "@" + wsf);
			return;
		}

		visted[src] = true;

		for (int i = 0; i < graph[src].size(); i++) {

			Edge edge = graph[src].get(i);
			int nbr = edge.v2;

			if (visted[nbr] == false) {

				printAllPathWithWt(graph, visted, ans + nbr, wsf + edge.wt, nbr, dest);

			}

		}
		visted[src] = false;

	}

	static String spath;
	static Integer spathwt = Integer.MAX_VALUE;
	static String lpath;
	static Integer lpathwt = Integer.MIN_VALUE;
	static String cpath; // ceil path
	static Integer cpathwt = Integer.MAX_VALUE;
	static String fpath; // floor path
	static Integer fpathwt = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();

	// this method is finding the smaller path, larger path, ceil path of criteria,
	// floor path of criteria and kth largest path
	public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k,
			String psf, int wsf) {

		if (src == dest) {

			if (wsf < spathwt) {
				spathwt = wsf;
				spath = psf;
			}

			if (wsf > lpathwt) {
				lpathwt = wsf;
				lpath = psf;
			}

			// ceil
			if (wsf > criteria) {
				if (wsf < cpathwt) {
					cpathwt = wsf;
					cpath = psf;
				}
			}

			// floor
			if (wsf < criteria) {
				if (wsf > fpathwt) {
					fpathwt = wsf;
					fpath = psf;
				}
			}

			pq.add(new Pair(wsf, psf));
			if (pq.size() > k) {
				pq.remove();
			}

			return;
		}

		visited[src] = true;
		for (int i = 0; i < graph[src].size(); i++) {
			Edge edge = graph[src].get(i);
			int nbr = edge.v2;

			if (visited[nbr] == false) {
				multisolver(graph, nbr, dest, visited, criteria, k, psf + nbr, wsf + edge.wt);
			}
		}

		visited[src] = false;

	}

	public static void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] visited,
			ArrayList<ArrayList<Integer>> comps) {

		for (int v = 0; v < graph.length; v++) {
			if (visited[v] == false) {
				ArrayList<Integer> com = new ArrayList<>();
				fillComponents(graph, visited, com, v);
				comps.add(com);
			}

		}

	}

	public static void fillComponents(ArrayList<Edge>[] graph, boolean[] visited, ArrayList<Integer> com, int src) {

		visited[src] = true;
		com.add(src);

		for (int i = 0; i < graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			int nbr = e.v2;

			if (visited[nbr] == false) {
				fillComponents(graph, visited, com, nbr);
			}
		}

	}

	public static boolean isGraphConnected(ArrayList<Edge>[] graph) {

		ArrayList<ArrayList<Integer>> coms = new ArrayList<ArrayList<Integer>>();
		boolean visited[] = new boolean[graph.length];

		getConnectedComponents(graph, visited, coms);

		return coms.size() == 1;

	}

	public static int countIslands(int ar[][], boolean visit[][]) {
		int c = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				if (ar[i][j] == 0 && visit[i][j] == false) {
					work(ar, visit, i, j);
					c++;
				}
			}
		}
		return c;
	}

	public static void work(int ar[][], boolean visit[][], int r, int c) {

		if (r < 0 || r >= ar.length || c < 0 || c >= ar[0].length || ar[r][c] == 1 || visit[r][c] == true) {
			return;
		}

		visit[r][c] = true;

		work(ar, visit, r - 1, c);
		work(ar, visit, r + 1, c);
		work(ar, visit, r, c - 1);
		work(ar, visit, r, c + 1);

	}

	public static int perfectFriend(ArrayList<Edge>[] graph) {

		ArrayList<ArrayList<Integer>> coms = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[graph.length];

		getConnectedComponents(graph, visited, coms);

		int c = 0;
		for (int i = 0; i < coms.size(); i++) {
			for (int j = i + 1; j < coms.size(); j++) {
				int si = coms.get(i).size();
				int sj = coms.get(j).size();
				c += (si * sj);
			}
		}

		return c;

	}

	// src from where we want to start.
	public static void BFS(ArrayList<Edge>[] graph, int src) {

		boolean[] visited = new boolean[graph.length];

		Queue<Pair2> q = new LinkedList<>();

		q.add(new Pair2(src, src + ""));

		while (q.size() > 0) {

			Pair2 rem = q.remove();

			if (visited[rem.vtx] == true) {
				continue;
			}

			visited[rem.vtx] = true;
			System.out.println(rem.vtx + "@" + rem.psf);

			for (int i = 0; i < graph[rem.vtx].size(); i++) {
				Edge e = graph[rem.vtx].get(i);
				if (visited[e.v2] == false) {
					q.add(new Pair2(e.v2, rem.psf + e.v2));
				}
			}

		}

	}

	// for Cyclic graph, any one components of graph should be cyclic.
	public static boolean isGraphCyclic(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {

			if (visited[i] == false) {
				boolean flag = isComponentCyclic(graph, visited, i);
				if (flag == true) {
					return true;

				}
			}

		}

		return false;
	}

	public static boolean isComponentCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {

		Queue<Pair2> q = new LinkedList<>();
		q.add(new Pair2(src, src + ""));
		while (q.size() > 0) {
			Pair2 rem = q.remove();

			if (visited[rem.vtx] == true) {
				return true;
			}

			visited[rem.vtx] = true;

			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					q.add(new Pair2(e.v2, rem.psf + e.v2));
				}
			}
		}

		return false;

	}

	public static void spreadOfInfection(ArrayList<Edge>[] graph, int src, int t) {

		boolean[] visited = new boolean[graph.length];
		Queue<Pair4> q = new LinkedList<>();
		q.add(new Pair4(src, 1)); // on day one source will be infected.

		int c = 0;
		while (q.size() > 0) {
			Pair4 rem = q.remove();

			if (visited[rem.vtx] == true) {
				continue;
			}

			visited[rem.vtx] = true;

			if (rem.level > t) {
				break;
			}

			c++;
			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					q.add(new Pair4(e.v2, rem.level + 1));
				}
			}
		}

		System.out.println(c);

	}

	// Dijkstra Algorithm.(only works for positive weight).
	// Dijkstra is same as Breadth First Traversal but in this we use PriorityQueue.
	public static void shortestPathInWeights(ArrayList<Edge>[] graph, int src) {

		boolean[] visited = new boolean[graph.length];
		PriorityQueue<Pair3> q = new PriorityQueue<>();
		q.add(new Pair3(src, src + "", 0));

		while (q.size() > 0) {
			Pair3 rem = q.remove();
			if (visited[rem.vtx] == true) {
				continue;
			}

			visited[rem.vtx] = true;
			System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);
			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					q.add(new Pair3(e.v2, rem.psf + e.v2, rem.wsf + e.wt));
				}
			}

		}

	}

	// for bipartite, all components of graph must be bipartite.
	public static boolean isGraphBipartite(ArrayList<Edge>[] graph) {
		Integer[] visited = new Integer[graph.length];
		for (int i = 0; i < graph.length; i++) {

			if (visited[i] == null) {
				boolean flag = isComponentBipartite(graph, visited, i);
				if (flag == false) {
					return false;

				}
			}

		}

		return true;
	}

	public static boolean isComponentBipartite(ArrayList<Edge>[] graph, Integer[] visited, int src) {

		Queue<Pair4> q = new LinkedList<>();
		q.add(new Pair4(src, 1));
		while (q.size() > 0) {
			Pair4 rem = q.remove();

			if (visited[rem.vtx] != null) {
				if (visited[rem.vtx] != rem.level % 2) {
					return false;
				}
			}

			// null for unvisited
			// 1 for visited and on odd level
			// 0 for visited and on even level
			visited[rem.vtx] = rem.level % 2;

			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == null) {
					q.add(new Pair4(e.v2, rem.level + 1));
				}
			}
		}

		return true;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());

		int criteria = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		// write your code here

		boolean[] visited = new boolean[vtces];

		boolean ans = hasPath(graph, visited, src, dest);

		System.out.println(ans);

		printAllPath(graph, visited, src + "", src, dest);

		multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

		System.out.println("Smallest Path = " + spath + "@" + spathwt);
		System.out.println("Largest Path = " + lpath + "@" + lpathwt);
		System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
		System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
		System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		getConnectedComponents(graph, visited, comps);

		System.out.println(comps);

	}

}
