package com.ds.level1.LinkedList;

import java.util.HashMap;

public class LeetCodeQuestions {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode random;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode middleNode_leetcode(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode middleNode(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode forw = curr.next; // backup

			curr.next = prev; // linkup

			prev = curr; // move
			curr = forw;
		}

		return prev;
	}

	// 143
	// same as fold of linked list.
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode midNode = middleNode(head);
		ListNode nHead = midNode.next;
		midNode.next = null;

		nHead = reverseList(nHead);

		ListNode c1 = head, c2 = nHead;
		while (c2 != null) { // c1!=null
			ListNode f1 = c1.next, f2 = c2.next; // backup

			c1.next = c2; // linkup
			c2.next = f1;

			c1 = f1;
			c2 = f2;
		}
	}

	// in this question you have given a linkedlist, you have to unfold it.
	public void unFold(ListNode head) {

		if (head == null || head.next == null) {
			return;
		}

		ListNode fh = head;
		ListNode fp = head;
		ListNode sh = head.next;
		ListNode sp = head.next;

		while (sp != null && sp.next != null) {

			ListNode forward = sp.next;
			fp.next = forward;
			sp.next = forward.next;

			fp = fp.next;
			sp = sp.next;

			// or you can also write it like that.
//			fp = forward;
//			sp = forward.next;

		}

		fp.next = null;

		sh = reverseList(sh);

		fp.next = sh;

	}

	// leetcode 23.
	// O(n^2)
	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		}

		ListNode ans = null;
		for (ListNode head : lists) {
			ans = mergeTwoSortedList(head, ans);
		}

		return ans;

	}

	// leetcode 23.
	// optimize approach
	// O(nlogn)
	public ListNode mergeKLists2(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		}

//         ListNode ans=null;
//         for(ListNode head:lists){
//             ans=mergeTwoLists(head,ans);
//         }

