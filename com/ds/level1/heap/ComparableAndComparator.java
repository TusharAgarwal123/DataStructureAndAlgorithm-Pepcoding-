package com.ds.level1.heap;

import com.ds.level1.heap.MyGenericHeap.Student;

public class ComparableAndComparator {

	static class Student implements Comparable<Student> {
		String name;
		int ht;
		int wt;

		Student(String name, int ht, int wt) {
			this.name = name;
			this.ht = ht;
			this.wt = wt;

		}

		public String toString() {
			return this.name + " , " + this.ht + " , " + this.wt;
		}

		// sorting on basis of height.
		@Override
		public int compareTo(Student o) {
			return this.ht - o.ht;
		}
	}

	public static void main(String[] args) {

	}

}
