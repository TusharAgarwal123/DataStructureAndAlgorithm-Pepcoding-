
package com.ds.level1.Tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeDemo {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}
	}

	static class Pair {
		int state;
		Node node;
	}

	public static Node construct(Integer ar[]) {

		Stack<Pair> st = new Stack<>();
		Node root = new Node();
		root.data = ar[0];

		Pair rootP = new Pair();
		rootP.state = 1;
		rootP.node = root;

		st.push(rootP);
		int id = 1;

		while (st.size() > 0) {
			Pair peekP = st.peek();

			if (peekP.state == 1) { // left child
				if (ar[id] != null) {
					Node lc = new Node();
					lc.data = ar[id];
					peekP.node.left = lc;

					Pair lp = new Pair();
					lp.node = lc;
					lp.state = 1;
					st.push(lp);
				}
				peekP.state++;
				id++;

			} else if (peekP.state == 2) { // right child

				if (ar[id] != null) {
					Node rc = new Node();
					rc.data = ar[id];
					peekP.node.right = rc;

					Pair rp = new Pair();
					rp.node = rc;
					rp.state = 1;
					st.push(rp);
				}
				peekP.state++;
				id++;

			} else if (peekP.state == 3) {
				st.pop();
			}

		}

		return root;

	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "<-- " + node.data + " -->";
		String lstr = node.left == null ? "." : node.left.data + "";
		String rstr = node.right == null ? "." : node.right.data + "";

		System.out.println(lstr + str + rstr);

		display(node.left);
		display(node.right);
	}

	public static int size(Node node) {
		// write your code here

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

		// one line code.
		// return (node==null ? 0 : size(node.left)+size(node.right)+1);

	}

	public static int sum(Node node) {
		if (node == null) {
			return 0;
		}

		int lSum = sum(node.left);
		int rSum = sum(node.right);

		return lSum + rSum + node.data;

		// one line code.
		// return (node==null ? 0 : sum(node.left)+sum(node.right)+node.data);
	}

	public static int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lMax = max(node.left);
		int rMax = max(node.right);

		return Math.max(node.data, Math.max(lMax, rMax));

		// one line code.
		// return (node==null ? Integer.MIN_VALUE :
		// Math.max(node.data,Math.max(max(node.left),max(node.right))));

	}

	// height and depth are same.
	public static int height(Node node) {
		// write your code her

		if (node == null) {
			return -1; // on edges.
		}

		int lH = height(node.left);
		int rH = height(node.right);

		return Math.max(lH, rH) + 1;
	}

	public static void levelOrder(Node node) {
		// write your code here
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while (q.size() > 0) {

			int sz = q.size();

			while (sz-- > 0) {

				Node nd = q.remove();
				System.out.print(nd.data + " ");

				if (nd.left != null) {
					q.add(nd.left);
				}
				if (nd.right != null) {
					q.add(nd.right);
				}

			}
			System.out.println();

		}
	}

	public static void levelOrder2(Node node) {
		// write your code here
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		Queue<Node> cq = new LinkedList<>();
		q.add(node);
		while (q.size() > 0) {

			Node nd = q.remove();
			System.out.print(nd.data + " ");

			if (nd.left != null) {
				cq.add(nd.left);
			}
			if (nd.right != null) {
				cq.add(nd.right);
			}

			if (q.size() == 0) {
				q = cq;
				cq = new LinkedList<>();
				System.out.println();
			}

		}
	}

	public static void levelOrder3(Node node) {
		// write your code here
		if (node == null) {
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(node);
		q.add(null);
		while (q.size() > 0) {

			Node nd = q.remove();

			if (nd == null) {
				System.out.println();
				if (q.size() > 0) {
					q.add(null);
				}
				continue;
			}

			System.out.print(nd.data + " ");

			if (nd.left != null) {
				q.add(nd.left);
			}
			if (nd.right != null) {
				q.add(nd.right);
			}
		}
	}

	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	static String preOrder = "";
	static String inOrder = "";
	static String postOrder = "";

	public static void itrativePreInPostOrder(Node root) {

		if (root == null) {
			return;
		}

		Stack<Pair> st = new Stack<>();

		Pair pp = new Pair();
		pp.state = 1;
		pp.node = root;

		st.push(pp);

		while (st.size() > 0) {

			Pair peek = st.peek();
			if (peek.state == 1) {

				preOrder += peek.node.data + " ";
				peek.state++;

				if (peek.node.left != null) {
					Pair p = new Pair();
					p.state = 1;
					p.node = peek.node.left;
					st.push(p);
				}

			} else if (peek.state == 2) {

				inOrder += peek.node.data + " ";
				peek.state++;

				if (peek.node.right != null) {
					Pair p = new Pair();
					p.state = 1;
					p.node = peek.node.right;
					st.push(p);
				}

			} else if (peek.state == 3) {

				postOrder += peek.node.data + " ";
				st.pop();

			}

		}

	}

	public static boolean find(Node node, int data) {

		// write your code here
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean l = find(node.left, data);
		if (l == true) {
			return true;
		}
		boolean r = find(node.right, data);
		if (r == true) {
			return true;
		}

		return false;

	}

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		// write your code here

		if (node == null) {
			ArrayList<Integer> list = new ArrayList<>();
			return list;
		}

		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(data);
			return list;
		}

		ArrayList<Integer> l = nodeToRootPath(node.left, data);
		if (l.size() > 0) {

			l.add(node.data);
			return l;
		}
		ArrayList<Integer> r = nodeToRootPath(node.right, data);
		if (r.size() > 0) {

			r.add(node.data);
			return r;
		}

		return new ArrayList<Integer>();

	}

	public static void printKLevelsDown(Node node, int k) {
		// write your code here

		if (node == null || k < 0) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		printKLevelsDown(node.left, k - 1);
		printKLevelsDown(node.right, k - 1);

	}

	/*
	 * 1. You are given a partially written BinaryTree class. 2. You are given a
	 * value data and a value k. 3. You are required to complete the body of
	 * printKNodesFar function. The function is expected to print all nodes which
	 * are k distance away in any direction from node with value equal to data.
	 */
	public static void printKNodesFar(Node node, int data, int k) {
		// write your code here

		ArrayList<Node> rnPath = nodeToRootPath2(node, data);
		for (int i = 0; i < rnPath.size(); i++) {

			printKLevelsDown2(rnPath.get(i), k - i, i > 0 ? rnPath.get(i - 1) : null);

		}

	}

	public static ArrayList<Node> nodeToRootPath2(Node node, int data) {
		// write your code here

		if (node == null) {
			ArrayList<Node> list = new ArrayList<>();
			return list;
		}

		if (node.data == data) {
			ArrayList<Node> list = new ArrayList<>();
			list.add(node);
			return list;
		}

		ArrayList<Node> l = nodeToRootPath2(node.left, data);
		if (l.size() > 0) {

			l.add(node);
			return l;
		}
		ArrayList<Node> r = nodeToRootPath2(node.right, data);
		if (r.size() > 0) {

			r.add(node);
			return r;
		}

		return new ArrayList<Node>();

	}

	public static void printKLevelsDown2(Node node, int k, Node blocker) {
		// write your code here

		if (node == null || k < 0 || node == blocker) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		printKLevelsDown2(node.left, k - 1, blocker);
		printKLevelsDown2(node.right, k - 1, blocker);

	}

	/*
	 * 3. You are required to complete the body of pathToLeafFromRoot function. The
	 * function is expected to print all paths from root to leaves which have sum of
	 * nodes in range from lo to hi (both inclusive). The elements in path should be
	 * separated by spaces.
	 */
	public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
		// write your code here

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			sum += node.data;
			if (sum >= lo && sum <= hi) {
				System.out.println(path + node.data);
			}
			return;
		}

		pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
		pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);

	}

	/*
	 * 1. You are given a partially written BinaryTree class. 2. You are required to
	 * complete the body of createLeftCloneTree function. The function is expected
	 * to create a new node for every node equal in value to it and inserted between
	 * itself and it's left child. Check question video for clarity.
	 */
	public static Node createLeftCloneTree(Node node) {
		// write your code here

		if (node == null) {
			return node;
		}

		Node lcn = createLeftCloneTree(node.left);
		Node rcn = createLeftCloneTree(node.right);

		Node lcr = new Node();
		lcr.data = node.data;
		lcr.left = lcn;

		node.left = lcr;
		node.right = rcn; // need not to do it.

		return node;
	}

	/*
	 * 1. You are given a partially written BinaryTree class. 2. You are required to
	 * complete the body of transBackFromLeftClonedTree function. The function is
	 * expected to convert a left-cloned tree back to it's original form. The left
	 * cloned tree is dicussed in previous question. In a left-clone tree a new node
	 * for every node equal in value to it is inserted between itself and it's left
	 * child. For clarity check out the question video.
	 */
	public static Node transBackFromLeftClonedTree(Node node) {
		// write your code here

		if (node == null) {
			return null;
		}

		Node lnt = transBackFromLeftClonedTree(node.left.left);
		Node rnt = transBackFromLeftClonedTree(node.right);

		node.left = lnt;
		node.right = rnt; // need not to do it.

		return node;

	}

	/*
	 * 1. You are given a partially written BinaryTree class. 2. You are required to
	 * complete the body of printSingleChildNodes function. The function is expected
	 * to print in separate lines, all such nodes which are only child of their
	 * parent. Use preorder for traversal.
	 */

	// initially parent is passed null because for root node there is no parent.
	public static void printSingleChildNodes(Node node, Node parent) {
		// write your code here

		if (node == null) {
			return;
		}

		if (parent != null && parent.left == node && parent.right == null) {
			System.out.println(node.data);
		} else if (parent != null && parent.right == node && parent.left == null) {
			System.out.println(node.data);
		}

		printSingleChildNodes(node.left, node); // for left node parent will be node itself.
		printSingleChildNodes(node.right, node);

	}

	public static Node removeLeaves(Node node) {
		// write your code here

		if (node == null) {
			return null;
		}

		if (node.left == null && node.right == null) {
			return null;
		}

		node.left = removeLeaves(node.left);
		node.right = removeLeaves(node.right);

		return node;

	}

	// this is inefficient approach taking O(n^2) times.
	public static int diameter1(Node node) {
		// write your code here

		if (node == null) {
			return 0;
		}

		int ld = diameter1(node.left);
		int rd = diameter1(node.right);

		int md = height(node.left) + height(node.right) + 2;

		return Math.max(md, Math.max(ld, rd));

	}

	static class DiaPair {
		int ht;
		int dia;
	}

	// this is efficient approach taking O(n) times.
	// having faith that function will return the diameter and height of node.
	public static DiaPair diameter2(Node node) {

		if (node == null) {
			DiaPair bp = new DiaPair();
			bp.ht = -1;
			bp.dia = 0;
			return bp;
		}

		DiaPair lp = diameter2(node.left); // give the diameter and height of left side.
		DiaPair rp = diameter2(node.right);

		DiaPair mp = new DiaPair();

		mp.ht = Math.max(lp.ht, rp.ht) + 1;

		int fes = lp.ht + rp.ht + 2;

		mp.dia = Math.max(fes, Math.max(lp.dia, rp.dia));
		return mp;

	}

	// this is efficient approach taking O(n) times.
	// having faith that function will return the height of node.
	static int dia = 0;

	public static int diameter3(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = diameter3(node.left); // give the height of left side.
		int rh = diameter3(node.right); // give the height of right side.

		int ht = Math.max(lh, rh) + 1;

		if (lh + rh + 2 > dia) {
			dia = lh + rh + 2;
		}

		return ht;

	}

	/*
	 * 2. You are required to complete the body of tilt function. The function is
	 * expected to set the value of data member "tilt". "tilt" of a node is the
	 * absolute value of difference between sum of nodes in it's left subtree and
	 * right subtree. "tilt" of the whole tree is represented as the sum of "tilt"s
	 * of all it's nodes.
	 */
	static int tilt = 0;

	public static int tilt(Node node) {
		// write your code here to set the tilt data member

		if (node == null) {
			return 0;
		}

		int lt = tilt(node.left); // give the sum of left side.
		int rt = tilt(node.right); // give the sum of right side.

		int ct = Math.abs(lt - rt); // calculating tilt of current node.
		tilt += ct;

		return lt + rt + node.data;

	}

	static class TiltPair {
		int sum;
		int tl;
	}

	public static TiltPair tilt2(Node node) {

		if (node == null) {
			TiltPair pp = new TiltPair();
			pp.sum = 0;
			pp.tl = 0;
			return pp;
		}

		TiltPair l = tilt2(node.left);
		TiltPair r = tilt2(node.right);

		int myTilt = Math.abs(l.sum - r.sum);

		TiltPair myP = new TiltPair();
		myP.tl = myTilt + l.tl + r.tl;
		myP.sum = l.sum + r.sum + node.data;

		return myP;

	}

	static class BSTPair {
		boolean isBST;
		int min;
		int max;
	}

	public static BSTPair isBST(Node node) {

		if (node == null) {
			BSTPair bp = new BSTPair();
			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			return bp;
		}

		BSTPair lp = isBST(node.left);
		BSTPair rp = isBST(node.right);

		BSTPair mp = new BSTPair();

		mp.isBST = (lp.isBST && rp.isBST) && (node.data >= lp.max && node.data <= rp.min);

		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

		return mp;

	}

	static class BalancedPair {
		boolean isBal;
		int ht;
	}

	/*
	 * . You are required to check if the tree is balanced. A binary tree is
	 * balanced if for every node the gap between height's of it's left and right
	 * subtree is not more than 1.
	 */
	public static BalancedPair isBalanced(Node node) {

		if (node == null) {
			BalancedPair bp = new BalancedPair();
			bp.isBal = true;
			bp.ht = -1;
			return bp;
		}

		BalancedPair lp = isBalanced(node.left);
		BalancedPair rp = isBalanced(node.right);

		BalancedPair mp = new BalancedPair();
		mp.ht = Math.max(lp.ht, rp.ht) + 1;
		mp.isBal = (lp.isBal && rp.isBal) && (Math.abs(lp.ht - rp.ht) <= 1);

		return mp;

	}

	static boolean ans = true;

	public static int isBalanced2(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = isBalanced2(node.left);
		int rh = isBalanced2(node.right);

		if (Math.abs(lh - rh) > 1) {
			ans = false;
		}

		return Math.max(lh, rh) + 1;

	}

	/*
	 * 1. You are given a partially written BinaryTree class. 2. You are required to
	 * find the root of largest sub-tree which is a BST. Also, find the number of
	 * nodes in that sub-tree.
	 */
	static class BSTPair2 {
		boolean isBST;
		int min;
		int max;
		Node node; // it will contain the root of maximum bst subtree.
		int mNodeSize; // it will contain the size of maximum bst subtree.
	}

	public static BSTPair2 largestBSTSubTree(Node node) {

		if (node == null) {
			BSTPair2 bp = new BSTPair2();
			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.node = null;
			bp.mNodeSize = 0;
			return bp;
		}

		BSTPair2 lp = largestBSTSubTree(node.left);
		BSTPair2 rp = largestBSTSubTree(node.right);

		BSTPair2 mp = new BSTPair2();

		mp.isBST = (lp.isBST && rp.isBST) && (node.data >= lp.max && node.data <= rp.min);

		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

		if (mp.isBST == true) {
			mp.node = node;
			mp.mNodeSize = lp.mNodeSize + rp.mNodeSize + 1;
		} else if (lp.mNodeSize > rp.mNodeSize) {
			mp.node = lp.node;
			mp.mNodeSize = lp.mNodeSize;
		} else {
			mp.node = rp.node;
			mp.mNodeSize = rp.mNodeSize;
		}

		return mp;

	}

	public static void main(String[] args) {

		Integer ar[] = { 50, 25, 12, null, null, 37, 30, null, null, 40, null, null, 75, 62, 60, null, null, 70, null,
				null, 87, null, null };

		Node root = construct(ar);
		// display(root);
		levelOrder(root);
		System.out.println();
		levelOrder2(root);
		System.out.println();
		levelOrder3(root);
		System.out.println();

		pathToLeafFromRoot(root, "", 0, 150, 250);

	}

}
