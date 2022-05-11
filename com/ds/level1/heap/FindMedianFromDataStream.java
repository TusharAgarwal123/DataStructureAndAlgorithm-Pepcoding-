package com.ds.level1.heap;

import java.util.Collections;
import java.util.PriorityQueue;

//295. Find Median from Data Stream
public class FindMedianFromDataStream {

	private PriorityQueue<Integer> left = null;
	private PriorityQueue<Integer> right = null;

	public FindMedianFromDataStream() {
		this.left = new PriorityQueue<>(Collections.reverseOrder());
		this.right = new PriorityQueue<>();
	}

	// O(log(n))
	public void addNum(int val) {

		if (right.size() > 0 && val > right.peek()) {
			right.add(val);
		} else {
			left.add(val);
		}

		if (left.size() - right.size() == 2) {
			right.add(left.remove());
		} else if (right.size() - left.size() == 2) {
			left.add(right.remove());
		}

	}

	// O(1)
	public double findMedian() {

		if (left.size() > right.size()) {
			return left.peek();
		} else if (right.size() > left.size()) {
			return right.peek();
		} else {
			// when size is same then return the average of two middle values.
			return (left.peek() + right.peek()) / 2.0;
		}

	}

}
