package com.ds.level1.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapDemo {

	// O(nlogn), not a good approach.
	public static void KLargest(int ar[], int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		// max heap.

		for (int x : ar) {
			q.add(x);
		}

		for (int i = 0; i < k; i++) {
			System.out.println(q.remove());
		}
	}

	// O(nlogk), good approach.
	public static void KLargest2(int ar[], int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// min heap.

		for (int i = 0; i < ar.length; i++) {
			if (i < k) {
				q.add(ar[i]);
			} else {
				if (ar[i] > q.peek()) {
					q.remove();
					q.add(ar[i]);
				}
			}
		}

		while (q.size() > 0) {
			System.out.println(q.remove());
		}
	}

	/*
	 * 1. You are given a number n, representing the size of array a. 2. You are
	 * given n numbers, representing elements of array a. 3. The array is nearly
	 * sorted. Every element is at-max displaced k spots left or right to it's
	 * position in the sorted array. Hence it is being called k-sorted array. 4. You
	 * are required to sort and print the sorted array.
	 */

	// O(nlogk).
	public static void sortKSorted(int n, int ar[], int k) {

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i <= k; i++) {
			q.add(ar[i]);
		}

		for (int i = k + 1; i < n; i++) {
			System.out.println(q.remove());
			q.add(ar[i]);
		}

		while (q.size() > 0) {

			System.out.println(q.remove());
		}

	}

	static class Pair implements Comparable<Pair> {
		int li;
		int di;
		int val;

		Pair(int li, int di, int val) {
			this.li = li;
			this.di = di;
			this.val = val;
		}

		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}

	// O(nlogk)
	// k is no of list.
	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();

		PriorityQueue<Pair> q = new PriorityQueue<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair(i, 0, lists.get(i).get(0));
			q.add(p);
		}

		while (q.size() > 0) {

			Pair p = q.remove();
			rv.add(p.val);
			p.di++;

			if (p.di < lists.get(p.li).size()) {
				p.val = lists.get(p.li).get(p.di);
				q.add(p);
			}

		}

		return rv;
	}

	public static void main(String[] args) {

		int ar[] = { 3, 2, 4, 1, 6, 5, 7, 9, 8 };
		// KLargest2(ar, 2);

		sortKSorted(9, ar, 3);

	}

}
