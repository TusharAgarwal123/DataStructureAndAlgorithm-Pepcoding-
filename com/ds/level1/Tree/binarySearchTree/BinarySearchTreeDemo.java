package com.ds.level1.Tree.binarySearchTree;

public class BinarySearchTreeDemo {

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

	/*
	 * . You are given a partially written BST class. 2. You are required to
	 * complete the body of add function. "add" function is expected to add a new
	 * node with given data to the tree and return the new root.
	 */
	public static Node add(Node node, int data) {
		// write your code here
		if (node == null) {
			Node nd = new Node();
			nd.data = data;
			return nd;
		}

		if (data > node.data) {
			node.right = add(node.right, data);
		} else if (data < node.data) {
			node.left = add(node.left, data);
		}

		return node;

	}

	public static Node construct(int ar[], int l, int h) {

		if (l > h) {
			return null;
		}

		int mid = (l + h) / 2;
		Node node = new Node(ar[mid]);

		node.left = construct(ar, l, mid - 1);
		node.right = construct(ar, mid + 1, h);

		return node;

	}

	public static int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

	}

	public static int sum(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;
	}

	// it will take O(h).
	// as we are working on data.
	public static int max(Node node) {

		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}

	}

	public static int min(Node node) {

		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}

	}

	// it will take O(h).
	// as we are working on data.
	public static boolean find(Node node, int data) {

		if (node == null) {
			return false;
		}

		if (data > node.data) {
			return find(node.right, data);
		} else if (data < node.data) {
			return find(node.left, data);
		} else {
			return true;
		}

	}

	/*
	 * 1. You are given a partially written BST class. 2. You are required to
	 * complete the body of rwsol function. "rwsol" function is expected to replace
	 * a node's value with sum of all nodes greater than it.
	 */

	// basically we are traversing inorder in reverse.
	static int sum = 0;

	public static void rwsol(Node node) {
		// write your code here
		if (node == null) {
			return;
		}
		rwsol(node.right);
		int osum = sum;
		sum += node.data;
		node.data = osum;

		// int val=node.data;
		// if(sum==0){

		// node.data=0;

		// }
		// node.data=sum;
		// sum=sum+val;

		rwsol(node.left);

	}

	/*
	 * 1. You are given a partially written BST class. 2. You are required to
	 * complete the body of pir function. "pir" function is expected to print all
	 * nodes between d1 and d2 (inclusive and in increasing order).
	 */
	// we are travelling in inorder traversal.
	// bcoz answer is given in this order.
	// O(n)
	public static void pir(Node node, int d1, int d2) {

		if (node == null) {
			return;
		}

		pir(node.left, d1, d2);
		if (d1 <= node.data && d2 >= node.data) {
			System.out.println(node.data);

		}
		pir(node.right, d1, d2);

	}

	// O(h)
	public static void pir2(Node node, int d1, int d2) {

		if (node == null) {
			return;
		}

		if (node.data < d1 && node.data < d2) {
			pir2(node.right, d1, d2);
		} else if (node.data > d1 && node.data > d2) {
			pir2(node.left, d1, d2);
		} else { // in between.
			pir2(node.left, d1, d2);
			System.out.println(node.data);
			pir2(node.right, d1, d2);
		}

	}

	// O(h).
	public static int lca(Node node, int d1, int d2) {

		if (node.data < d1 && node.data < d2) {
			return lca(node.right, d1, d2);
		} else if (node.data > d1 && node.data > d2) {
			return lca(node.left, d1, d2);
		} else {
			return node.data;
		}
	}

	/*
	 * 1. You are given a partially written BST class. 2. You are given a value. You
	 * are required to print all pair of nodes which add up to the given value. Make
	 * sure all pairs print the smaller value first and avoid duplicacies. Make sure
	 * to print the pairs in increasing order.
	 */
	// we have to print pairs in increasing order that's why we are traversing
	// inOrder.

	// O(nlogn).
	// find is taking O(h), which is logn.
	public static void targetSumPair(Node root, Node node, int data) {

		if (node == null) {
			return;
		}

		targetSumPair(root, node.left, data);

		int tar = data - node.data;
		if (node.data < tar) {
			if (find(root, tar) == true) {
				System.out.println(node.data + " " + tar);
			}
		}

		targetSumPair(root, node.right, data);

	}

	public static void main(String[] args) {

		int ar[] = { 10, 12, 14, 16, 18, 20, 22, 24, 28, 30 };
		Node root = construct(ar, 0, ar.length - 1);

	}

}
