package com.ds.level2.recursion_backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/*
 * 1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.
 */
public class RemoveInvalidParenthesis {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {

		if (minRemoval == 0) {

			if (getMin(str) == 0) {
				if (!ans.contains(str)) {
					ans.add(str);
					System.out.println(str);
				}
			}

			return;
		}
		// write your code here
		for (int i = 0; i < str.length(); i++) {

			String left = str.substring(0, i);
			String right = str.substring(i + 1);

			solution(left + right, minRemoval - 1, ans);

		}
	}

	// it gives the minimum no of invalid brackets.
	public static int getMin(String str) {
		// write your code here
		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				st.push(ch);
			} else {
				if (st.size() == 0) {
					st.push(ch);
				} else if (st.peek() == ')') {
					st.push(ch);
				} else if (st.peek() == '(') {
					st.pop();
				}
			}
		}
		return st.size();
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str), new HashSet<>());
	}

}
