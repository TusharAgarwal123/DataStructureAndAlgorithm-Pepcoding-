package com.ds.leetcode.may;

//1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

// TreeNode cl=null;

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

		// solve(original,cloned,target);
		// return cl;

		if (original == null) {
			return original;
		}

		if (original == target) {
			return cloned;
		}

		TreeNode left = getTargetCopy(original.left, cloned.left, target);
		TreeNode right = getTargetCopy(original.right, cloned.right, target);

		if (left != null) {
			return left;
		} else {
			return right;
		}

	}

//     public void solve(final TreeNode original, final TreeNode cloned, final TreeNode target){

//         if(original==null){  //need not to check for cloned bcoz cloned is same tree as
//             return;          //original.
//         }

//         if(original.val==target.val){
//             cl=cloned;
//             return;
//         }

//          getTargetCopy(original.left,cloned.left,target);
//          getTargetCopy(original.right,cloned.right,target);

//     }

}
