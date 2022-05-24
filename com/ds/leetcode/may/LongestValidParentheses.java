package com.ds.leetcode.may;

import java.util.Stack;

//leetcode 32. Longest Valid Parentheses
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {

		if (s.length() == 0) {
			return 0;
		}

		// stack will store indexes of invalid parenthesis.
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == ')' && st.size() > 0 && s.charAt(st.peek()) == '(') {
				st.pop();
			} else {
				st.push(i);
			}

		}

		int index = -1;
		int max = Integer.MIN_VALUE;
		for (int x : st) {
			max = Math.max(max, x - index - 1); // finding length of valid parenthesis which are present between indexes
												// of invalid parenthesis.
			index = x;
		}

		max = Math.max(max, s.length() - index - 1); // if there is valid parenthesis after last invalid index.

		return max;

	}

}
