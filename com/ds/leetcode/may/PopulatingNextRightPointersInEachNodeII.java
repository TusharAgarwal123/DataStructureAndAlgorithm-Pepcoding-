package com.ds.leetcode.may;

import java.util.LinkedList;
import java.util.Queue;

//117. Populating Next Right Pointers in Each Node II
public class PopulatingNextRightPointersInEachNodeII {
	
	

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
	}

	public Node connect(Node root) {

		if (root == null) {
			return null;
		}

		Queue<Node> q1 = new LinkedList<>();
		q1.add(root);

		while (!q1.isEmpty()) {

			int size = q1.size();

			for (int i = 1; i <= size; i++) {

				Node temp = q1.remove();

				if (i == size) {
					temp.next = null;
				} else {
					temp.next = q1.peek();
				}

				if (temp.left != null) {
					q1.add(temp.left);
				}

				if (temp.right != null) {
					q1.add(temp.right);
				}

			}

		}
		return root;

	}

//	public Node connect(Node root) {
//
//		if (root == null) {
//			return null;
//		}
//
//		Queue<Node> q1 = new LinkedList<>();
//		Queue<Node> q2 = new LinkedList<>();
//
//		q1.add(root);
//
//		while (!q1.isEmpty()) {
//			Node temp = q1.remove();
//			if (!q1.isEmpty()) {
//				temp.next = q1.peek();
//			} else {
//				temp.next = null;
//			}
//
//			if (temp.left != null) {
//				q2.add(temp.left);
//			}
//
//			if (temp.right != null) {
//				q2.add(temp.right);
//			}
//
//			if (q1.isEmpty()) {
//
//				Queue<Node> t = q1;
//				q1 = q2;
//				q2 = t;
//			}
//
//		}
//		return root;
//
//	}

}
