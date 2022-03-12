package com.ds.level1.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyGenericHashMap {

	public static class HashMap<K, V> {

		private class HMNode {
			K key;
			V value;

			HMNode(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private int size;
		private LinkedList<HMNode>[] buckets;

		public HashMap() {
			this.size = 0;
			initBuckets(4);

		}

		private void initBuckets(int N) {
			buckets = new LinkedList[N];
			for (int i = 0; i < buckets.length; i++) {
				buckets[i] = new LinkedList<>();
			}
		}

		public void put(K key, V value) throws Exception {
			int bi = hash(key);
			int di = getIndexWithInBuckets(key, bi);

			if (di != -1) {

				HMNode node = buckets[bi].get(di);
				node.value = value;

			} else {
				HMNode node = new HMNode(key, value);
				buckets[bi].add(node);
				size++;
			}

			double lamda = size * 1.0 / buckets.length;
			if (lamda > 2.0) { // 2.0 is threshold
				rehash();
			}
			// write your code here
		}

		public V get(K key) throws Exception {

			int bi = hash(key);
			int di = getIndexWithInBuckets(key, bi);

			if (di != -1) {
				HMNode node = buckets[bi].get(di);
				return node.value;
			} else {
				return null;
			}
			// write your code here
		}

		public boolean containsKey(K key) {

			int bi = hash(key);
			int di = getIndexWithInBuckets(key, bi);

			if (di != -1) {
				return true;
			} else {
				return false;
			}
			// write your code here
		}

		public V remove(K key) throws Exception {
			int bi = hash(key);
			int di = getIndexWithInBuckets(key, bi);

			if (di != -1) {
				HMNode node = buckets[bi].remove(di);
				size--;
				return node.value;
			} else {
				return null;
			}
			// write your code here
		}

		// only this method is O(n).
		public ArrayList<K> keyset() throws Exception {
			ArrayList<K> list = new ArrayList<>();
			for (int i = 0; i < buckets.length; i++) {
				for (HMNode node : buckets[i]) {
					list.add(node.key);
				}
			}
			return list;
			// write your code here
		}

		public int size() {
			// write your code here
			return size;
		}

		// hash function returns the hashcode of key passed to it.
		private int hash(K key) {
			int hc = key.hashCode();
			return Math.abs(hc) % buckets.length; // compression
		}

		private void rehash() throws Exception {
			LinkedList<HMNode>[] aba = buckets;
			initBuckets(aba.length * 2);
			size = 0;

			for (int i = 0; i < aba.length; i++) {
				for (HMNode node : aba[i]) {
					put(node.key, node.value);
				}
			}

		}

		// it will return index of key in given bucket.
		// time complexity is O(lamda), lamda is average no of elements per bucktes.
		private int getIndexWithInBuckets(K key, int bi) {
			int di = 0;
			for (HMNode node : buckets[bi]) {
				if (node.key.equals(key)) {
					return di;
				}
				di++;
			}
			return -1;
		}

		public void display() {
			System.out.println("Display Begins");
			for (int bi = 0; bi < buckets.length; bi++) {
				System.out.print("Bucket" + bi + " ");
				for (HMNode node : buckets[bi]) {
					System.out.print(node.key + "@" + node.value + " ");
				}
				System.out.println(".");
			}
			System.out.println("Display Ends");
		}
	}

	public static void main(String[] args) throws Exception {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Ind", 10);
		map.put("Aus", 6);
		map.put("Can", 7);
		map.put("China", 9);
		map.put("USA", 9);
		map.put("Ban", 3);
		map.put("Nep", 4);
		map.put("Rus", 8);
		map.put("Aus", 8);

		map.display();

	}

}
