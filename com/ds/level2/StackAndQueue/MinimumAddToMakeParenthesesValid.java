package com.ds.level2.StackAndQueue;

import java.util.Stack;

//921. Minimum Add to Make Parentheses Valid

/*
 * A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis
 to be "())))".
Return the minimum number of moves required to make s valid.


 */

public class MinimumAddToMakeParenthesesValid {

	public int minAddToMakeValid(String s) {

		Stack<Character> st = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (st.size() == 0 || ch == '(') {
				st.push(ch);
			} else if (st.peek() == ')') {
				st.push(ch);
			} else {
				st.pop();
			}
		}

		return st.size();

	}

}
