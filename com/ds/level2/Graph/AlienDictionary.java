package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
 *  Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output
 will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 */

//on gfg.
public class AlienDictionary {

	public String findOrder(String[] dict, int N, int K) {
		// Write your code here

		ArrayList<Integer>[] graph = new ArrayList[K];

		for (int v = 0; v < K; v++) {
			graph[v] = new ArrayList<Integer>();
		}

		for (int i = 0; i < dict.length - 1; i++) {

			String w1 = dict[i];
			String w2 = dict[i + 1];

			for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				char c1 = w1.charAt(j);
				char c2 = w2.charAt(j);

				if (c1 != c2) {
					graph[c1 - 'a'].add(c2 - 'a');
					break;
				}
			}

		}

		boolean vis[] = new boolean[K];
		Stack<Integer> st = new Stack<>();
		for (int v = 0; v < K; v++) {
			if (vis[v] == false) {
				tsort(graph, vis, st, v);
			}
		}

		StringBuilder ans = new StringBuilder();
		while (st.size() > 0) {

			char c = (char) (st.pop() + 'a');
			ans.append(c);

		}

		return ans.toString();

	}

	// topological sorting.
	public void tsort(ArrayList<Integer>[] graph, boolean vis[], Stack<Integer> st, int v) {

		if (vis[v] == true) {
			return;
		}

		vis[v] = true;
		for (int n : graph[v]) {
			tsort(graph, vis, st, n);
		}

		st.push(v);

	}

}
