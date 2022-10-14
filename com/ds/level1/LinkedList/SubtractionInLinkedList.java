package com.ds.level1.LinkedList;

//Subtraction in Linked List on gfg

public class SubtractionInLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static int getSize(Node n) {
		int sz = 0;

		while (n != null) {
			n = n.next;
			sz++;
		}

		return sz;
	}

	static Node padWithZeroes(Node n, int count) {
		for (int i = 1; i <= count; i++) {
			Node temp = new Node(0);
			temp.next = n;
			n = temp;
		}

		return n;
	}

	static Node stripLeadingZeroes(Node n) {

		while (n != null) {
			if (n.data != 0) {
				break;
			} else {
				n = n.next;
			}
		}

		if (n == null) {
			n = new Node(0);
		}

		return n;

	}

	static Node subLinkedList(Node l1, Node l2) {

		l1 = stripLeadingZeroes(l1);
		l2 = stripLeadingZeroes(l2);

		int s1 = getSize(l1);
		int s2 = getSize(l2);

		Node small = l1;
		Node large = l2;

		if (s1 < s2) {
			small = l1;
			large = l2;
			small = padWithZeroes(small, s2 - s1); // need not to add padding since we are revering the list.
		} else if (s2 < s1) {
			small = l2;
			large = l1;
			small = padWithZeroes(small, s1 - s2); // need not to add padding since we are revering the list.
		} else {
			Node t1 = l1;
			Node t2 = l2;

			while (t1 != null) {
				if (t1.data < t2.data) {
					small = l1;
					large = l2;
					break;
				} else if (t2.data < t1.data) {
					small = l2;
					large = l1;
					break;
				} else {
					t1 = t1.next;
					t2 = t2.next;
				}
			}
		}

		Node res = helper(large, small);

		res = stripLeadingZeroes(res);

		return res;

	}

	static Node helper(Node l1, Node l2) {
		// code here
		if (l2 == null) {
			return l1;
		}

		// add this case if it is mentioned that first list can be null.
//		if (l1 == null) {
//			l2.val = -l2.val;
//			return l2;
//		}

		Node c1 = reverseList(l1);
		Node c2 = reverseList(l2);

		Node head = new Node(-1);
		Node itr = head;
		int b = 0;

		while (c1 != null) {

			int diff = b + c1.data - (c2 != null ? c2.data : 0);

			if (diff < 0) {

				b = -1;
				diff += 10;

			} else {
				b = 0;
			}

			itr.next = new Node(diff);
			itr = itr.next;

			c1 = c1.next;
			if (c2 != null) {
				c2 = c2.next;
			}

		}

		return reverseList(head.next);
	}

	public static Node reverseList(Node head) {

		Node pre = null;
		Node curr = head;
		Node next = null;

		while (curr != null) {

			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;

		}

		return pre;

	}

}
