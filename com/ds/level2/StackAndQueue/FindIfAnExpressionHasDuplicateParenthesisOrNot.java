package com.ds.level2.StackAndQueue;

import java.util.Stack;

//Find if an expression has duplicate parenthesis or not, on gfg.

/*
 * Given a balanced expression, find if it contains duplicate parenthesis or not. A set of parenthesis are
 *  duplicate if the same subexpression is surrounded by multiple parenthesis. 
 */

public class FindIfAnExpressionHasDuplicateParenthesisOrNot {

	public static void duplicateBrackets(String str) {

		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {

			if (ch == ')') {
				if (st.peek() == '(') {
					System.out.println(true);
					return;
				} else {
					while (st.size() > 0 && st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}

			} else {
				st.push(ch); // opening bracket or some char
			}
		}

		System.out.println(false);
	}

}
