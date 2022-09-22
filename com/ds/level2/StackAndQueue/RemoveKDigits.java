package com.ds.level2.StackAndQueue;

import java.util.Stack;

//402. Remove K Digits

/*
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible
 *  integer after removing k digits from num.


 */

public class RemoveKDigits {

	public String removeKdigits(String num, int k) {

		if (k == num.length()) {
			return "0";
		}

		Stack<Character> st = new Stack<>();
		st.push(num.charAt(0));

		for (int i = 1; i < num.length(); i++) {
			char ch = num.charAt(i);

			while (st.size() > 0 && k > 0 && ch < st.peek()) {
				k--;
				st.pop();
			}

			st.push(ch);
		}

		while (k > 0) { // if some k left bcoz of number is in increasing order.
			st.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (st.size() > 0) {
			sb.append(st.peek());
			st.pop();
		}

		for (int i = sb.length() - 1; i >= 0; i--) { // removing leading zeros.
			if (sb.charAt(i) == '0') {
				sb.deleteCharAt(i);
			} else {
				break;
			}
		}

		String ans = sb.reverse().toString();

		return ans.length() == 0 ? "0" : ans;

	}

}
