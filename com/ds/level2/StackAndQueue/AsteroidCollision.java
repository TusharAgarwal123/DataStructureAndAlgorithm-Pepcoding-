package com.ds.level2.StackAndQueue;

import java.util.Stack;

//735. Asteroid Collision

/*
 * We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction
 (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
 If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.


 */

public class AsteroidCollision {

	public int[] asteroidCollision(int[] ar) {

		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < ar.length; i++) {
			if (st.size() == 0) {
				st.push(ar[i]);
			} else if (ar[i] > 0) {
				st.push(ar[i]);
			} else if (st.peek() < 0) {
				st.push(ar[i]);
			} else { // if on top if stack number is positive but current number is negative then
						// collision will happen.

				while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(ar[i])) {
					st.pop();
				}

				if (st.size() == 0) {
					st.push(ar[i]);
				} else if (st.peek() < 0) {
					st.push(ar[i]);
				} else if (st.peek() == Math.abs(ar[i])) {
					st.pop();
				} else if (st.peek() > Math.abs(ar[i])) {
					// do nothing.
				}

			}
		}

		int[] ans = new int[st.size()];
		int idx = ans.length - 1;

		while (st.size() > 0) {
			ans[idx] = st.pop();
			idx--;
		}

		return ans;

	}

}
