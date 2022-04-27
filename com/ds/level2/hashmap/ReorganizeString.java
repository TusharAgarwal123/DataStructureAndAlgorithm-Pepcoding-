package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.
 */

//767. Reorganize String
public class ReorganizeString {

	static class Pair implements Comparable<Pair> {
		char ch;
		int f;

		Pair(char ch, int f) {
			this.ch = ch;
			this.f = f;
		}

		public int compareTo(Pair o) {
			return o.f - this.f;
		}

	}

	public String reorganizeString(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		PriorityQueue<Pair> q = new PriorityQueue<>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : map.keySet()) {
			int fr = map.get(ch);

			q.add(new Pair(ch, fr));
		}

		StringBuilder sb = new StringBuilder();

		Pair block = q.remove();
		sb.append(block.ch);
		block.f--;

		while (q.size() > 0) {
			Pair temp = q.remove();
			sb.append(temp.ch);
			temp.f--;

			if (block.f > 0) {
				q.add(block);
			}

			block = temp;

		}

		if (block.f > 0) {
			return "";
		}

		return sb.toString();

	}

}
