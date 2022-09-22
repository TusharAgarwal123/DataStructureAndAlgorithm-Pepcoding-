package com.ds.level2.StackAndQueue;

import java.util.Queue;
import java.util.Stack;

//Reverse First K elements of Queue

/*
 * Given an integer K and a queue of integers, we need to reverse the order of the first K elements
 *  of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Note: The above operations represent the general processings. In-built functions of the respective
 */

public class ReverseFirstKElementsOfQueue {

	public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
		// add code here.

		int sz = q.size();

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < k; i++) {
			st.push(q.remove());
		}

		while (st.size() > 0) {
			q.add(st.pop());
		}

		for (int i = 0; i < sz - k; i++) {
			q.add(q.remove());
		}

		return q;

	}
}
