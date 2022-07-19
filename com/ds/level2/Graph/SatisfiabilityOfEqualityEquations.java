package com.ds.level2.Graph;

//leetcode 990. Satisfiability of Equality Equations

/*
 * You are given an array of strings equations that represent relationships between variables where each
 *  string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and
 *   yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations,
 or false otherwise.
 */

public class SatisfiabilityOfEqualityEquations {

	int parent[];
	int rank[];

	public boolean equationsPossible(String[] equations) {

		parent = new int[26];
		rank = new int[26];

		for (int i = 0; i < 26; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (String str : equations) {

			if (str.charAt(1) == '=') {
				if (str.charAt(0) != str.charAt(3)) {
					unionHelper(str.charAt(0) - 'a', str.charAt(3) - 'a');
				}
			}

		}

		for (String str : equations) {

			if (str.charAt(1) == '!') {
				if (find(str.charAt(0) - 'a') == find(str.charAt(3) - 'a')) {
					return false;
				}

			}

		}

		return true;

	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}

	public void unionHelper(int x, int y) {

		if (find(x) != find(y)) {
			union(find(x), find(y));
		}

	}

	public void union(int x, int y) {
		if (rank[x] < rank[y]) {
			parent[x] = y;
		} else if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			rank[y]++;
		}
	}

}
