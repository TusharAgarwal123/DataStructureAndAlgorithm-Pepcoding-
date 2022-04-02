package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
 */

//leetcode 146.
public class LRU_CACHE {

	static class Node {
		Node next;
		Node prev;
		int key;
		int val;
	}

	Node head;
	Node tail;

	int cap;
	int size;

	HashMap<Integer, Node> map;

	public LRU_CACHE(int capacity) {

		this.cap = capacity;
		this.size = 0;
		this.map = new HashMap<>();

	}

	public void addFront(int key, int value) {
		Node node = new Node();
		node.key = key;
		node.val = value;

		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}

		size++;
	}

	public void remove(Node node) {

		if (head == null) {
			return;
		} else if (head == tail) {
			head = tail = null;
		} else if (head == node) {
			Node np1 = head.next;
			np1.prev = null;
			head = np1;
		} else if (tail == node) {
			Node nm1 = tail.prev;
			nm1.next = null;
			tail = nm1;
		} else {

			Node nm1 = node.prev;
			Node np1 = node.next;
			nm1.next = np1;
			np1.prev = nm1;

		}
		size--;

	}

	public int get(int key) {

		if (map.containsKey(key)) {

			Node node = map.get(key);
			remove(node);
			addFront(key, node.val);
			map.put(key, head);

			return node.val;

		} else {
			return -1;
		}

	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {

			Node node = map.get(key);
			remove(node);
			addFront(key, value);
			map.put(key, head);

		} else {

			if (size == cap) {

				map.remove(tail.key);
				remove(tail);
				addFront(key, value);
				map.put(key, head);

			} else {
				addFront(key, value);
				map.put(key, head);
			}

		}

	}

}
