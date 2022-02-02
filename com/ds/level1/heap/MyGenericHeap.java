package com.ds.level1.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyGenericHeap {

	public static class PriorityQueue<T> {

		ArrayList<T> data;
		Comparator com;

		public PriorityQueue() {
			data = new ArrayList<T>();
			com = null;
		}

		public PriorityQueue(Comparator com) {
			data = new ArrayList<T>();
			this.com = com;
		}

		public PriorityQueue(T ar[]) {
			data = new ArrayList<T>();
			for (T x : ar) {
				data.add(x);
			}

			for (int i = data.size() / 2 - 1; i >= 0; i--) {
				downHeapify(i);
			}
		}

		public void add(T val) {

			data.add(val);
			upHeapify(data.size() - 1);

		}

		private void upHeapify(int i) {

			if (i == 0) {
				return;
			}

			int pi = (i - 1) / 2;
			if (isSamller(i, pi)) {
				swap(i, pi);
				upHeapify(pi);
			}

		}

		private boolean isSamller(int i, int j) {
			if (com == null) {
				Comparable ith = (Comparable) data.get(i);
				Comparable jth = (Comparable) data.get(j);

				if (ith.compareTo(jth) < 0) {
					return true;
				} else {
					return false;
				}
			} else { // if comparator is pass.
				T ith = data.get(i);
				T jth = data.get(j);

				if (com.compare(ith, jth) < 0) {
					return true;
				} else {
					return false;
				}
			}

		}

		private void swap(int i, int j) {
			T ith = data.get(i);
			T jth = data.get(j);
			data.set(i, jth);
			data.set(j, ith);

		}

		public T remove() {

			if (data.size() == 0) {
				return null;
			}

			swap(0, data.size() - 1);
			T val = data.remove(data.size() - 1);
			downHeapify(0);

			return val;

		}

		private void downHeapify(int pi) {

			int min = pi;

			int li = (pi * 2) + 1;
			if (li < data.size() && isSamller(li, min)) {
				min = li;
			}

			int ri = (pi * 2) + 2;
			if (ri < data.size() && isSamller(ri, min)) {
				min = ri;
			}

			if (min != pi) {
				swap(pi, min);
				downHeapify(min);
			}

		}

		public T peek() {
			// write your code here
			if (data.size() == 0) {
				return null;
			}

			return data.get(0);

		}

		public int size() {
			return data.size();
		}
	}

	static class Student implements Comparable<Student> {
		String name;
		int ht;
		int wt;
		int marks;

		Student(String name, int ht, int wt, int marks) {
			this.name = name;
			this.ht = ht;
			this.wt = wt;
			this.marks = marks;

		}

		public String toString() {
			return this.name + " , " + this.ht + " , " + this.wt + " , " + this.marks;
		}

		// sorting on basis of height.
		@Override
		public int compareTo(Student o) {
			return this.ht - o.ht; // means smallest height will come on top.

			// return o.ht - this.ht; // means largest height will come on top.
		}

		// sorting on basis of name.
		// String class internally implement Comparable, so use it's compareto method.
//		@Override
//		public int compareTo(Student o) {
//			return this.name.compareTo(o.name);
//
//		}
	}

	// sorting on basis of marks.
	static class StudentMarksComparator implements Comparator<Student> {

		public int compare(Student s1, Student s2) {
			return s1.marks - s2.marks;
		}
	}

	// sorting on basis of name.
	static class StudentNameComparator implements Comparator<Student> {

		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	}

	// sorting on basis of wt.
	// we are creating the comprator bcoz in comparable we can only define one
	// sorting criteria.
	static class StudentWtComparator implements Comparator<Student> {

		public int compare(Student s1, Student s2) {
			return s1.wt - s2.wt;
		}
	}

	public static void main(String[] args) {

		Student[] student = new Student[5];

		student[0] = new Student("Tushar", 6, 60, 100);
		student[1] = new Student("Agarwal", 5, 65, 97);
		student[2] = new Student("Rohit", 4, 70, 93);
		student[3] = new Student("Sharma", 7, 55, 91);
		student[4] = new Student("Virat", 8, 63, 96);

		PriorityQueue<Student> pq = new PriorityQueue<Student>();
		// we are passing nothing in constructor so it will take sorting criteria from
		// Comparable.

		// internally Collections.reverseOrder(), returns the Comparator that change the
		// logic of
		// comparable or reverse the sorting process.
		// PriorityQueue<Student> q = new
		// PriorityQueue<Student>(Collections.reverseOrder());

		PriorityQueue<Student> pq2 = new PriorityQueue<Student>(new StudentNameComparator());
		// we are passing Comparator in constructor so it will take sorting criteria
		// from
		// Comparator.

		// we have passed Collections.reverseOrder(),and in Collections.reverseOrder(),
		// we have
		// pass comprarator so now it will reverse the logic of comparator pass to it.
		// PriorityQueue<Student> pq3 = new
		// PriorityQueue<Student>(Collections.reverseOrder(new StudentWtComparator()));

		for (Student s : student) {
			pq.add(s);
			pq2.add(s);
		}

		while (pq.size() > 0) {
			System.out.println(pq.remove());
		}

		System.out.println("********************");
		while (pq2.size() > 0) {
			System.out.println(pq2.remove());
		}

	}

}
