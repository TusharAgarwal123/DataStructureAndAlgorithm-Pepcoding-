package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/*
 * RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also removing a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.

 */

//leetcode 381
public class InsertDeleteGetRandomDuplicatesAllowed {

	Random r;
	HashMap<Integer, HashSet<Integer>> map;
	ArrayList<Integer> list;

	public InsertDeleteGetRandomDuplicatesAllowed() {
		r = new Random();
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {

		list.add(val);

		int lidx = list.size() - 1;

		if (map.containsKey(val)) {
			HashSet<Integer> set = map.get(val);
			set.add(lidx);
			return false;
		} else {
			HashSet<Integer> set = new HashSet<>();
			set.add(lidx);
			map.put(val, set);
			return true;
		}

	}

	public boolean remove(int val) {

		if (map.containsKey(val) == false) {
			return false;
		}

		int lidx = list.size() - 1;
		int lval = list.get(lidx);
		int vidx = map.get(val).iterator().next();

		list.set(lidx, val);
		list.set(vidx, lval);
		list.remove(list.size() - 1);

		map.get(val).remove(vidx);
		if (map.get(val).size() == 0) {
			map.remove(val);
		}

		if (map.containsKey(lval)) {
			map.get(lval).remove(lidx);
			map.get(lval).add(vidx);
		}

		return true;

	}

	public int getRandom() {

		int idx = r.nextInt(list.size());
		return list.get(idx);
	}

}
