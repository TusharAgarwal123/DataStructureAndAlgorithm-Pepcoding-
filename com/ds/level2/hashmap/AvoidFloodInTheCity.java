package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.TreeSet;

/*
 * Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it
 *  rains over the nth lake, the nth lake becomes full of water. If it rains over a lake which is 
 *  full of water, there will be a flood. Your goal is to avoid the flood in any lake.

Given an integer array rains where:

rains[i] > 0 means there will be rains over the rains[i] lake.
rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
Return an array ans where:

ans.length == rains.length
ans[i] == -1 if rains[i] > 0.
ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
If there are multiple valid answers return any of them. If it is impossible to avoid flood return 
an empty array.

Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake,
 nothing changes. (see example 4)
 */

//1488. Avoid Flood in The City
//Time ==> O(nlogn), bcoz removal from set is O(logn).
public class AvoidFloodInTheCity {

	public int[] avoidFlood(int[] rains) {

		HashMap<Integer, Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();

		int ans[] = new int[rains.length];

		for (int i = 0; i < rains.length; i++) {

			if (rains[i] == 0) {
				set.add(i);
			} else if (!map.containsKey(rains[i])) {
				map.put(rains[i], i);
				ans[i] = -1;
			} else {
				int day = map.get(rains[i]);
				int c = 0;
				for (int x : set) {
					if (x > day) {
						set.remove(x);
						map.put(rains[i], i);
						ans[x] = rains[i];
						ans[i] = -1;
						c++;
						break;
					}
				}

				if (c == 0) {
					return new int[] {};
				}

			}

		}

		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == 0) {
				ans[i] = 1;
			}
		}

		return ans;

	}

}
