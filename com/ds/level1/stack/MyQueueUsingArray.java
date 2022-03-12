package com.ds.level1.stack;

import com.ds.level1.stack.MyStackUsingArray.MyStack;

public class MyQueueUsingArray {

	static class MyQueue {
		// class variables
		private int[] arr;
		private int sizeOfArray = 0;
		private int sizeOfQueue = 0;
		private int front = 0;
		private int back = 0;

		// constructor
		public MyQueue() {
			this.initilize(5);
		}

		public MyQueue(int size) {
			this.initilize(size);
		}

		protected void initilize(int size) {
			this.arr = new int[size];
			this.sizeOfArray = size;
			this.sizeOfQueue = 0;
			this.back = 0;
			this.front = 0;
		}

		// exceptions
		private void queueIsFullException() throws Exception {
			if (this.sizeOfArray == this.sizeOfQueue)
				throw new Exception("queueIsFull");
		}

		private void queueIsEmptyException() throws Exception {
			if (this.sizeOfQueue == 0)
				throw new Exception("queueIsEmpty");
		}

		// basic
		public boolean isEmpty() {
			return this.sizeOfQueue == 0;
		}

		public int size() {
			return this.sizeOfQueue;
		}

		// functions

		public void push(int val) throws Exception {
			queueIsFullException();
			this.arr[this.back] = val;
			this.sizeOfQueue++;
			this.back = (this.back + 1) % sizeOfArray;
		}

		public int pop() throws Exception {
			queueIsEmptyException();
			int val = this.front();
			this.arr[this.front] = 0;
			this.sizeOfQueue--;
			this.front = (this.front + 1) % sizeOfArray;
			return val;
		}

		public int front() throws Exception {
			queueIsEmptyException();
			return this.arr[this.front];
		}

		public void display() {
			for (int i = 0; i < this.sizeOfQueue; i++) {
				int idx = (this.front + i) % this.sizeOfArray;
				System.out.print(arr[idx] + " ");
			}
		}

		protected int getSizeOfArray() {
			return this.sizeOfArray;
		}

	}

	public static void main(String[] args) throws Exception {
		MyQueue st = new MyQueue(8);
		for (int i = 1; i <= 8; i++) {
			st.push(i * 10);
		}

//		while (st.size() > 0) {
//			System.out.println(st.pop());
//		}

		st.display();
	}

}
