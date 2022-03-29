package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

//leetcode 380.
public class InsertDeleteGetRandom {

	// all method are in O(1).

	Random r;
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;

	public InsertDeleteGetRandom() {
		r = new Random();
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}

		list.add(val);
		map.put(val, list.size() - 1);

		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		int vidx = map.get(val);
		int lidx = list.size() - 1;

		int lval = list.get(lidx);

		list.set(vidx, lval);
		list.set(lidx, val);

		map.put(val, lidx);
		map.put(lval, vidx);

		list.remove(list.size() - 1);

		map.remove(val);

		return true;
	}

	public int getRandom() {

		int idx = r.nextInt(list.size());
		return list.get(idx);

	}

}
