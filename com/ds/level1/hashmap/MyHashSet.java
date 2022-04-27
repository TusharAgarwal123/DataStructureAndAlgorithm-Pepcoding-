package com.ds.level1.hashmap;

import java.util.LinkedList;

/*
 * Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 */

//leetcode 705.
public class MyHashSet {
	// boolean [] set;

	static class HMNode {
		int key;

		HMNode(int key) {
			this.key = key;
		}
	}

	private int size = 0;

	private LinkedList<HMNode>[] buckets;

	public MyHashSet() {
		// set=new boolean[1000001];
		initBucket(4);
		this.size = 0;

	}

	private void initBucket(int n) {
		buckets = new LinkedList[n];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public void add(int key) {
		// set[key]=true;

		int bi = hash(key);
		int di = getIndexWithInBucket(key, bi);

		if (di == -1) {
			HMNode node = new HMNode(key);
			buckets[bi].add(node);
			this.size++;
		}

		double lamda = size * 1.0 / buckets.length;

		if (lamda > 2.0) {
			rehash();
		}
	}

	public void remove(int key) {
		// set[key]=false;

		int bi = hash(key);
		int di = getIndexWithInBucket(key, bi);

		if (di != -1) {
			HMNode node = buckets[bi].remove(di);
			this.size--;
		}
	}

	public boolean contains(int key) {
		// return set[key];

		int bi = hash(key);
		int di = getIndexWithInBucket(key, bi);

		if (di != -1) {
			return true;
		} else {
			return false;
		}
	}

	private void rehash() {

		LinkedList<HMNode>[] aba = buckets;

		initBucket(aba.length * 2);
		this.size = 0;

		for (int i = 0; i < aba.length; i++) {
			for (HMNode node : aba[i]) {
				add(node.key);
			}
		}

	}

	public int hash(int key) {
		Integer nKey = (Integer) key;
		int hc = nKey.hashCode();

		return Math.abs(hc) % buckets.length;
	}

	public int getIndexWithInBucket(int key, int bi) {

		int di = 0;
		for (HMNode node : buckets[bi]) {
			if (node.key == key) {
				return di;
			}

			di++;
		}

		return -1;

	}
}
