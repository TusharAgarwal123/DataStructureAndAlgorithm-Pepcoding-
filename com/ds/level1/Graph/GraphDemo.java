package com.ds.level1.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

	static class Pair5 implements Comparable<Pair5> {
		int vtx;
		int parent;
		int wt;

		Pair5(int src, int nbr, int wt) {
			this.vtx = src;
			this.parent = nbr;
			this.wt = wt;
		}

		public int compareTo(Pair5 o) {
			return this.wt - o.wt;
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

	// we have to print all hamiltonian paths and cycle present in graph.
	// pass 1 in csf.
	// pass giving src in src and osrc.
	// in psf pass src+"" initially.
	public static void printHamiltonianPathAndCycle(ArrayList<Edge>[] graph, boolean visited[], int csf, int src,
			String psf, int osrc) {

		if (csf == graph.length) {

			System.out.print(psf);
			boolean isHCycle = false;
			for (Edge e : graph[osrc]) { // checking if Hamiltonian path is cycle or not.
				if (e.v2 == src) {
					isHCycle = true;
					break;
				}
			}

			if (isHCycle) {
				System.out.println("*");
			} else {
				System.out.println(".");
			}
			return;

		}

		visited[src] = true;
		for (Edge e : graph[src]) {
			if (visited[e.v2] == false) {
				printHamiltonianPathAndCycle(graph, visited, csf + 1, e.v2, psf + e.v2, osrc);
			}
		}

		visited[src] = false;

	}

	// for itrative DFS, code is same as BFS but we will use Stack in this.
	// in itrative DFS euler will traverse in reverse, means it is reverse preorder.
	public static void iterativeDFS(ArrayList<Edge>[] graph, int src) {

		boolean[] visited = new boolean[graph.length];
		Stack<Pair2> st = new Stack<>();
		st.push(new Pair2(src, src + ""));

		while (st.size() > 0) {

			Pair2 rem = st.pop();
			if (visited[rem.vtx] == true) {
				continue;
			}

			visited[rem.vtx] = true;
			System.out.println(rem.vtx + "@" + rem.psf);
			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					st.push(new Pair2(e.v2, rem.psf + e.v2));
				}
			}

		}

	}

	// this is nothing but Prim's algorithm.
	public static void minimumWireRequiredToConnectAllPcs(ArrayList<Edge>[] graph) {

		boolean visited[] = new boolean[graph.length];
		PriorityQueue<Pair5> q = new PriorityQueue<>();
		q.add(new Pair5(0, -1, 0));

		while (q.size() > 0) {
			Pair5 rem = q.remove();
			if (visited[rem.vtx] == true) {
				continue;
			}

			visited[rem.vtx] = true;

			if (rem.vtx != 0) {
				System.out.println("[" + rem.vtx + "-" + rem.parent + "@" + rem.wt + "]");
			}

			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					q.add(new Pair5(e.v2, rem.vtx, e.wt));
				}
			}

		}
	}

	// in topological sort graph will be directed acyclic.
	public static void topologicalSort(ArrayList<Edge>[] graph) {
		boolean visited[] = new boolean[graph.length];
		Stack<Integer> st = new Stack<>();

		// graph can be disconnected.
		for (int i = 0; i < graph.length; i++) {

			if (visited[i] == false) {
				topologicalSort_helper(graph, visited, i, st);
			}

		}

		while (st.size() > 0) {
			System.out.println(st.pop());
		}
	}

	public static void topologicalSort_helper(ArrayList<Edge>[] graph, boolean[] visited, int src, Stack<Integer> st) {

		visited[src] = true;

		for (Edge e : graph[src]) {
			if (visited[e.v2] == false) {
				topologicalSort_helper(graph, visited, e.v2, st);
			}
		}

		st.push(src);

	}

	// leetcode 1584. Min Cost to Connect All Points.
	public int minCostConnectPoints(int[][] points) {

		ArrayList<Edge>[] graph = new ArrayList[points.length];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		// calculating weight of all the edges.
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					int x1 = points[i][0];
					int x2 = points[j][0];
					int y1 = points[i][1];
					int y2 = points[j][1];

					int val = Math.abs(x1 - x2) + Math.abs(y1 - y2);

					graph[i].add(new Edge(i, j, val));
				}

			}
		}

		int count = 0;

		// applying prim's algorithm.
		boolean visited[] = new boolean[graph.length];
		PriorityQueue<Pair5> q = new PriorityQueue<>();

		q.add(new Pair5(0, -1, 0));

		while (q.size() > 0) {
			Pair5 rem = q.remove();
			if (visited[rem.vtx]) {
				continue;
			}

			visited[rem.vtx] = true;

			count += rem.wt;
			for (Edge e : graph[rem.vtx]) {
				if (visited[e.v2] == false) {
					q.add(new Pair5(e.v2, rem.vtx, e.wt));
				}
			}

		}

		return count;

	}

	static class Node {

		String key;
		double wt;

		Node(String key, double wt) {
			this.key = key;
			this.wt = wt;
		}
	}

	// 399. Evaluate Division
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		HashMap<String, List<Node>> graph = buildGraph(equations, values);

		double[] result = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);
		}

		return result;

	}

	public double dfs(String src, String dest, HashSet<String> visited, HashMap<String, List<Node>> graph) {

		// if any vertices not present.
		if (!(graph.containsKey(src) && graph.containsKey(dest))) {
			return -1.0;
		}

		if (src.equals(dest)) {
			return 1.0;
		}

		visited.add(src);
		for (Node ng : graph.get(src)) {
			if (!visited.contains(ng.key)) {
				double ans = dfs(ng.key, dest, visited, graph);
				if (ans != -1.0) {
					return ans * ng.wt;
				}
			}
		}

		return -1.0;

	}

	public HashMap<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {

		HashMap<String, List<Node>> graph = new HashMap<>();

		for (int i = 0; i < values.length; i++) {

			String src = equations.get(i).get(0);
			String dest = equations.get(i).get(1);

			graph.putIfAbsent(src, new ArrayList<>());
			graph.putIfAbsent(dest, new ArrayList<>());

			graph.get(src).add(new Node(dest, values[i]));
			graph.get(dest).add(new Node(src, 1 / values[i]));

		}

		return graph;

	}

	static class Pair7 implements Comparable<Pair7> {
		int r1;
		int c1;
		int diff;

		Pair7(int r1, int c1, int diff) {
			this.r1 = r1;
			this.c1 = c1;
			this.diff = diff;
		}

		public int compareTo(Pair7 o) {
			return this.diff - o.diff;
		}
	}

	// 1631. Path With Minimum Effort
	// we have applied Dijkstra algorithms.
	public int minimumEffortPath(int[][] heights) {

		PriorityQueue<Pair7> q = new PriorityQueue();
		q.add(new Pair7(0, 0, 0));
		int n = heights.length;

		int row = heights.length;
		int col = heights[0].length;
		boolean visited[][] = new boolean[row][col];

		while (q.size() > 0) {

			Pair7 rem = q.remove();

			if (rem.r1 == row - 1 && rem.c1 == col - 1) {
				return rem.diff;
			}

			if (visited[rem.r1][rem.c1]) {
				continue;
			}

			visited[rem.r1][rem.c1] = true;
			// right side
			if (rem.c1 + 1 < col) {
				if (visited[rem.r1][rem.c1 + 1] == false) {
					int diff = Math.abs(heights[rem.r1][rem.c1] - heights[rem.r1][rem.c1 + 1]);
					q.add(new Pair7(rem.r1, rem.c1 + 1, Math.max(diff, rem.diff)));
				}
			}

			// left side
			if (rem.c1 - 1 >= 0) {
				if (visited[rem.r1][rem.c1 - 1] == false) {
					int diff = Math.abs(heights[rem.r1][rem.c1] - heights[rem.r1][rem.c1 - 1]);
					q.add(new Pair7(rem.r1, rem.c1 - 1, Math.max(diff, rem.diff)));
				}
			}

			// top side
			if (rem.r1 - 1 >= 0) {
				if (visited[rem.r1 - 1][rem.c1] == false) {
					int diff = Math.abs(heights[rem.r1][rem.c1] - heights[rem.r1 - 1][rem.c1]);
					q.add(new Pair7(rem.r1 - 1, rem.c1, Math.max(diff, rem.diff)));
				}
			}

			// bottom side
			if (rem.r1 + 1 < row) {
				if (visited[rem.r1 + 1][rem.c1] == false) {
					int diff = Math.abs(heights[rem.r1][rem.c1] - heights[rem.r1 + 1][rem.c1]);
					q.add(new Pair7(rem.r1 + 1, rem.c1, Math.max(diff, rem.diff)));
				}
			}

		}

		return -1;

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
