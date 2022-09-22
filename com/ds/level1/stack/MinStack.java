package com.ds.level1.stack;

import java.util.Stack;

//155. Min Stack

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.


 */

public class MinStack {

	Stack<Integer> st = new Stack<>();
	Stack<Integer> min = new Stack<>();

	public void push(int x) {

		if (min.isEmpty() || x <= min.peek()) {
			min.push(x);
		}

		st.push(x);

	}

	public void pop() {
		if (st.peek().equals(min.peek())) {
			min.pop();
		}

		st.pop();
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
