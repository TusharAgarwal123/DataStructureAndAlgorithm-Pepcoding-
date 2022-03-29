package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.

Note -> Both arrays(A and B) are of the same length.
 */
public class FindAnagramMappings {

	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here

		int ans[] = new int[arr2.length];
		int c = 0;

		HashMap<Integer, Queue<Integer>> map = new HashMap<>();

		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i])) {
				Queue<Integer> q = map.get(arr2[i]);
				q.add(i);
				map.put(arr2[i], q);
			} else {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				map.put(arr2[i], q);
			}
		}

		for (int x : arr1) {
			ans[c++] = map.get(x).remove();

		}

		return ans;
	}

}
