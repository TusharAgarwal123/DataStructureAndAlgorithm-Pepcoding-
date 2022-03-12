package com.ds.level1.stack;

import com.ds.level1.stack.MyStackUsingArray.MyStack;

//means we can add any no of elements in stack.
public class DynamicStackDemo extends MyStack {

	public DynamicStackDemo() {
		super();
	}

	public DynamicStackDemo(int size) {
		super(size);
	}

	@Override
	public void push(int val) throws Exception {

		if (super.getSizeOfArray() == super.size()) {
			int temp[] = new int[super.size()];
			int idx = super.size() - 1;
			while (super.size() != 0) {
				temp[idx--] = super.pop();
			}

			super.initilize(super.getSizeOfArray() * 2);

			for (int i = 0; i < temp.length; i++) {
				super.push(temp[i]);
			}

		}

		super.push(val);

	}

	public static void main(String[] args) throws Exception {
		DynamicStackDemo st = new DynamicStackDemo();
		for (int i = 1; i <= 15; i++) {
			st.push(i * 10);
		}

		while (st.size() > 0) {
			System.out.println(st.pop());
		}
	}

}
