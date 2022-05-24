package com.ds.leetcode.may;

//1302. Deepest Leaves Sum
public class DeepestLeavesSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int sum = 0;

	public int deepestLeavesSum(TreeNode root) {

		if (root == null) {
			return sum;
		}

		int ht = height(root);

		findSum(root, ht);

		return sum;

	}

	public void findSum(TreeNode root, int depth) {

		if (root == null) {
			return;
		}

		if (depth == 0) {
			sum += root.val;
			return;
		}

		findSum(root.left, depth - 1);
		findSum(root.right, depth - 1);

	}

	public int height(TreeNode root) {

		if (root == null) {
			return -1;
		}

		int left = height(root.left);
		int right = height(root.right);

		return Math.max(left, right) + 1;

	}

}
