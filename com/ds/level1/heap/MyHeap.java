package com.ds.level1.heap;

import java.util.ArrayList;

public class MyHeap {

	// this is minHeap.
	public static class PriorityQueue {
		ArrayList<Integer> data;

		public PriorityQueue() {
			data = new ArrayList<>();
		}

		// O(nlogn), not a good constructor.
//		public PriorityQueue(int ar[]) {
//			data = new ArrayList<Integer>();
//			for (int x : ar) {
//				this.add(x);
//			}
//		}

		// O(n), good constructor.
		public PriorityQueue(int ar[]) {
			data = new ArrayList<Integer>();
			for (int x : ar) {
				data.add(x);
			}

			for (int i = data.size() / 2 - 1; i >= 0; i--) {
				downHeapify(i);
			}
		}

		public void add(int val) {
			// write your code here
			data.add(val);
			upHeapify(data.size() - 1);
		}

		private void upHeapify(int i) {

			if (i == 0) {
				return; // bcoz 0 is root.
			}

			int pi = (i - 1) / 2;
			if (data.get(pi) > data.get(i)) {
				swap(i, pi);
				upHeapify(pi);
			}

		}

		private void swap(int i, int j) {

			int ith = data.get(i);
			int jth = data.get(j);

			data.set(i, jth);
			data.set(j, ith);

		}

		public int remove() {
			// write your code here
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}

			swap(0, data.size() - 1);
			int val = data.remove(data.size() - 1);
			downHeapify(0);

			return val;

		}

		private void downHeapify(int pi) {

			int min = pi;

			int li = (pi * 2) + 1;
			if (li < data.size() && data.get(li) < data.get(min)) {
				min = li;
			}

			int ri = (pi * 2) + 2;
			if (ri < data.size() && data.get(ri) < data.get(min)) {
				min = ri;
			}

			if (min != pi) {
				swap(min, pi);
				downHeapify(min);
			}

		}

		public int peek() {
			// write your code here
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			} else {
				return data.get(0);
			}
		}

		public int size() {
			// write your code here
			return data.size();
		}
	}

	public static void main(String[] args) {

		int ar[] = { 2, 12, 8, 14, 6, 4, 10, 18, 16, 20 };

		PriorityQueue q = new PriorityQueue(ar);
		while (q.size() > 0) {
			System.out.println(q.remove());
		}

//		PriorityQueue q = new PriorityQueue();
//		q.add(5);
//		q.add(10);
//		q.add(15);
//		q.add(20);
//		q.add(25);
//		q.add(30);
//
//		System.out.println(q.peek());
//		System.out.println(q.remove());
//		System.out.println(q.peek());
//
//		q.add(2);
//		System.out.println(q.peek());
	}

}
