package com.ds.level2.trees;

public class ValidateBSTUsingMorris {

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

	public boolean isValidBST(TreeNode node) {

		if (node == null) {
			return true;
		}

		TreeNode prev = null;

		TreeNode curr = node;

		while (curr != null) {
			if (curr.left == null) {
				if (prev != null && prev.val >= curr.val) {
					return false;
				}
				prev = curr;
				curr = curr.right;
			} else {

				TreeNode iop = node.left;
				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) {
					iop.right = curr;
					curr = curr.left;
				} else {

					if (prev != null && prev.val >= curr.val) {
						return false;
					}
					prev = curr;
					iop.right = null;
					curr = curr.right;
				}

			}
		}

		return true;

	}

}
