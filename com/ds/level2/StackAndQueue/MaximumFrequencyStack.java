package com.ds.level2.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

//895. Maximum Frequency Stack

/*
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from
 *  the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and
 returned.
 */

public class MaximumFrequencyStack {

	int maxFreq;

	HashMap<Integer, Integer> map;
	HashMap<Integer, Stack<Integer>> freqMap;

	public MaximumFrequencyStack() {
		maxFreq = 0;
		map = new HashMap<Integer, Integer>();
		freqMap = new HashMap<>();
	}

	public void push(int val) {

		map.put(val, map.getOrDefault(val, 0) + 1);

		int fr = map.get(val);

		if (freqMap.containsKey(fr)) {
			Stack<Integer> ele = freqMap.get(fr);
			ele.push(val);
		} else {
			Stack<Integer> ele = new Stack<>();
			ele.push(val);
			freqMap.put(fr, ele);
		}

		if (fr > maxFreq) {
			maxFreq = fr;
		}

	}

	public int pop() {

		int val = freqMap.get(maxFreq).pop();
		if (freqMap.get(maxFreq).size() == 0) {
			freqMap.remove(maxFreq);
			maxFreq--;
		}

		map.put(val, map.get(val) - 1);
		return val;

	}

}
