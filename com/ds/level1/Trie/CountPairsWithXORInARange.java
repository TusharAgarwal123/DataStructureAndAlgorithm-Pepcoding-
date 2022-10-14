package com.ds.level1.Trie;

//1803. Count Pairs With XOR in a Range

/*
 * Given a (0-indexed) integer array nums and two integers low and high, return the number of nice pairs.

A nice pair is a pair (i, j) where 0 <= i < j < nums.length and low <= (nums[i] XOR nums[j]) <= high.
 */

public class CountPairsWithXORInARange {

	static class Node {
		Node[] children = new Node[2];
		int count = 0;

	}

	int helper(int a, int k) {

		int countSmaller = 0;

		Node temp = root;
		for (int i = 15; i >= 0; i--) {
			int kbit = (k & (1 << i)) == 0 ? 0 : 1;
			int abit = (a & (1 << i)) == 0 ? 0 : 1;
			int rbit = Math.abs(abit - 1);

			if (kbit == 1) {
				if (temp.children[abit] != null) {
					countSmaller += temp.children[abit].count;
				}
				temp = temp.children[rbit];
			} else {
				temp = temp.children[abit];
			}

			if (temp == null) {
				break;
			}
		}

		return countSmaller;

	}

	void insert(int num) {
		Node temp = root;
		for (int i = 15; i >= 0; i--) { // given in constraint.
			int bit = (num & (1 << i)) == 0 ? 0 : 1;
			if (temp.children[bit] == null) {
				temp.children[bit] = new Node();
			}

			temp = temp.children[bit];
			temp.count++;
		}
	}

	Node root = new Node();

	public int countPairs(int[] nums, int low, int high) {

		int res = 0;

		for (int num : nums) {
			res += helper(num, high + 1) - helper(num, low);
			insert(num);
		}

		return res;

	}

}
