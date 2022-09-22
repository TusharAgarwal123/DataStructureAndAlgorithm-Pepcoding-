package com.ds.level2.StackAndQueue;

import java.util.Stack;

//Count the Reversals

/*
 * Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum
 *  number of reversals required to convert the string into a balanced expression.
A reversal means changing '{' to '}' or vice-versa.
 */

public class CountTheReversals {

	int countRev(String s) {
		// your code here

		if (s.length() % 2 == 1) {
			return -1;
		}

		Stack<Character> st = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (st.size() == 0 || ch == '{') {
				st.push(ch);
			} else if (st.peek() == '}') {
				st.push(ch);
			} else {
				st.pop();
			}
		}

		int c1 = 0; // opening count
		int c2 = 0; // closing count

		while (st.size() > 0) {
			char cc = st.pop();

			if (cc == '{') {
				c1++;
			} else {
				c2++;
			}
		}

		int ans = (c1 + 1) / 2 + (c2 + 1) / 2; // taking ceil of both

		return ans;

	}

}
