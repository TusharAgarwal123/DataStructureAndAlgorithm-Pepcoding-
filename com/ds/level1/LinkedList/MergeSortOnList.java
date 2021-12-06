package com.ds.level1.LinkedList;

public class MergeSortOnList {

	public static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	// you have given a head of two sorted list return the head final sorted list.
	public static Node mergeTwoSortedList(Node l1, Node l2) {

		Node node = new Node(-1);
		Node prev = node;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = new Node(l1.val);
				prev = prev.next;
				l1 = l1.next;
			} else {
				prev.next = new Node(l2.val);
				prev = prev.next;
				l2 = l2.next;
			}
		}

		while (l1 != null) {
			prev.next = new Node(l1.val);
			prev = prev.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			prev.next = new Node(l2.val);
			prev = prev.next;
			l2 = l2.next;
		}

		return node.next;

	}

	public static Node findMid(Node head, Node tail) {
		Node fast = head;
		Node slow = head;

		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public static Node findTail(Node head) {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	// we have given head of list we have to apply merge sort on it, as we haven't
	// given tail
	// so we will seperately find it.
	public static Node mergerSort(Node head) {

		Node tail = findTail(head);
		return mergeSort2(head, tail);

	}

	public static Node mergeSort2(Node head, Node tail) {
		if (head == tail) {
			Node node = new Node(head.val);
			return node;
		}

		Node mid = findMid(head, tail);
		Node midNext = mid.next;

		Node sl1 = mergeSort2(head, mid);
		Node sl2 = mergeSort2(midNext, tail);

		Node ml = mergeTwoSortedList(sl1, sl2);
		return ml;

	}

	public static void main(String[] args) {

	}

}
