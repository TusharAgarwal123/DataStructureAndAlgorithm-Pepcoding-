package com.ds.level1.Tree.binaryTree;

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

	public static void main(String[] args) {

		Integer ar[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
				null };

		Node root = construct(ar);
		// display(root);
		levelOrder(root);
		System.out.println();
		levelOrder2(root);

	}

}
