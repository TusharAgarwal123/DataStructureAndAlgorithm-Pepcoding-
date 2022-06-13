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
		TreeNode random;

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

	// leetcode 437. Path Sum III
	Map<Integer, Integer> frMap;
	int c = 0;

	public int pathSum(TreeNode root, int targetSum) {

		if (root == null) {
			return 0;
		}

		frMap = new HashMap<>();
		frMap.put(0, 1);
		solve(root, root.val, targetSum);
		return c;

	}

	public void solve(TreeNode root, int sum, int target) {

		c += frMap.getOrDefault((sum - target), 0);

		frMap.put(sum, frMap.getOrDefault(sum, 0) + 1);

		if (root.left != null) {
			solve(root.left, sum + root.left.val, target);
		}

		if (root.right != null) {
			solve(root.right, sum + root.right.val, target);
		}

		frMap.put(sum, frMap.get(sum) - 1); // decreasing the frequency of sum when we return from node.

	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}

		// 116. Populating Next Right Pointers in Each Node
		public Node connect(Node root) {

			if (root == null) {
				return root;
			}

			Node main = root;
			while (main.left != null) {
				// temp will traverse all the node of each level and connect it's childrens
				// next.
				Node temp = main;

				while (temp != null) {
					temp.left.next = temp.right;
					if (temp.next != null) {
						temp.right.next = temp.next.left;
					}
					temp = temp.next;
				}

				main = main.left;

			}

			return root;

		}

		// 117. Populating Next Right Pointers in Each Node II
		// This approach can be use for both question 116 and 117.
		public Node connect2(Node root) {

			Node curr = root;
			Node head = null;
			Node tail = null;

			while (curr != null) {

				// code for curr on level x,and head, tail on level x+1.
				while (curr != null) {

					if (curr.left != null) {
						if (head == null) {
							head = tail = curr.left;
						} else {
							tail.next = curr.left;
							tail = curr.left;
						}
					}

					if (curr.right != null) {
						if (head == null) {
							head = tail = curr.right;
						} else {
							tail.next = curr.right;
							tail = curr.right;
						}
					}

					curr = curr.next;

				}

				curr = head;
				head = null;
				tail = null;

			}

			return root;

		}

		// Image Multiplication on geeksforgeeks
		// we have to do the mod of product it is given in question.
		long ans = 0;
		long mod = 1000000007;

		public long imgMultiply(Node root) {
			// code here
			ans = (root.val * root.val) % mod;
			helper(root.left, root.right);
			return ans;

		}

		public void helper(Node n1, Node n2) {
			if (n1 == null || n2 == null) {
				return;
			}

			ans = (ans + n1.val * n2.val) % mod;

			helper(n1.left, n2.right);
			helper(n1.right, n2.left);

		}

	}

	// Find the Closest Element in BST

	// time => O(logn)
	static int minAbs;

	static int minDiff(Node root, int K) {
		// Write your code here

		minAbs = Integer.MAX_VALUE;
		helper(root, K);
		return minAbs;

	}

	static void helper(Node root, int k) {

		if (root == null) {
			return;
		}

		int diff = Math.abs(root.val - k);

		minAbs = Math.min(minAbs, diff);

		if (root.val > k) {
			helper(root.left, k);
		} else if (root.val < k) {
			helper(root.right, k);
		} else {
			return;
		}

	}

	// Maximum Path Sum between 2 Leaf Nodes on gfg.
	int max;

	int maxPathSum(Node root) {
		// code here
		max = Integer.MIN_VALUE;
		if (root.left != null && root.right != null) {
			traverse(root);
			return max;
		} else { // if one side is null
			int val = traverse(root); // it will return max path from root to leaf
			return Math.max(val, max);
		}
	}

	// this method will return max path from root to leaf
	public int traverse(Node root) {

		if (root.left != null && root.right != null) {
			int left = traverse(root.left);
			int right = traverse(root.right);

			max = Math.max(max, (left + right + root.val)); // calculating leaf to leaf path.

			return Math.max(left, right) + root.val;
		} else if (root.left != null) {
			int left = traverse(root.left);

			// max=Math.max(max,(left+root.data));
			return left + root.val;
		} else if (root.right != null) {
			int right = traverse(root.right);

			// max=Math.max(max,(right+root.data));
			return right + root.val;
		} else {
			// if it is leaf node
			// max=Math.max(max,root.data);
			return root.val;
		}

	}

	// 1008. Construct Binary Search Tree from Preorder Traversal
	int index = 0;

	public TreeNode bstFromPreorder(int[] preorder) {

		return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	public TreeNode construct(int pre[], int min, int max) {

		if (index == pre.length) {
			return null;
		} else if (pre[index] > min && pre[index] < max) {
			TreeNode node = new TreeNode(pre[index]);
			index++;
			node.left = construct(pre, min, node.val);
			node.right = construct(pre, node.val, max);
			return node;
		} else {
			return null;
		}

	}

	// Construct BST from Postorder on gfg
	static int ind;

	public static TreeNode constructTree(int post[], int n) {
		// Add your code here.
		ind = n - 1;
		return construct2(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static TreeNode construct2(int post[], int min, int max) {

		if (ind < 0) {
			return null;
		} else if (post[ind] > min && post[ind] < max) {
			TreeNode node = new TreeNode(post[ind]);
			ind--;

			node.right = construct2(post, node.val, max);
			node.left = construct2(post, min, node.val);

			return node;
		} else {
			return null;
		}

	}

	// leetcode 968. Binary Tree Cameras
	int count = 0;
	final int CAMERA = 1;
	final int MONITOR = 2;
	final int NOT_MONITOR = 3;

	public int minCameraCover(TreeNode root) {

		if (root == null) {
			return count;
		}

		int val = helper(root);
		if (val == NOT_MONITOR) {
			count++;
		}

		return count;

	}

	public int helper(TreeNode root) {

		if (root == null) {
			return MONITOR;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		if (left == NOT_MONITOR || right == NOT_MONITOR) {
			count++;
			return CAMERA;
		} else if (left == CAMERA || right == CAMERA) {
			return MONITOR;
		} else {
			return NOT_MONITOR; // when from both side monitor is return.
		}

	}

	// on gfg
	public TreeNode cloneTree(TreeNode tree) {
		// add code here.

		createDuplicates(tree);
		setRandoms(tree);
		return extractTree(tree);
	}

	public void setRandoms(TreeNode orig) {

		if (orig == null) {
			return;
		}

		setRandoms(orig.left.left); // bcoz we have cloned the left node only.
		setRandoms(orig.right);

		if (orig.random != null) {
			orig.left.random = orig.random.left;
		}

	}

	public TreeNode extractTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode leftDup = extractTree(root.left.left);
		TreeNode rightDup = extractTree(root.right);

		// root.left=left;
		// root.right=right;

		TreeNode dup = root.left;
		root.left = root.left.left;

		dup.left = leftDup;
		dup.right = rightDup;

		return dup;

	}

	public void createDuplicates(TreeNode root) {

		if (root == null) {
			return;
		}

		createDuplicates(root.left);
		createDuplicates(root.right);

		TreeNode clone = new TreeNode(root.val);
		// clone.data=root.data;

		clone.left = root.left;
		clone.right = null;
		root.left = clone;

	}

	// leetcode 834. Sum of Distances in Tree.
	public int[] sumOfDistancesInTree(int n, int[][] edges) {

		ArrayList<Integer>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edges.length; i++) {

			int u = edges[i][0];
			int v = edges[i][1];

			graph[u].add(v);
			graph[v].add(u);
		}

		int nodes[] = new int[n];
		int res[] = new int[n];

		helper(graph, nodes, res, 0, -1);
		helper2(graph, nodes, res, 0, -1);

		return res;

	}

	public void helper(ArrayList<Integer>[] graph, int nodes[], int res[], int src, int par) {

		for (int nbr : graph[src]) {
			if (nbr != par) {
				helper(graph, nodes, res, nbr, src);
				nodes[src] += nodes[nbr];
				res[src] += nodes[nbr] + res[nbr];
			}
		}

		nodes[src]++;

	}

	public void helper2(ArrayList<Integer>[] graph, int nodes[], int res[], int src, int par) {

		for (int nbr : graph[src]) {
			if (nbr != par) {
				res[nbr] = res[src] + (nodes.length - nodes[nbr]) - (nodes[nbr]);
				helper2(graph, nodes, res, nbr, src);
			}
		}

	}

	// leetcode 889. Construct Binary Tree from Preorder and Postorder Traversal
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			map.put(postorder[i], i);
		}

		return helper(preorder, postorder, map, 0, preorder.length - 1, 0, postorder.length - 1);

	}

	public TreeNode helper(int pre[], int post[], HashMap<Integer, Integer> map, int prelo, int prehi, int postlo,
			int posthi) {

		if (prelo > prehi || postlo > posthi) {
			return null;
		}

		TreeNode node = new TreeNode(pre[prelo]);

		if (prelo + 1 <= prehi) {
			int sidx = map.get(pre[prelo + 1]);
			int lhs = sidx - postlo + 1;

			node.left = helper(pre, post, map, prelo + 1, prelo + lhs, postlo, sidx);
			node.right = helper(pre, post, map, prelo + lhs + 1, prehi, sidx + 1, posthi - 1);
		}
		return node;
	}

	// leetcode 114. Flatten Binary Tree to Linked List
	static class Pair4 {
		TreeNode head;
		TreeNode tail;
	}

	public void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		flattenHelper(root);

	}

	public Pair4 flattenHelper(TreeNode root) {

		if (root.left != null && root.right != null) {

			Pair4 lp = flattenHelper(root.left);
			Pair4 rp = flattenHelper(root.right);

			lp.tail.right = rp.head;

			Pair4 my = new Pair4();
			my.head = root;
			my.head.left = null;
			my.head.right = lp.head;
			my.tail = rp.tail;

			return my;

		} else if (root.left != null) {

			Pair4 lp = flattenHelper(root.left);

			Pair4 my = new Pair4();
			my.head = root;
			my.head.left = null;
			my.head.right = lp.head;
			my.tail = lp.tail;

			return my;

		} else if (root.right != null) {

			Pair4 rp = flattenHelper(root.right);

			Pair4 my = new Pair4();
			my.head = root;
			my.head.left = null;
			my.head.right = rp.head;
			my.tail = rp.tail;

			return my;

		} else {

			Pair4 my = new Pair4();
			my.tail = root;
			my.head = root;
			return my;
		}

	}

	// leetcode 114. Flatten Binary Tree to Linked List
	TreeNode prev = null;

	public void flatten2(TreeNode root) {

		if (root == null) {
			return;
		}

		// flattenHelper(root);

		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;

	}

	// Binary Tree to CDLL on gfg
	Node bTreeToClist(Node root) {

		return helper(root);

	}

	Node helper(Node node) {
		if (node == null) {
			return null;
		}

		Node lhead = helper(node.left);
		Node rhead = helper(node.right);

		Node onl = node;
		onl.left = onl.right = onl;

		Node s1 = concat(lhead, onl);
		Node s2 = concat(s1, rhead);

		return s2;
	}

	// concating the two list.
	Node concat(Node h1, Node h2) {
		if (h1 == null) {
			return h2;
		} else if (h2 == null) {
			return h1;
		}

		Node t1 = h1.left; // it gives the last node of first list.
		Node t2 = h2.left; // it gives the last node of second list.

		t1.right = h2;
		h2.left = t1;

		t2.right = h1;
		h1.left = t2;

		return h1;
	}

	// Binary Tree to CDLL on gfg using morris traversal.
	Node bTreeToClist2(Node root) {

		if (root == null) {
			return root;
		}

		Node prev = null;
		Node curr = root;

		int c = 0;
		Node first = null;

		while (curr != null) {
			if (curr.left == null) {

				if (c == 0) {
					first = curr;
					c++;
				}

				if (prev != null) {
					prev.right = curr;
					curr.left = prev;
				}

				prev = curr;
				curr = curr.right;

			} else {

				Node iop = curr.left;

				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) {
					iop.right = curr;
					curr = curr.left;
				} else {

					iop.right = null;

					prev.right = curr;
					curr.left = prev;
					prev = curr;

					curr = curr.right;

				}

			}
		}

		// Node first=root;
		// while(first.left!=null){
		// first=first.left;
		// }

		// prev at the end will be last node in inorder traversal.

		first.left = prev;
		prev.right = first;

		return first;

	}

	// Construct tree from Inorder and LevelOrder on gfg.
	Node buildTreeFromInAndLevel(int inord[], int level[]) {

		// storing indexes of level order.
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < level.length; i++) {
			map.put(level[i], i);
		}
		// your code here
		return buildHelper(inord, map, 0, inord.length - 1);

	}

	Node buildHelper(int inord[], HashMap<Integer, Integer> map, int si, int ei) {

		if (si > ei) {
			return null;
		}

		int minIdx = si;
		for (int i = si + 1; i <= ei; i++) {
			if (map.get(inord[i]) < map.get(inord[minIdx])) {
				minIdx = i;
			}
		}

		Node node = new Node(inord[minIdx]);

		node.left = buildHelper(inord, map, si, minIdx - 1);
		node.right = buildHelper(inord, map, minIdx + 1, ei);

		return node;

	}

	// leetcode 979. Distribute Coins in Binary Tree.
	static class Pair6 {
		int nodes;
		int coins;
	}

	int moves = 0;

	public int distributeCoins(TreeNode root) {

		if (root == null) {
			return moves;
		}

		helperCoins(root);
		return moves;

	}

	public Pair6 helperCoins(TreeNode root) {
		if (root == null) {
			Pair6 my = new Pair6();
			my.nodes = 0;
			my.coins = 0;
			return my;
		}

		Pair6 lp = helperCoins(root.left); // it will return no of nodes and coins from left.
		Pair6 rp = helperCoins(root.right); // it will return no of nodes and coins from right.

		Pair6 my = new Pair6();
		my.nodes = lp.nodes + rp.nodes + 1;
		my.coins = lp.coins + rp.coins + root.val;

		moves += Math.abs(my.nodes - my.coins);

		return my;

	}

	// leetcode 297. Serialize and Deserialize Binary Tree
	static class Pair7 {
		int st;
		TreeNode node;
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		process(root, sb);
		return sb.toString();

	}

	public void process(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(".");
			sb.append(" ");
			return;
		}

		sb.append(root.val);
		sb.append(" ");
		process(root.left, sb);
		process(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		if (data.length() == 0) {
			return null;
		}

		String val[] = data.split(" ");

		TreeNode root = new TreeNode();
		root.val = (Integer.parseInt(val[0]));

		int id = 1;

		Stack<Pair7> stack = new Stack<>();
		Pair7 peek = new Pair7();
		peek.st = 1;
		peek.node = root;

		stack.push(peek);

		while (stack.size() > 0) {

			Pair7 pp = stack.peek();

			if (pp.st == 1) {

				if (val[id].equals(".") == false) {
					TreeNode nn = new TreeNode();
					nn.val = Integer.parseInt(val[id]);
					pp.node.left = nn;

					Pair7 p = new Pair7();
					p.st = 1;
					p.node = nn;
					stack.push(p);
				}

				pp.st++;
				id++;

			} else if (pp.st == 2) {

				if (val[id].equals(".") == false) {
					TreeNode nn = new TreeNode();
					nn.val = Integer.parseInt(val[id]);
					pp.node.right = nn;

					Pair7 p = new Pair7();
					p.st = 1;
					p.node = nn;
					stack.push(p);
				}

				pp.st++;
				id++;

			} else if (pp.st == 3) {
				stack.pop();
			}

		}

		return root;

	}

	// k-th smallest element in BST on gfg
	// using morris traversal.
	public int KthSmallestElement(Node root, int k) {
		// Write your code here

		Node curr = root;
		int c = 0;

		int kthSmallest = -1;

		while (curr != null) {

			if (curr.left == null) {

				c++;
				if (c == k) {
					return curr.val;
				}

				curr = curr.right;

			} else {

				Node iop = curr.left;

				while (iop.right != null && iop.right != curr) {
					iop = iop.right;
				}

				if (iop.right == null) {
					iop.right = curr;
					curr = curr.left;
				} else {

					c++;
					if (c == k) {
						return curr.val;
					}

					iop.right = null;
					curr = curr.right;

				}

			}

		}

		return kthSmallest;

	}

	// leetcode 687. Longest Univalue Path
	int m = 0;

	public int longestUnivaluePath(TreeNode root) {

		if (root == null) {
			return m;
		}

		longestUnivaluePathHelper(root);
		return m;
	}

	public int longestUnivaluePathHelper(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = longestUnivaluePathHelper(root.left); // it will return max univalue path from left side
		int right = longestUnivaluePathHelper(root.right); // it will return max univalue path from right side

		if (root.left != null && root.left.val == root.val) {
			left += 1;
		} else {
			left = 0;
		}

		if (root.right != null && root.right.val == root.val) {
			right += 1;
		} else {
			right = 0;
		}

		m = Math.max(m, (left + right));

		return Math.max(left, right);

	}

	// leetcode 1028. Recover a Tree From Preorder Traversal
	int i = 0;

	public TreeNode recoverFromPreorder(String traversal) {

		return preorder(traversal, 0);

	}

	public TreeNode preorder(String str, int depth) {

		int d = 0; // count of dashes.
		while (i + d < str.length() && str.charAt(i + d) == '-') {
			d++;
		}

		if (d != depth) {
			return null;
		}

		int nd = 0; // count of non-dashes.

		while (i + d + nd < str.length() && str.charAt(i + d + nd) != '-') {
			nd++;
		}

		int val = Integer.parseInt(str.substring(i + d, i + d + nd));
		i = i + d + nd;

		TreeNode root = new TreeNode(val);
		root.left = preorder(str, depth + 1);
		root.right = preorder(str, depth + 1);

		return root;

	}

	// leetcode 129. Sum Root to Leaf Numbers
	// This is best approach.
	int sum1 = 0;

	public int sumNumbers(TreeNode root) {

		if (root == null) {
			return sum1;
		}

		sumNumbersHelper(root, 0);
		return sum1;

	}

	public void sumNumbersHelper(TreeNode root, int val) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			int num = 10 * val + root.val;
			sum1 += num;

		}

		sumNumbersHelper(root.left, 10 * val + root.val);
		sumNumbersHelper(root.right, 10 * val + root.val);

	}

	// leetcode 129. Sum Root to Leaf Numbers
	// This is not better than first approach.
	int sum2 = 0;

	public int sumNumbers2(TreeNode root) {

		if (root == null) {
			return sum2;
		}

		sumNumbersHelper2(root, new StringBuilder());
		return sum2;

	}

	public void sumNumbersHelper2(TreeNode root, StringBuilder str) {

		if (root == null) {
			return;
		}

		str.append(root.val);

		if (root.left == null && root.right == null) {
			sum2 += Integer.parseInt(str.toString());
		}

		sumNumbersHelper2(root.left, str);
		sumNumbersHelper2(root.right, str);

		str.deleteCharAt(str.length() - 1);

	}

	// leetcode 662. Maximum Width of Binary Tree.
	static class Pair8 {
		long min;
		long max;
	}

	long maxW = 0;

	public int widthOfBinaryTree(TreeNode root) {
		HashMap<Integer, Pair8> map = new HashMap<>();
		maxW = 0;
		helper(root, 1, 1, map);
		return (int) maxW;
	}

	public void helper(TreeNode node, int level, long idx, HashMap<Integer, Pair8> map) {
		if (node == null) {
			return;
		}

		Pair8 p = null;

		if (map.containsKey(level)) {
			p = map.get(level);
			p.max = idx;
		} else {
			p = new Pair8();
			p.min = idx;
			p.max = idx;
			map.put(level, p);
		}

		long width = p.max - p.min + 1;
		if (width > maxW) {
			maxW = width;
		}

		helper(node.left, level + 1, 2 * idx, map);
		helper(node.right, level + 1, 2 * idx + 1, map);

	}

	// leecode 538. Convert BST to Greater Tree
	int sum3 = 0;

	public TreeNode convertBST(TreeNode root) {

		if (root == null) {
			return root;
		}

		convertBST(root.right);

		sum3 += root.val;

		root.val = sum3;

		convertBST(root.left);

		return root;

	}

	// leetcode 236. Lowest Common Ancestor of a Binary Tree.
	// we can also use the same approach we used for generic tree.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return root;
		}

		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		return (left != null ? left : right);

	}

	// leetcode 2096. Step-By-Step Directions From a Binary Tree Node to Another
	public String getDirections(TreeNode root, int startValue, int destValue) {

		ArrayList<TreeNode> left = nodeToRootPath(root, startValue);
		ArrayList<TreeNode> right = nodeToRootPath(root, destValue);

		int i = left.size() - 1;
		int j = right.size() - 1;

		while (i >= 0 && j >= 0) {
			if (left.get(i).val == right.get(j).val) {
				i--;
				j--;
			} else {
				break;
			}
		}

		i++;
		j++;

		// now i and j are at the point at which lca is there.

		StringBuilder sb = new StringBuilder();
		for (int k = 1; k <= i; k++) {
			sb.append("U");
		}

		for (int k = j; k > 0; k--) {
			if (right.get(k - 1) == right.get(k).left) {
				sb.append("L");
			} else {
				sb.append("R");
			}
		}

		return sb.toString();

	}

	public ArrayList<TreeNode> nodeToRootPath(TreeNode root, int p) {

		if (root == null) {
			return new ArrayList<TreeNode>();
		}

		if (root.val == p) {
			ArrayList<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			return list;
		}

		ArrayList<TreeNode> ll = nodeToRootPath(root.left, p);

		if (ll.size() > 0) {
			ll.add(root);
			return ll;
		}

		ArrayList<TreeNode> rl = nodeToRootPath(root.right, p);

		if (rl.size() > 0) {
			rl.add(root);
			return rl;
		}

		return new ArrayList<TreeNode>();

	}
}
