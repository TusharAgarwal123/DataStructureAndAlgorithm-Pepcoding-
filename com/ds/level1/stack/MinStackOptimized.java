package com.ds.level1.stack;

import java.util.Stack;

//155. Min Stack

//time complexity is same just space is reduce.
public class MinStackOptimized {

	private Stack<Long> mData;
	private Long min;

	public MinStackOptimized() {
		this.mData = new Stack<>();
		this.min = Long.MAX_VALUE;
	}

	public void push(int val1) {

		long val = val1;

		if (mData.size() == 0) {
			mData.push(val);
			min = val;
		} else {

			if (val >= min) {
				mData.push(val);
			} else {

				mData.push(2 * val - min);
				min = val;

			}

		}

	}

	public void pop() {
		if (mData.peek() >= min) {
			mData.pop();
		} else {

			min = 2 * min - mData.pop();
		}

	}

	public int top() {

		if (mData.peek() >= min) {
			return mData.peek().intValue();
		} else {
			return min.intValue();
		}

	}

	public int getMin() {
		return min.intValue();
	}

}
