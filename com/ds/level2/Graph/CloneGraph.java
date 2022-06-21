package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.List;

//leetcode 133. Clone Graph

/*
 * Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */

public class CloneGraph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {

		if (node == null) {
			return null;
		}

		Node[] visited = new Node[101];

		return helper(node, visited);

	}

	public Node helper(Node node, Node[] visited) {

		Node cloned = new Node(node.val);
		visited[node.val] = cloned;

		for (Node nbr : node.neighbors) {

			if (visited[nbr.val] == null) {
				Node nbrClone = helper(nbr, visited);
				cloned.neighbors.add(nbrClone);
			} else {
				Node nbrClone = visited[nbr.val];
				cloned.neighbors.add(nbrClone);
			}

		}

		return cloned;

	}

}
