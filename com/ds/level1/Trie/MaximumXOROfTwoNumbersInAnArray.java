package com.ds.level1.Trie;

//421. Maximum XOR of Two Numbers in an Array

/*
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
 */

public class MaximumXOROfTwoNumbersInAnArray {

	static class Node {
		Node[] children = new Node[2];

	}

	public int findMaximumXOR(int[] nums) {

		Node root = new Node();

		for (int num : nums) {
			Node temp = root;
			for (int i = 30; i >= 0; i--) { // numbers are postive that's why checking from 31st bit.
				int bit = (num & (1 << i)) == 0 ? 0 : 1; // checking ith bit is on or not.

				if (temp.children[bit] == null) {
					temp.children[bit] = new Node();
				}

				temp = temp.children[bit];
			}
		}

		int res = 0;

		for (int num : nums) {

			int xor = 0;
			Node temp = root;
			for (int i = 30; i >= 0; i--) {
				int bit = (num & (1 << i)) == 0 ? 0 : 1;

				int cbit = Math.abs(bit - 1); // just flipping the bit.

				if (temp.children[cbit] != null) {
					temp = temp.children[cbit];
					xor = xor | (1 << i);
				} else {
					temp = temp.children[bit];
				}

			}

			res = Math.max(res, xor);

		}

		return res;

	}

}
