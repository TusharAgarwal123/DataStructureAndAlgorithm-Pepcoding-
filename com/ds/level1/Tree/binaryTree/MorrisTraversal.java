package com.ds.level1.Tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public static TreeNode rightMostNode(TreeNode node, TreeNode curr) {
		while (node.right != null && node.right != curr)
			node = node.right;

		return node;
	}

	// here time is O(n) and space is O(1).
	public static List<Integer> inorder_Morris(TreeNode node) {
		List<Integer> ans = new ArrayList<>();
		TreeNode curr = node;
		while (curr != null) {
			TreeNode left = curr.left;
			if (left == null) {
				ans.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode rmn = rightMostNode(left, curr);
				if (rmn.right == null) { // thread creation
					rmn.right = curr;
					curr = curr.left;
				} else { // destroy thread
					rmn.right = null;
					ans.add(curr.val);
					curr = curr.right;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// Write your code here

	}
}
