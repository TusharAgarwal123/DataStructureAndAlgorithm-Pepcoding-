package com.ds.level1.Tree.genericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GenericTreeDemo {

	public static class Node {
		int data;
		ArrayList<Node> childrens = new ArrayList<>(); // bhoonla mat

		Node(int data) {
			this.data = data;
		}
	}

	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data + " ");

			for (Node child : temp.childrens) {
				q.add(child);
			}
		}

		System.out.println(".");
	}

	public static void levelOrderLineWise(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 1; i <= size; i++) {
				Node temp = q.remove();
				System.out.print(temp.data + " ");

				for (Node child : temp.childrens) {
					q.add(child);
				}
			}
			System.out.println();
		}

	}

	public static void levelOrderLineWise2(Node root) {
		Queue<Node> q = new LinkedList<>();
		Queue<Node> cq = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data + " ");

			for (Node child : temp.childrens) {
				cq.add(child);
			}

			if (q.isEmpty()) {
				q = cq;
				cq = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public static void levelOrderLineWiseZigZag(Node root) {

		LinkedList<Node> queue = new LinkedList<>(); // treating it as queue.
		LinkedList<Node> stack = new LinkedList<>(); // treating it as stack.

		queue.addLast(root);

		int l = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {
				Node node = queue.removeFirst();
				System.out.print(node.data + " ");

				if (l % 2 == 0) {
					for (int i = 0; i < node.childrens.size(); i++) {
						stack.addFirst(node.childrens.get(i));
					}
				} else {
					for (int i = node.childrens.size() - 1; i >= 0; i--) {
						stack.addFirst(node.childrens.get(i));
					}
				}

			}

			System.out.println();
			l++;
			LinkedList<Node> temp = queue;
			queue = stack;
			stack = temp;
		}

	}

	// another approach
	public static void levelOrderLineWiseZigZag2(Node root) {

		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();

		queue.add(root);

		int l = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			while (size-- > 0) {
				Node node = queue.remove();
				System.out.print(node.data + " ");

				if (l % 2 == 0) {
					for (int i = 0; i < node.childrens.size(); i++) {
						stack.push(node.childrens.get(i));
					}
				} else {
					for (int i = node.childrens.size() - 1; i >= 0; i--) {
						stack.push(node.childrens.get(i));
					}
				}

			}

			System.out.println();
			l++;
			while (stack.size() > 0) {
				queue.add(stack.pop());
			}
		}

	}

	// another approach
	public static void levelOrderLineWiseZigZag3(Node root) {

		Stack<Node> s = new Stack<>();
		Stack<Node> cs = new Stack<>();

		s.push(root);

		int l = 0;

		while (!s.isEmpty()) {

			Node node = s.pop();
			System.out.print(node.data + " ");

			if (l % 2 == 0) {
				for (int i = 0; i < node.childrens.size(); i++) {
					cs.push(node.childrens.get(i));
				}
			} else {
				for (int i = node.childrens.size() - 1; i >= 0; i--) {
					cs.push(node.childrens.get(i));
				}
			}

			if (s.isEmpty()) {
				s = cs;
				cs = new Stack<Node>();
				System.out.println();
				l++;
			}

		}

	}

	public static Node constructTree(int ar[]) {

		Node root = null;
		Stack<Node> st = new Stack<>();

		for (int x : ar) {
			if (x != -1) {
				Node node = new Node(x);
				st.push(node);
			} else {
				Node node = st.pop();

				if (st.size() > 0) {
					Node parent = st.peek();
					parent.childrens.add(node);
				} else {
					root = node;
				}
			}
		}

		return root;

	}

	// traversal in preorder-postorder
	public static void traversals(Node node) {
		// write your code here

		System.out.println("Node Pre " + node.data);

		for (Node ch : node.childrens) {
			System.out.println("Edge Pre " + node.data + "--" + ch.data);
			traversals(ch);
			System.out.println("Edge Post " + node.data + "--" + ch.data);

		}

		System.out.println("Node Post " + node.data);

	}

	/*
	 * expectation d(10)=> it will print 10 and it's family. faith d(20),d(30),d(40)
	 * will print themself and their family.
	 */

	public static void display(Node root) {

		String str = root.data + " -->";
		for (Node ch : root.childrens) {
			str += ch.data + ",";
		}
		str += ".";
		System.out.println(str);

		for (Node ch : root.childrens) {
			display(ch);
		}

	}

	public static int size(Node node) {
		int sz = 0;
		for (Node ch : node.childrens) {
			sz = sz + size(ch);
		}
		return sz + 1;
	}

	public static int maximum(Node node) {
		int maxChild = node.data;

		for (Node ch : node.childrens) {
			int recAns = maximum(ch);
			maxChild = Math.max(recAns, maxChild);
		}
		return maxChild;
	}

	public static int minimum(Node node) {
		int minChild = node.data;

		for (Node ch : node.childrens) {
			int recAns = minimum(ch);
			minChild = Math.min(recAns, minChild);
		}
		return minChild;
	}

	public static int height(Node node) {

		int h = -1; // in terms of edges.
		for (Node ch : node.childrens) {

			int childH = height(ch);
			h = Math.max(childH, h);

		}

		return h + 1;

	}

	// you have a root of tree you have to fill the arraylist with the data of tree.
	public static void serialize(Node root, ArrayList<Integer> list) {
		list.add(root.data);
		for (Node ch : root.childrens) {
			serialize(ch, list);
		}
		list.add(-1);
	}

	/*
	 * 1. You are given a partially written GenericTree class. 2. You are required
	 * to complete the body of mirror function. The function is expected to create a
	 * mirror image of the tree.
	 */

	// O(n)
	public static void mirror(Node node) {

		for (Node ch : node.childrens) {
			mirror(ch);
		}

		Collections.reverse(node.childrens);

		// reverse by yourself.
//	      int li=0;
//	      int ri=node.childrens.size()-1;
//
//	      while(li<ri){
//	          Node left=node.childrens.get(li);
//	          Node right=node.childrens.get(ri);
//
//	          node.childrens.set(li,right);
//	           node.childrens.set(ri,left);
//	           li++;
//	           ri--;
//	      }

	}

	public static void removeLeaves(Node node) {

		// remvoing my leaves.
		for (int i = node.childrens.size() - 1; i >= 0; i--) {
			Node ch = node.childrens.get(i);
			if (ch.childrens.size() == 0) {
				node.childrens.remove(i);
			}
		}

		// request the childrens to remove their leaves.
		for (Node ch : node.childrens) {
			removeLeaves(ch);
		}

	}

	/*
	 * 1. You are given a partially written GenericTree class. 2. You are required
	 * to complete the body of linearize function. The function is expected to
	 * create a linear tree i.e. every node will have a single child only. For
	 * details check the question video. 3. Input and Output is managed for you.
	 */

	// O(n^2).
	public static void linearize(Node node) {

		// assuming all child of root will linearize themself.
		for (Node ch : node.childrens) {
			linearize(ch);
		}

		while (node.childrens.size() > 1) {

			Node last = node.childrens.remove(node.childrens.size() - 1);
			Node secondLast = node.childrens.get(node.childrens.size() - 1);
			Node secondLastKiTail = findTail(secondLast);
			secondLastKiTail.childrens.add(last);

		}

	}

	// best approach O(n).
	// we will have faith that if we call l(10) so 10 will linearize themself and
	// return tail.
	public static Node linearize2(Node node) {

		if (node.childrens.size() == 0) {
			return node;
		}

		Node lastKiTail = linearize2(node.childrens.get(node.childrens.size() - 1));

		while (node.childrens.size() > 1) {

			Node last = node.childrens.remove(node.childrens.size() - 1);
			Node secondLast = node.childrens.get(node.childrens.size() - 1);

			Node secondLastKiTail = linearize2(secondLast);
			secondLastKiTail.childrens.add(last);

		}

		return lastKiTail;

	}

	public static Node findTail(Node node) {

		while (node.childrens.size() > 0) {
			node = node.childrens.get(0);
		}
		return node;

	}

	// you have to check weather data is present in tree or not.
	public static boolean find(Node node, int data) {
		// write your code here

		if (node.data == data) {
			return true;
		}

		for (Node ch : node.childrens) {
			boolean res = find(ch, data);
			if (res == true) {
				return true;
			}
		}

		return false;
	}

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		// write your code here

		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(data);
			return list;
		}

		for (Node ch : node.childrens) {
			ArrayList<Integer> ans = nodeToRootPath(ch, data);
			// if any child will find that node then list size will be
			// greater than 0.
			if (ans.size() > 0) {
				ans.add(node.data);
				return ans;
			}
		}

		return new ArrayList<Integer>();

	}

	public static int lca(Node node, int d1, int d2) {

		// optional
//		if (node.data == d1 || node.data == d2) {
//			return node.data;
//		}

		ArrayList<Integer> f = nodeToRootPath(node, d1);
		ArrayList<Integer> s = nodeToRootPath(node, d2);

		int i = f.size() - 1;
		int j = s.size() - 1;

		while (i >= 0 && j >= 0) {
			if (f.get(i) == s.get(j)) {
				i--;
				j--;

			} else {
				break;
			}

		}

		return f.get(i + 1);

	}

	/*
	 * 1. You are given a partially written GenericTree class. 2. You are required
	 * to complete the body of distanceBetweenNodes function. The function is
	 * expected to return the distance (in terms of number of edges) between two
	 * nodes in a generic tree. Please watch the question video to understand what
	 * lca is.
	 */
	public static int distanceBetweenNodes(Node node, int d1, int d2) {
		// write your code here

		ArrayList<Integer> p1 = nodeToRootPath(node, d1);
		ArrayList<Integer> p2 = nodeToRootPath(node, d2);

		int i = p1.size() - 1;
		int j = p2.size() - 1;

		while (i >= 0 && j >= 0) {

			if (p1.get(i) == p2.get(j)) {
				i--;
				j--;
			} else {
				break;
			}

		}

		i++;
		j++;

		return i + j;

	}

	/*
	 * 1. You are given a partially written GenericTree class. 2. You are required
	 * to complete the body of areSimilar function. The function is expected to
	 * check if the two trees passed to it are similar in shape or not.
	 */
	public static boolean areSimilar(Node n1, Node n2) {
		// write your code here

		if (n1.childrens.size() != n2.childrens.size()) {
			return false;
		}

		for (int i = 0; i < n1.childrens.size(); i++) {

			Node c1 = n1.childrens.get(i);
			Node c2 = n2.childrens.get(i);

			if (areSimilar(c1, c2) == false) {
				return false;
			}

		}

		return true;

	}

	/*
	 * 1. You are given a partially written GenericTree class. 2. You are required
	 * to complete the body of areMirror function. The function is expected to check
	 * if the two trees passed to it are mirror images of each other in shape (data
	 * not to be checked, just the shape of tree).
	 */
	public static boolean areMirror(Node n1, Node n2) {
		// write your code here

		if (n1.childrens.size() != n2.childrens.size()) {
			return false;
		}

		for (int i = 0, j = n2.childrens.size() - 1; i < n1.childrens.size() && j >= 0; i++, j--) {

			Node c1 = n1.childrens.get(i);
			Node c2 = n2.childrens.get(j);

			if (areMirror(c1, c2) == false) {
				return false;
			}

		}

		return true;

	}

	// symmetric means mirror image of itself.
	public static boolean IsSymmetric(Node node) {
		// write your code here

		// we have to only check both are mirror image of itself or not.
		return areMirror(node, node);

	}

	static Node predecessor;
	static Node successor;
	static int state = 0;

	public static void predecessorAndSuccessor(Node node, int data) {
		// write your code here

		if (state == 0) {
			if (node.data == data) {
				state = 1;
			} else {
				predecessor = node;
			}
		} else if (state == 1) {
			successor = node;
			state++;
		}

		for (Node ch : node.childrens) {
			predecessorAndSuccessor(ch, data);
		}

	}

	// we can also put these 4 variable in another class and then access these using
	// object
	// of class.
	static int sum = 0;
	static int h = -1;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void multiSolver(Node node, int depth) {

		sum += node.data;

		if (node.data > max) {
			max = node.data;
		}

		if (node.data < min) {
			min = node.data;
		}

		if (depth > h) {
			h = depth;
		}

		for (Node ch : node.childrens) {
			multiSolver(ch, depth + 1);
		}

	}

	static int largest = Integer.MIN_VALUE;
	static int sLargest = Integer.MAX_VALUE;

	public static void secondLargest(Node node) {

		if (node.data >= largest) {
			sLargest = largest;
			largest = node.data;
		} else if (node.data > sLargest) {
			sLargest = node.data;
		}

		for (Node ch : node.childrens) {
			secondLargest(ch);
		}

	}

	static int ceil = Integer.MAX_VALUE; // because it is a min(of the largest element)
	static int floor = Integer.MIN_VALUE; // because it is a max(of the smallest element)

	public static void ceilAndFloor(Node node, int data) {

		if (node.data < data) { // valid for floor
			if (node.data > floor) {
				floor = node.data;
			}
		} else if (node.data > data) { // valid for ceil

			if (node.data < ceil) {
				ceil = node.data;
			}
		}

		for (Node ch : node.childrens) {
			ceilAndFloor(ch, data);
		}

	}

	// return the kth largest from the tree.
	public static int kthLargest(Node node, int k) {

		int kl = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			ceilAndFloor(node, kl);
			kl = floor;
			floor = Integer.MIN_VALUE; // very important to do.
		}

		return kl;

	}

	public static void main(String[] args) {
//		Node root = new Node(10);
//
//		Node twenty = new Node(20);
//		root.childrens.add(twenty);
//
//		Node thirty = new Node(30);
//		root.childrens.add(thirty);
//
//		Node fourty = new Node(40);
//		root.childrens.add(fourty);
//
//		Node fifty = new Node(50);
//		twenty.childrens.add(fifty);
//
//		Node sixty = new Node(60);
//		twenty.childrens.add(sixty);
//
//		Node seventy = new Node(70);
//		thirty.childrens.add(seventy);
//
//		Node eigthty = new Node(80);
//		thirty.childrens.add(eigthty);
//
//		Node ninety = new Node(90);
//		thirty.childrens.add(ninety);
//
//		Node houndred = new Node(100);
//		fourty.childrens.add(houndred);
//
//		// levelOrder(root);
//		levelOrderLineWise2(root);
//
//		System.out.println("***************");
//
//		levelOrderLineWiseZigZag(root);

		int ar[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };

		Node root = constructTree(ar);

		levelOrderLineWise(root);

		System.out.println("*****************");

		levelOrderLineWiseZigZag3(root);

		display(root);

		System.out.println(find(root, 130));
		System.out.println(nodeToRootPath(root, 120));
		System.out.println(lca(root, 70, 120));

		// multiSolver(root, 0);

		secondLargest(root);
		System.out.println(sLargest);

		ceilAndFloor(root, 70);
		System.out.println(ceil + "  " + floor);
		System.out.println(kthLargest(root, 3));
//
//		levelOrderLineWiseZigZag2(root);
//
//		System.out.println("Size is " + size(root));
//		System.out.println("Maximum is " + maximum(root));
//		System.out.println("Minimum is " + minimum(root));
//		System.out.println("height is " + height(root));
//
//		levelOrderLineWiseZigZag(root);
//
//		System.out.println("*****************");

		// traversals(root);

//		ArrayList<Integer> list = new ArrayList<Integer>();
//		serialize(root, list);
//		System.out.println(list);

	}

}
