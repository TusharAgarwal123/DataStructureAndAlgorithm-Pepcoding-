package com.ds.level2.hashmap;

import java.util.Iterator;

/*
 * Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.

Implement the PeekingIterator class:

PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
int next() Returns the next element in the array and moves the pointer to the next element.
boolean hasNext() Returns true if there are still elements in the array.
int peek() Returns the next element in the array without moving the pointer.
Note: Each language may have a different implementation of the constructor and Iterator, but they all support
 the int next() and boolean hasNext() functions.
 */

//leetcode 284.
public class PeekingIterator {

	private Iterator<Integer> itr;
	private Integer nextValue = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		itr = iterator;
		if (itr.hasNext()) {
			nextValue = itr.next();
		}

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {

		return nextValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {

		int val = nextValue;

		if (itr.hasNext()) {
			nextValue = itr.next();
		} else {
			nextValue = null;
		}

		return val;

	}

	public boolean hasNext() {

		return nextValue != null;

	}

}
