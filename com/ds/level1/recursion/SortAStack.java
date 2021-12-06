package com.ds.level1.recursion;

import java.util.Stack;

public class SortAStack {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<>();
		st.push(2);
		st.push(6);
		st.push(1);
		st.push(16);
		st.push(4);
		st.push(15);

		System.out.println(st);
		sortStack(st);
		System.out.println(st);

	}

	static void sortStack(Stack<Integer> st) {

		if (st.size() == 1) {
			return;
		}

		int t = st.pop();
		sortStack(st);
		pushAtSortedPosition(st, t);

	}

	static void pushAtSortedPosition(Stack<Integer> st, int k) {

		if (st.size() == 0 || st.peek() <= k) {
			st.push(k);
			return;
		}

		int t = st.pop();
		pushAtSortedPosition(st, k);
		st.push(t);

	}

}
