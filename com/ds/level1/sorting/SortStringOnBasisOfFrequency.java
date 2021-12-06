package com.ds.level1.sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortStringOnBasisOfFrequency {

	public static void main(String[] args) {

		String str = "bbaaacabdd";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>();

		maxHeap.addAll(map.keySet());

		StringBuilder sb = new StringBuilder();
		while (maxHeap.size() > 0) {
			char cc = maxHeap.remove();
			for (int i = 0; i < map.get(cc); i++) {
				sb.append(cc);
			}
		}

		System.out.println(sb.toString());

	}

}
