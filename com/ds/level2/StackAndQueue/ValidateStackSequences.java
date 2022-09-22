package com.ds.level2.StackAndQueue;

import java.util.Stack;

//946. Validate Stack Sequences

/*
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been
 *  the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 */

public class ValidateStackSequences {

	public boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> st = new Stack<>();
		int i = 0;
		int j = 0;

		while (i < pushed.length) {
			st.push(pushed[i]);
			i++;

			while (st.size() > 0 && j < popped.length && st.peek() == popped[j]) {
				st.pop();
				j++;
			}
		}

		return j == popped.length;

	}

}