//         return ans;

		return mergeKlistHelper(lists, 0, lists.length - 1);

	}

	// applying merge sort approach on list of array.
	public ListNode mergeKlistHelper(ListNode[] list, int si, int ei) {

		if (si == ei) {
			return list[si];
		}

		int mid = (si + ei) / 2;

		ListNode l1 = mergeKlistHelper(list, si, mid);
		ListNode l2 = mergeKlistHelper(list, mid + 1, ei);

		return mergeTwoSortedList(l1, l2);

	}

	// leetcode 21.
	public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) {
			return l1 != null ? l1 : l2;
		}

		ListNode node = new ListNode(-1);
		ListNode prev = node;
		ListNode c1 = l1;
		ListNode c2 = l2;

		while (c1 != null && c2 != null) {
			if (c1.val < c2.val) {
				prev.next = c1;
				prev = prev.next;
				c1 = c1.next;
			} else {
				prev.next = c2;
				prev = prev.next;
				c2 = c2.next;
			}
		}

		prev.next = (c1 != null ? c1 : c2);

		ListNode head = node.next;
		node.next = null;

		return head;

	}

	// adding two list.
	// leetcode 2.
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode node = new ListNode(-1);
		ListNode prev = node;

		ListNode c1 = l1;
		ListNode c2 = l2;

		int c = 0;
		while (c1 != null && c2 != null) {

			int data = c1.val + c2.val + c;
			int nData = data % 10;

			c = data / 10;

			prev.next = new ListNode(nData);
			prev = prev.next;
			c1 = c1.next;
			c2 = c2.next;

		}

		while (c1 != null) {
			int data = c1.val + c;
			int nData = data % 10;

			c = data / 10;

			prev.next = new ListNode(nData);
			prev = prev.next;
			c1 = c1.next;

		}

		while (c2 != null) {
			int data = c2.val + c;
			int nData = data % 10;

			c = data / 10;

			prev.next = new ListNode(nData);
			prev = prev.next;
			c2 = c2.next;
		}

		if (c > 0) {
			prev.next = new ListNode(c);
			prev = prev.next;
		}

		ListNode nHead = node.next;
		node.next = null;
		return nHead;

	}

	// leetcode 24.
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode temp = head;

		while (temp != null && temp.next != null) {

			int data = temp.val;
			temp.val = temp.next.val;
			temp.next.val = data;

			temp = temp.next.next;

		}

		return head;

	}

	// leetcode 25. Reverse Nodes in k-Group
	ListNode th = null;
	ListNode tt = null;
	ListNode oh = null;
	ListNode ot = null;

	public void addFirst(ListNode node) {
		if (th == null) {
			th = node;
			tt = node;
		} else {
			node.next = th;
			th = node;
		}
	}

	public int getSize(ListNode head) {
		int c = 0;
		ListNode temp = head;

		while (temp != null) {
			temp = temp.next;
			c++;
		}
		return c;
	}

	public ListNode reverseKGroup(ListNode head, int k) {

		int len = getSize(head);
		ListNode curr = head;

		while (len >= k) {

			int temp = k;
			while (temp-- > 0) {
				ListNode nextNode = curr.next;
				curr.next = null;
				addFirst(curr);
				curr = nextNode;
			}

			if (oh == null) {
				oh = th;
				ot = tt;
			} else {
				ot.next = th;
				ot = tt;
			}

			th = null;
			tt = null;

			len = len - k;

		}

		ot.next = curr;
		return oh;

	}

	// leetcode 83. Remove Duplicates from Sorted List
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode temp = head;

		while (temp.next != null) {

			if (temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}

		}

		return head;

	}

	// leetcode 160. Intersection of Two Linked Lists
	// using difference method.
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int size1 = getSize(headA);
		int size2 = getSize(headB);

		int diff = Math.abs(size1 - size2);

		if (size1 > size2) {
			for (int i = 0; i < diff; i++) {
				headA = headA.next;
			}
		} else if (size2 > size1) {
			for (int i = 0; i < diff; i++) {
				headB = headB.next;
			}
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;

	}

	// leetcode 160. Intersection of Two Linked Lists
	// using flloyd cycle method.
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		ListNode tail = findTail(headA);

		tail.next = headB;

		ListNode ans = detectCycle(headA);

		// modifying list as it was before.
		tail.next = null;

		return ans;

	}

	public ListNode findTail(ListNode head) {
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	// leetode 234. Palindrome Linked List
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode mid = middleNode(head);
		ListNode nHead = mid.next;
		mid.next = null;
		nHead = reverseList(nHead);

		ListNode c1 = head;
		ListNode c2 = nHead;

		boolean res = true;

		while (c2 != null) {

			if (c1.val != c2.val) {
				res = false;
				break;
			}

			c1 = c1.next;
			c2 = c2.next;

		}

		// re-creating the list as it was given to us.
		nHead = reverseList(nHead);
		mid.next = nHead;

		return res;

	}

	// leetcode 2095. Delete the Middle Node of a Linked List

	public ListNode deleteMiddle(ListNode head) {

		// if linkedlist is of 1 size delete that node also.
		if (head == null || head.next == null) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = null;

		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		pre.next = slow.next;
		return head;

	}

	// leetcode 92. Reverse Linked List II

	/*
	 * Given the head of a singly linked list and two integers left and right where
	 * left <= right, reverse the nodes of the list from position left to position
	 * right, and return the reversed list.
	 */

	public ListNode reverseBetween(ListNode head, int left, int right) {

		while (left < right) {

			ListNode leftNode = getAt(left, head);
			ListNode rightNode = getAt(right, head);

			int temp = leftNode.val;
			leftNode.val = rightNode.val;
			rightNode.val = temp;

			left++;
			right--;

		}

		return head;

	}

	public ListNode getAt(int idx, ListNode head) {

		ListNode temp = head;
		for (int i = 0; i < idx - 1; i++) {
			temp = temp.next;
		}

		return temp;

	}

	// merge sort on linkedlist.
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = middleNode(head);
		ListNode nHead = mid.next;
		mid.next = null;

		ListNode l1 = mergeSort(head);
		ListNode l2 = mergeSort(nHead);

		return mergeTwoSortedList(l1, l2);
	}

	// leetcode 328. Odd Even Linked List

	/*
	 * Given the head of a singly linked list, group all the nodes with odd indices
	 * together followed by the nodes with even indices, and return the reordered
	 * list.
	 * 
	 * The first node is considered odd, and the second node is even, and so on.
	 * 
	 * Note that the relative order inside both the even and odd groups should
	 * remain as it was in the input.
	 * 
	 * You must solve the problem in O(1) extra space complexity and O(n) time
	 * complexity.
	 */
	public ListNode oddEvenList(ListNode head) {

		if (head == null || head.next == null)

		{
			return head;
		}

		ListNode dummyEven = new ListNode(-1);
		ListNode dummyOdd = new ListNode(-1);
		ListNode evenTail = dummyEven;
		ListNode oddTail = dummyOdd;

		ListNode curr = head;
		int c = 1;

		while (curr != null) {
			if (c % 2 == 0) {
				evenTail.next = curr;
				evenTail = evenTail.next;
			} else {
				oddTail.next = curr;
				oddTail = oddTail.next;
			}
			curr = curr.next;
			c++;
		}

		oddTail.next = dummyEven.next;

		evenTail.next = null; // it is very important to do.

		return dummyOdd.next;
	}

	// all even should come first then all odd and maintain their occurance
	public ListNode segregateEvenOdd(ListNode head) {

		if (head == null || head.next == null)

		{
			return head;
		}

		ListNode dummyEven = new ListNode(-1);
		ListNode dummyOdd = new ListNode(-1);
		ListNode evenTail = dummyEven;
		ListNode oddTail = dummyOdd;

		ListNode curr = head;
		while (curr != null) {
			if (curr.val % 2 == 0) {
				evenTail.next = curr;
				evenTail = evenTail.next;
			} else {
				oddTail.next = curr;
				oddTail = oddTail.next;
			}
			curr = curr.next;
		}

		evenTail.next = dummyOdd.next;
		oddTail.next = null; // it is very important to do.
		return dummyEven.next;
	}

	// leetcode 138. Copy List with Random Pointer
	// this approach is using space.

	public ListNode copyRandomList(ListNode head) {

		HashMap<ListNode, ListNode> map = new HashMap<>();

		ListNode deep = new ListNode(-1);
		ListNode prev = deep;

		ListNode temp = head;
		while (temp != null) {

			prev.next = new ListNode(temp.val);
			prev = prev.next;
			map.put(temp, prev);
			temp = temp.next;

		}

		temp = head;

		while (temp != null) {

			ListNode copyNode = map.get(temp);
			copyNode.random = map.get(temp.random);
			temp = temp.next;

		}

		ListNode nHead = deep.next;
		deep.next = null;
		return nHead;

	}

	// leetcode 138. Copy List with Random Pointer
	// this approach is not using space.

	public ListNode copyRandomList2(ListNode head) {

		copyList(head);
		copyRandomPointer(head);

		// extract deep copy

		ListNode node = new ListNode(-1);
		ListNode prev = node;

		ListNode temp = head;
		while (temp != null) {
			prev.next = temp.next;
			prev = prev.next;
			temp.next = temp.next.next;
			temp = temp.next;
		}

		ListNode nHead = node.next;
		node.next = null;
		return nHead;

	}

	public void copyList(ListNode head) {

		ListNode temp = head;
		while (temp != null) {

			ListNode forward = temp.next;
			ListNode node = new ListNode(temp.val);
			temp.next = node;
			node.next = forward;
			temp = forward;

		}

	}

	public void copyRandomPointer(ListNode head) {

		ListNode temp = head;
		while (temp != null) {

			ListNode ran = temp.random;
			if (ran != null) {
				temp.next.random = ran.next;
			}

			temp = temp.next.next;

		}

	}

	// leetcode 141. Linked List Cycle
	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;

	}

	// leetcode 142. Linked List Cycle II
	// this will find the cyclic point in linkedlist

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		// if cycle is not present then there will be no cyclic point.
		if (slow != fast) {
			return null;
		}

		slow = head;

		// they will meet on cyclic point.
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;

	}

	// leetcode 19. Remove Nth Node From End of List
	// Given the head of a linked list, remove the nth node from the end of the list
	// and return its head.

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || n == 0) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = dummy;

		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return dummy.next;

	}

	public static void main(String[] args) {

	}

}
