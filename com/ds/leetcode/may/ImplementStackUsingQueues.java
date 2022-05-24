package com.ds.leetcode.may;

//leetcode 225. Implement Stack using Queues
public class ImplementStackUsingQueues {

	static class MyQueue {

		int data[];
		int front;
		int size;

		MyQueue() {
			data = new int[5];
			front = 0;
			size = 0;
		}

		public void add(int val) {

			if (size == data.length) {

				int nData[] = new int[size * 2];
				for (int i = 0; i < size; i++) {
					int idx = (front + i) % data.length;
					nData[i] = data[idx];
				}

				data = nData;
				front = 0;

				int idx = (front + size) % data.length;
				data[idx] = val;
				size++;

			}

			int idx = (front + size) % data.length;
			data[idx] = val;
			size++;
		}

		public int pop() {

			int val = data[front];
			front = (front + 1) % data.length;
			size--;
			return val;
		}

		public int top() {

			int val = data[front];
			return val;
		}

		public int size() {
			return size;
		}

	}

	private MyQueue mQueue;
	private MyQueue hQueue;

	public ImplementStackUsingQueues() {
		mQueue = new MyQueue();
		hQueue = new MyQueue();
	}

	public void push(int x) {

		while (mQueue.size() != 0) {
			hQueue.add(mQueue.pop());
		}

		mQueue.add(x);

		while (hQueue.size() != 0) {
			mQueue.add(hQueue.pop());
		}

	}

	public int pop() {

		return mQueue.pop();

	}

	public int top() {

		return mQueue.top();

	}

	public boolean empty() {
		return mQueue.size() == 0;
	}

}
