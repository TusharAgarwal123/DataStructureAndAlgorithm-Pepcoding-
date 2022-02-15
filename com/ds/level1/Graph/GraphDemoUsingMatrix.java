package com.ds.level1.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//this is graph using Adjacency Matrix.
public class GraphDemoUsingMatrix {

	static class Pair4 {
		int vtx;
		int level;

		Pair4(int vtx, int level) {
			this.vtx = vtx;
			this.level = level;
		}

	}

	public static void printAllPaths(Integer[][] graph, boolean[] visited, int src, int dest, String psf) {
		if (src == dest) {
			System.out.println(psf);
			return;
		}

		visited[src] = true;
		for (int nbr = 0; nbr < graph.length; nbr++) {
			if (graph[src][nbr] != null && visited[nbr] == false) {
				printAllPaths(graph, visited, nbr, dest, psf + nbr);
			}
		}

		visited[src] = false;
	}

	public static void spreadOfInfection(Integer[][] graph, int src, int t) {

		boolean[] visited = new boolean[graph.length];
		Queue<Pair4> q = new LinkedList<>();
		q.add(new Pair4(src, 1));

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

			for (int nbr = 0; nbr < graph.length; nbr++) {
				if (graph[src][nbr] != null && visited[nbr] == false) {
					q.add(new Pair4(nbr, rem.level + 1));
				}
			}
		}

		System.out.println(c);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		Integer[][] graph = new Integer[vtces][vtces];

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1][v2] = wt;
			graph[v2][v1] = wt;
		}

		int src = Integer.parseInt(br.readLine());
		int dest = Integer.parseInt(br.readLine());

		// write all your codes here
		boolean[] visited = new boolean[vtces];
		printAllPaths(graph, visited, src, dest, src + "");
		
	}

}
