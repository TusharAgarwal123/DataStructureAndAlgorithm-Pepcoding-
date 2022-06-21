package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//815. Bus Routes
public class BusRoutes {

	static class Pair {
		int bus;
		int csf; // count so far

		Pair(int b, int c) {
			this.bus = b;
			this.csf = c;
		}
	}

	public int numBusesToDestination(int[][] routes, int source, int target) {

		if (source == target) {
			return 0;
		}

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int bus = 0; bus < routes.length; bus++) {
			for (int stop : routes[bus]) {
				if (map.containsKey(stop) == false) {
					map.put(stop, new ArrayList<>());
				}
				map.get(stop).add(bus);
			}
		}

		Queue<Pair> queue = new LinkedList<>();
		for (int bsrc : map.get(source)) {
			queue.add(new Pair(bsrc, 1));
		}

		boolean[] visited = new boolean[routes.length];
		while (queue.size() > 0) {
			// n*
			Pair rem = queue.remove();

			if (visited[rem.bus] == true) {
				continue;
			}
			visited[rem.bus] = true;

			for (int rstop : routes[rem.bus]) {
				if (rstop == target) {
					return rem.csf;
				}
			}

			for (int rstop : routes[rem.bus]) {
				for (int bus : map.get(rstop)) {
					if (visited[bus] == false) {
						queue.add(new Pair(bus, rem.csf + 1));
					}
				}
			}
		}

		return -1;
	}

}
