package com.ds.level1.stack;

public class MyStackUsingArray {

	static class MyStack {
		// class variables
		private int[] arr;
		private int sizeOfArray = 0;
		private int sizeOfStack = 0;
		private int tos = -1;

		// constructor
		public MyStack() {
			this.initilize(5);
		}

		public MyStack(int size) {
			this.initilize(size);
		}

		protected void initilize(int size) {
			this.arr = new int[size];
			this.sizeOfArray = size;
			this.sizeOfStack = 0;
			this.tos = -1;
		}

		// exceptions
		private void stackIsFullException() throws Exception {
			if (this.sizeOfArray == this.sizeOfStack)
				throw new Exception("stackIsFull");
		}

		private void stackIsEmptyException() throws Exception {
			if (this.sizeOfStack == 0)
				throw new Exception("stackIsEmpty");
		}

		// basic
		public boolean isEmpty() {
			return this.sizeOfStack == 0;
		}

		public int size() {
			return this.sizeOfStack;
		}

		// functions

		public void push(int val) throws Exception {
			stackIsFullException();
			this.tos++;
			this.arr[this.tos] = val;
			this.sizeOfStack++;
		}

		public int pop() throws Exception {
			stackIsEmptyException();
			int val = this.top();
			this.arr[this.tos] = 0;
			this.tos--;
			this.sizeOfStack--;

			return val;
		}

		public int top() throws Exception {
			stackIsEmptyException();
			return this.arr[this.tos];
		}

		// protected can be access across package.
		protected int getSizeOfArray() {
			return this.sizeOfArray;
		}

	}

	public static void main(String[] args) throws Exception {

		MyStack st = new MyStack(8);
		for (int i = 1; i <= 8; i++) {
			st.push(i * 10);
		}

		while (st.size() > 0) {
			System.out.println(st.pop());
		}

	}

}
