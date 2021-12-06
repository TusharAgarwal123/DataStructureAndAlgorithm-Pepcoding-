package com.ds.level1.LinkedList;

public class PepLinkedList {

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static class LinkedList {

		Node head;
		Node tail;
		int size;

		// O(n)
		public void display() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();

//			for (Node temp = head; temp != null; temp = temp.next) {
//				System.out.print(temp.data + " ");
//			}
//			System.out.print(temp.data + " ");

		}

		// O(1)
		public int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return head.data;
			}

		}

		// O(1)
		public int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return tail.data;
			}

		}

		// O(n)
		public int getAt(int idx) {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
				return -1;
			} else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
		}

		// O(n)
		public Node getAt2(int idx) {

			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;

		}

		// O(1)
		public void addFirst(int val) {
			Node node = new Node(val);
			if (size == 0) {
				head = tail = node;
			} else {
				node.next = head;
				head = node;
			}

			size++;
		}

		// O(1)
		public void addLast(int val) {
			Node node = new Node(val);
			if (size == 0) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = node;
			}

			size++;
		}

		// O(n)
		public void addAt(int val, int idx) {

			if (idx == 0) {
				addFirst(val);
			} else if (idx == size) {
				addLast(val);
			} else if (idx < 0 || idx > size) {
				System.out.println("Invalid arguments");
			} else {
				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}

				Node node = new Node(val);
				node.next = temp.next;
				temp.next = node;
				size++;
			}

		}

		// O(1)
		public void removeFirst() {
			if (size == 0) {
				System.out.println("Empty List");
			} else if (size == 1) {
				head = tail = null;
			} else {
				head = head.next;
			}
			size--;
		}

		// O(n)
		public void removeLast() {

			if (size == 0) {
				System.out.println("Empty List");
			} else if (size == 1) {
				head = tail = null;
			} else {
				Node temp = head;
				while (temp.next != tail) {
					temp = temp.next;
				}
				tail = temp;
				temp.next = null;
			}
			size--;

		}

		// O(n)
		public void removeAt(int idx) {
			if (size == 0) {
				System.out.println("Empty List");
			} else if (idx == 0) {
				removeFirst();
			} else if (idx == size - 1) {
				removeLast();
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid Arguments");
			} else {

				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}

				temp.next = temp.next.next;
				size--;

			}
		}

		// O(n)
		public int kthFromLast(int k) {
			Node fast = head;
			Node slow = head;

			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}

			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}

			return slow.data;

		}

		// O(n)
		// middle of linked list
		public int getMid() {

			Node fast = head;
			Node slow = head;

			// while (fast != tail && fast.next != tail) {
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			return slow.data;

		}

		// O(n^2)
		public void reverseIteratively() {

			int l = 0;
			int h = size - 1;
			while (l < h) {
				Node first = getAt2(l);
				Node second = getAt2(h);
				int temp = first.data;
				first.data = second.data;
				second.data = temp;
				l++;
				h--;
			}

		}

		// O(n)
		public void reversePointerIteratively() {
			Node pre = null;
			Node curr = head;
			Node next = null;
			while (curr != null) {
				next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			}

			// swapping head and tail
			Node temp = head;
			head = tail;
			tail = temp;
		}

		public LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2) {

			LinkedList list = new LinkedList();
			Node one = l1.head;
			Node two = l2.head;

			while (one != null && two != null) {
				if (one.data < two.data) {
					list.addLast(one.data);
					one = one.next;
				} else {
					list.addLast(two.data);
					two = two.next;
				}
			}

			while (one != null) {
				list.addLast(one.data);
				one = one.next;
			}

			while (two != null) {
				list.addLast(two.data);
				two = two.next;
			}

			return list;

		}

		public LinkedList mergeSort(Node head, Node tail) {
			if (head == tail) {
				LinkedList list = new LinkedList();
				list.addLast(head.data);
				return list;
			}

			Node mid = midNode(head, tail);
			Node midNext = mid.next;

			LinkedList fsl = mergeSort(head, mid);
			LinkedList ssl = mergeSort(mid.next, tail);

			LinkedList sl = mergeTwoSortedList(fsl, ssl);
			return sl;

		}

		public Node midNode(Node head, Node tail) {
			Node fast = head;
			Node slow = head;
			while (fast != tail && fast.next != tail) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}

	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.display();

		list.addLast(30);
		list.addLast(40);
		list.display();

		list.addAt(50, 2);
		list.addAt(60, 5);
		list.display();

		System.out.println(list.kthFromLast(2));
		System.out.println("Middle of list is: " + list.getMid());

		list.reverseIteratively();
		list.display();

		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(3));

		list.removeFirst();
		list.display();

		list.removeLast();
		list.display();

		list.removeAt(2);
		list.display();

		LinkedList newList = list.mergeSort(list.head, list.tail);
		newList.display();

	}

}
