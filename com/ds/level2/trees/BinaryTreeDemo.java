package com.ds.level2.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * Given the root of a binary tree, return the bottom-up level 
 * order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).


 */

public class BinaryTreeDemo {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {

		}

		TreeNode(int data) {
			this.val = data;
		}
	}

	static class Pair {
		int vt;
		TreeNode node;

		Pair(int x, TreeNode y) {
			this.vt = x;
			this.node = y;
		}
	}

	static class Pair2 implements Comparable<Pair2> {
		TreeNode node;
		int vl;
		int hl;

		Pair2(TreeNode node, int vl, int hl) {
			this.node = node;
			this.vl = vl;
			this.hl = hl;
		}

		public int compareTo(Pair2 o) {
			if (this.hl != o.hl) {
				return this.hl - o.hl;
			} else {
				return this.node.val - o.node.val;
			}
		}
	}

	// leetcode 107.
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {

			int size = q.size();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {

				TreeNode temp = (TreeNode) q.remove();
				list.add(temp.val);

				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}

			}

			result.add(list);

		}

		Collections.reverse(result);
		return result;

	}

	// in this we are not printing line wise, we are just printing the node in
	// reverse.
	public ArrayList<Integer> reverseLevelOrder(TreeNode root) {
		// code here

		ArrayList<Integer> ll = new ArrayList<>();

		Stack<Integer> st = new Stack<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {

			TreeNode rem = q.remove();
			st.push(rem.val);

			if (rem.right != null) {
				q.add(rem.right);
			}

			if (rem.left != null) {
				q.add(rem.left);
			}
		}

		while (st.size() > 0) {
			ll.add(st.pop());
		}

		return ll;

	}

	// left view of tree.
	public ArrayList<Integer> leftView(TreeNode root) {
		// Your code here

		ArrayList<Integer> ll = new ArrayList<>();

		if (root == null) {
			return ll;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {

			int size = q.size();
			ll.add(q.peek().val);
			for (int i = 0; i < size; i++) {

				TreeNode rem = q.remove();

				if (rem.left != null) {
					q.add(rem.left);
				}

				if (rem.right != null) {
					q.add(rem.right);
				}

			}

		}

		return ll;

	}

	// 199. Binary Tree Right Side View
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> ll = new ArrayList<>();
		if (root == null) {
			return ll;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				TreeNode rem = q.remove();

				if (i == size - 1) { // if it is lastr node in level.
					ll.add(rem.val);
				}

				if (rem.left != null) {
					q.add(rem.left);
				}

				if (rem.right != null) {
					q.add(rem.right);
				}

			}

		}

		return ll;

	}

	// another approach.
	public List<Integer> rightSideView2(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		Queue<TreeNode> q = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			TreeNode temp = q.remove();
			if (q.isEmpty()) {

				list.add(temp.val);

			}

			if (temp.left != null) {
				q2.add(temp.left);
			}

			if (temp.right != null) {
				q2.add(temp.right);
			}

			if (q.isEmpty()) {

				Queue<TreeNode> t = q;
				q = q2;
				q2 = t;

			}

		}

		return list;

	}

	// Top View of Binary Tree
	static ArrayList<Integer> topView(TreeNode root) {
		// add your code
		ArrayList<Integer> ll = new ArrayList<>();

		HashMap<Integer, TreeNode> map = new HashMap<>();

		if (root == null) {
			return ll;
		}

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		// ll.add(root.data);

		int small = 0; // small verticle
		int large = 0; // large verticle

		while (q.size() > 0) {

			Pair p = q.remove();
			if (!map.containsKey(p.vt)) {
				map.put(p.vt, p.node);
			}

			if (p.node.left != null) {
				q.add(new Pair(p.vt - 1, p.node.left));
				small = Math.min(small, p.vt - 1);
			}

			if (p.node.right != null) {
				q.add(new Pair(p.vt + 1, p.node.right));
				large = Math.max(large, p.vt + 1);
			}

		}

		for (int i = small; i <= large; i++) {

			TreeNode pp = map.get(i);
			ll.add(pp.val);

		}

		return ll;

	}

	// bottom view of tree.
	public ArrayList<Integer> bottomView(TreeNode root) {
		// Code here
		ArrayList<Integer> ll = new ArrayList<>();

		HashMap<Integer, TreeNode> map = new HashMap<>();

		if (root == null) {
			return ll;
		}

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		// ll.add(root.data);

		int small = 0;
		int large = 0;

		while (q.size() > 0) {

			Pair p = q.remove();

			map.put(p.vt, p.node);

			if (p.node.left != null) {
				q.add(new Pair(p.vt - 1, p.node.left));
				small = Math.min(small, p.vt - 1);
			}

			if (p.node.right != null) {
				q.add(new Pair(p.vt + 1, p.node.right));
				large = Math.max(large, p.vt + 1);
			}

		}

		for (int i = small; i <= large; i++) {

			TreeNode pp = map.get(i);
			ll.add(pp.val);

		}

		return ll;

	}

	// leetcode 513. Find Bottom Left Tree Value.
	public int findBottomLeftValue(TreeNode root) {

		Stack<Integer> st = new Stack<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {

			TreeNode rem = q.remove();
			st.push(rem.val);

			if (rem.right != null) {
				q.add(rem.right);
			}

			if (rem.left != null) {
				q.add(rem.left);
			}
		}

		return st.peek(); // on peek left node of bottom level is present.

	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> ans = new ArrayList<>();

		if (root == null) {
			return ans;
		}

		HashMap<Integer, PriorityQueue<Pair2>> map = new HashMap<>();

		Queue<Pair2> q = new LinkedList<>();
		q.add(new Pair2(root, 0, 1));

		int small = 0;
		int large = 0;

		while (q.size() > 0) {

			Pair2 rem = q.remove();

			if (map.containsKey(rem.vl)) {
				PriorityQueue<Pair2> ll = map.get(rem.vl);
				ll.add(rem);
				map.put(rem.vl, ll);
			} else {
				PriorityQueue<Pair2> list = new PriorityQueue<>();
				list.add(rem);
				map.put(rem.vl, list);
			}

			if (rem.node.left != null) {
				q.add(new Pair2(rem.node.left, rem.vl - 1, rem.hl + 1));
				small = Math.min(small, rem.vl - 1);
			}

			if (rem.node.right != null) {
				q.add(new Pair2(rem.node.right, rem.vl + 1, rem.hl + 1));
				large = Math.max(large, rem.vl + 1);
			}

		}

		for (int i = small; i <= large; i++) {

			List<Integer> l = new ArrayList<>();
			PriorityQueue<Pair2> pq = map.get(i);

			while (pq.size() > 0) {
				l.add(pq.remove().node.val);
			}

			ans.add(l);
		}

		// if we use ArrayList on place of PriorityQueue.

//		for (int i = small; i <= large; i++) {
//
//			List<Integer> l = new ArrayList<>();
//			ArrayList<Pair2> unsorted = map.get(i);
//		    Collections.sort(unsorted);
//
//			 for(Pair p:unsorted) {
//				l.add(p.node.val);
//			}
//
//			ans.add(l);
//		}

		return ans;

	}

	// print diagonal view.
	public ArrayList<Integer> diagonal(TreeNode root) {
		// add your code here.

		if (root == null) {
			return new ArrayList<Integer>();
		}

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		traverse(root, 0, map);

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i <= md; i++) {
			ArrayList<Integer> ll = map.get(i);
			for (int x : ll) {
				ans.add(x);
			}
		}

		return ans;

	}

	int md = 0;

	public void traverse(TreeNode root, int diag, HashMap<Integer, ArrayList<Integer>> map) {

		if (root == null) {
			return;
		}

		if (diag > md) {
			md = diag;
		}

		if (map.containsKey(diag) == false) {

			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.val);
			map.put(diag, list);

		} else {

			ArrayList<Integer> list = map.get(diag);
			list.add(root.val);
			map.put(diag, list);

		}

		traverse(root.left, diag + 1, map);
		traverse(root.right, diag, map);

	}

	static class Pair3 {
		int diag;
		TreeNode node;

		Pair3(int d, TreeNode node) {
			this.diag = d;
			this.node = node;
		}

	}

	// this approach will not work on gfg bcoz we will not get node of some diagonal
	// in order in some cases.
	public ArrayList<Integer> diagonal2(TreeNode root) {
		// add your code here.

		Queue<Pair3> q = new LinkedList<>();
		q.add(new Pair3(0, root));

		HashMap<Integer, ArrayList<Pair3>> map = new HashMap<>();

		int maxDiag = 0;

		while (q.size() > 0) {

			Pair3 rem = q.remove();

			if (rem.diag > maxDiag) {
				maxDiag = rem.diag;
			}

			if (map.containsKey(rem.diag)) {
				ArrayList<Pair3> ll = map.get(rem.diag);
				ll.add(rem);
			} else {
				ArrayList<Pair3> ll = new ArrayList<>();
				ll.add(rem);
				map.put(rem.diag, ll);
			}

			if (rem.node.left != null) {
				q.add(new Pair3(rem.diag + 1, rem.node.left));
			}

			if (rem.node.right != null) {
				q.add(new Pair3(rem.diag, rem.node.right));
			}

		}

		ArrayList<Integer> ll = new ArrayList<>();

		for (int i = 0; i <= maxDiag; i++) {
			ArrayList<Pair3> list = map.get(i);
			for (Pair3 pp : list) {
				ll.add(pp.node.val);
			}
		}

		return ll;

	}

	// boundry traversal of tree.
	ArrayList<Integer> boundary(TreeNode node) {

		ArrayList<Integer> list = new ArrayList<>();

		if (node == null) {
			return list;
		}

		list.add(node.val); // adding root.

		leftWall(node.left, list);
		leaves(node.left, list);
		leaves(node.right, list);
		rightWall(node.right, list);

		return list;

	}

	public void leftWall(TreeNode node, ArrayList<Integer> list) {

		if (node == null) {
			return;
		}

		// we are checking this node should not be leave
		if (node.left != null || node.right != null) { // in preorder we are adding
			list.add(node.val);
		}

		if (node.left != null) {
			leftWall(node.left, list);
		} else if (node.right != null) {
			leftWall(node.right, list);
		}

	}

	public void leaves(TreeNode node, ArrayList<Integer> list) {

		if (node == null) {
			return;
		}

		leaves(node.left, list);

		if (node.left == null && node.right == null) { // in inorder we add leaves
			list.add(node.val);
		}

		leaves(node.right, list);

	}

	public void rightWall(TreeNode node, ArrayList<Integer> list) {

		if (node == null) {
			return;
		}

		if (node.right != null) {
			rightWall(node.right, list);
		} else if (node.left != null) {
			rightWall(node.left, list);
		}

		// we are checking this node should not be leave
		if (node.left != null || node.right != null) { // in postorder we are adding
			list.add(node.val);
		}

	}

	// 1145. Binary Tree Coloring Game
	int xKaLeft;
	int xKaRight;

	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

		size(root, x);

		int otherSideSize = n - (xKaLeft + xKaRight + 1);

		int maxOfThree = Math.max(otherSideSize, Math.max(xKaLeft, xKaRight));

		int rest = n - maxOfThree; // this is node select by player 1.

		if (maxOfThree > rest) {
			return true;
		}

		return false;

	}

	public int size(TreeNode node, int x) {
		if (node == null) {
			return 0;
		}

		int l = size(node.left, x);
		int r = size(node.right, x);

		if (node.val == x) {
			xKaLeft = l;
			xKaRight = r;
		}

		return l + r + 1;

	}

	// Inorder using Morris Traversal.
	// time => O(n).
	// space => O(1).
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		TreeNode curr = root;

		while (curr != null) {
			if (curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			} else {

				TreeNode iop = curr.left;
				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) { // if left is not processed.
					iop.right = curr; // making a thread.
					curr = curr.left;
				} else { // if left is processed.
					iop.right = null; // breaking a thread.
					list.add(curr.val);
					curr = curr.right;
				}

			}
		}

		return list;

	}

	// Preorder using Morris Traversal.
	// time => O(n).
	// space => O(1).
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}

		TreeNode curr = root;

		while (curr != null) {
			if (curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			} else {

				TreeNode iop = curr.left;
				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) { // if left is not processed.
					list.add(curr.val); // in preorder we are adding.
					iop.right = curr; // making a thread.
					curr = curr.left;
				} else { // if left is processed.
					iop.right = null; // breaking a thread.
					curr = curr.right;
				}

			}
		}

		return list;

	}

	// 99. Recover Binary Search Tree
	// we have applied inorder morris traversal, we have used one previous pointer
	// that will point to
	// previous node of current node.
	public void recoverTree(TreeNode root) {

		if (root == null) {
			return;
		}

		TreeNode curr = root;
		TreeNode pre = null;
		TreeNode n1 = null;
		TreeNode n2 = null;

		while (curr != null) {
			if (curr.left == null) {

				// we are checking here bcoz at this point we get node in inorder traversal.
				if (pre != null) {
					if (curr.val < pre.val) {
						if (n1 == null) {
							n1 = pre;
							n2 = curr;
						} else {
							n2 = curr;
						}
					}
				}

				pre = curr;
				curr = curr.right;
			} else {

				TreeNode iop = curr.left;
				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) {
					iop.right = curr;
					curr = curr.left;
				} else {

					// we are checking here bcoz at this point we get node in inorder traversal.
					if (pre != null) {
						if (curr.val < pre.val) {
							if (n1 == null) {
								n1 = pre;
								n2 = curr;
							} else {
								n2 = curr;
							}
						}
					}

					pre = curr;
					iop.right = null;
					curr = curr.right;
				}

			}
		}

		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;

	}

	// Inorder Successor in BST
	public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {

		TreeNode curr = root;
		boolean flag = false;
		TreeNode succ = null;
		TreeNode prev = null;

		while (curr != null) {

			if (curr.left == null) {

				if (prev == x) {
					succ = curr;
					break;
				}

				prev = curr;
				curr = curr.right;

			} else {

				TreeNode iop = curr.left;
				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) {
					iop.right = curr;
					curr = curr.left;
				} else {

					if (prev == x) {
						succ = curr;
						break;
					}

					prev = curr;

					iop.right = null;
					curr = curr.right;
				}

			}

		}
		return succ;

	}

	// Inorder Successor in BST
	// another appraoch
	public TreeNode inorderSuccessor2(TreeNode root, TreeNode x) {

		TreeNode curr = root;
		boolean flag = false;
		TreeNode succ = null;

		while (curr != null) {

			if (curr.left == null) {

				if (flag == true) {
					succ = curr;
					break;
				}
				if (curr == x) {
					flag = true;
				}
				curr = curr.right;

			} else {

				TreeNode iop = curr.left;
				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) {
					iop.right = curr;
					curr = curr.left;
				} else {

					if (flag == true) {
						succ = curr;
						break;
					}
					if (curr == x) {
						flag = true;
					}

					iop.right = null;
					curr = curr.right;
				}

			}

		}
		return succ;

	}

	// 105. Construct Binary Tree from Preorder and Inorder Traversal
	Map<Integer, Integer> map;
	int id = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		map = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		TreeNode root = constructTree(preorder, inorder, 0, inorder.length - 1);
		return root;

	}

	public TreeNode constructTree(int pre[], int in[], int s, int e) {

		if (s > e) {
			return null;
		}

		TreeNode root = new TreeNode(pre[id++]);
		if (s == e) {
			return root;
		}

		int index = map.get(root.val);
		root.left = constructTree(pre, in, s, index - 1);
		root.right = constructTree(pre, in, index + 1, e);

		return root;

	}

	// 106. Construct Binary Tree from Inorder and Postorder Traversal
	public TreeNode build(int[] inorder, int[] postorder) {

		map = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		TreeNode root = construct(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
		return root;

	}

	public TreeNode construct(int[] inorder, int[] postorder, int post_lo, int post_hi, int in_lo, int in_hi) {

		if (post_lo > post_hi || in_lo > in_hi) {
			return null;
		}

		int idx = map.get(postorder[post_hi]);

		TreeNode root = new TreeNode();

		root.val = postorder[post_hi];

		int rhs = in_hi - idx;

		root.left = construct(inorder, postorder, post_lo, post_hi - rhs - 1, in_lo, idx - 1);
		root.right = construct(inorder, postorder, post_hi - rhs, post_hi - 1, idx + 1, in_hi);

		return root;

	}

	// 222. Count Complete Tree Nodes
	// Time = O(logn^2)
	public int countNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		// finding left heigth.
		int lh = 0;
		TreeNode node = root.left;
		while (node != null) {
			lh++;
			node = node.left;
		}

		// finding right heigth.
		int rh = 0;
		node = root.right;
		while (node != null) {
			rh++;
			node = node.right;
		}

		if (lh == rh) {
			int ht = lh + 1;
			return (1 << ht) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}

	}

	// Maximum sum leaf to root path
	/*
	 * Given a Binary Tree, find the maximum sum path from a leaf to root.
	 */

	public static int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}
		// code here
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);

		return Math.max(left, right) + root.val;
	}

	// this appraoch will work for all possible cases above may not work in some
	// cases, if tree has
	// negative value and only have left side don't have right side.
	public static int maxPathSum2(TreeNode root) {

		if (root.left != null && root.right != null) {
			int left = maxPathSum(root.left);
			int right = maxPathSum(root.right);

			return Math.max(left, right) + root.val;
		} else if (root.left != null) {
			int left = maxPathSum(root.left);
			return left + root.val;
		} else if (root.right != null) {
			int right = maxPathSum(root.right);
			return right + root.val;
		} else {
			return root.val;
		}

	}

	// this is finest solution. it will also work in negative cases.
	public static int maxPathSum3(TreeNode root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}

		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);

		return Math.max(left, right) + root.val;

	}

	// maximum path sum from root node to any node.
	int findMaxSum(TreeNode node) {
		// your code goes here

		if (node.left != null && node.right != null) {
			int left = findMaxSum(node.left);
			int right = findMaxSum(node.right);

			int left_dash = Math.max(0, left);
			int right_dash = Math.max(0, right);

			return Math.max(left_dash, right_dash) + node.val;

		} else if (node.left != null) {
			int left = findMaxSum(node.left);
			int left_dash = Math.max(0, left);

			return left_dash + node.val;
		} else if (node.right != null) {
			int right = findMaxSum(node.right);
			int right_dash = Math.max(0, right);

			return right_dash + node.val;
		} else {
			return node.val;
		}

	}

	// 124. Binary Tree Maximum Path Sum
	// maximum path sum from any node to any node.
	int sum = Integer.MIN_VALUE;

	int findMaxSumFfromAnyToAny(TreeNode node) {
		// your code goes here
		sum = Integer.MIN_VALUE;
		int ans = traverse(node);
		return sum;

	}

	// it returns the maximum path from root to node but it also calculate maximum
	// path from node to node.
	int traverse(TreeNode node) {
		if (node.left != null && node.right != null) {
			int left = traverse(node.left);
			int right = traverse(node.right);

			int left_dash = Math.max(0, left);
			int right_dash = Math.max(0, right);

			int ans = Math.max(left_dash, right_dash) + node.val;

			sum = Math.max(sum, (left_dash + right_dash + node.val));
			return ans;

		} else if (node.left != null) {
			int left = traverse(node.left);
			int left_dash = Math.max(0, left);

			int ans = left_dash + node.val;

			sum = Math.max(sum, (left_dash + node.val));
			return ans;
		} else if (node.right != null) {
			int right = traverse(node.right);
			int right_dash = Math.max(0, right);

			int ans = right_dash + node.val;
			sum = Math.max(sum, (right_dash + node.val));
			return ans;
		} else {
			sum = Math.max(sum, node.val);
			return node.val;
		}
	}

}
