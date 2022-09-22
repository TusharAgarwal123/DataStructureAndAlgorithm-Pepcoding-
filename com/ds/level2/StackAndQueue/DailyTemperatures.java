package com.ds.level2.StackAndQueue;

import java.util.Stack;

//739. Daily Temperatures

/*
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such
 *  that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 *   If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] temperatures) {

		Stack<Integer> st = new Stack<>();

		int[] ans = new int[temperatures.length];

		ans[ans.length - 1] = 0;
		st.push(ans.length - 1);

		for (int i = temperatures.length - 2; i >= 0; i--) {

			while (st.size() > 0 && temperatures[st.peek()] <= temperatures[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = 0;
			} else {
				ans[i] = st.peek() - i;
			}

			st.push(i);

		}

		return ans;

	}

	public int[] dailyTemperatures2(int[] temperatures) {

		Stack<Integer> st = new Stack<>();
		int[] ans = new int[temperatures.length];

		st.push(0); // pushing 0th index.

		for (int i = 1; i < temperatures.length; i++) {

			int val = temperatures[i];
			while (st.size() > 0 && temperatures[st.peek()] < val) {
				ans[st.peek()] = i - st.peek();
				st.pop();
			}

			st.push(i);

		}

		return ans;

	}
}
