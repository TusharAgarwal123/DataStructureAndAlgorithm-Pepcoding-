package com.ds.level2.StackAndQueue;

import java.util.Stack;

//Longest valid Parentheses

/*
 * Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest
 *  valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.
 */

public class LongestValidParentheses {

	static int maxLength(String s) {
		// code here

		Stack<Integer> st = new Stack<>();

		int max = 0;

		st.push(-1);

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				st.push(i);
			} else {
				st.pop();

				if (st.size() > 0) {
					int len = i - st.peek();
					max = Math.max(max, len);
				} else {
					st.push(i);
				}
			}
		}

		return max;
	}

}
