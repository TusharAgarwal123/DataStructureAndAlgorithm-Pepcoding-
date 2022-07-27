package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//763. Partition Labels

/*
 * You are given a string s. We want to partition the string into as many parts as possible so that each
 *  letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string
 should be s.

Return a list of integers representing the size of these parts.


 */

public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {

		int map[] = new int[26];
		List<Integer> list = new ArrayList<>();

		Arrays.fill(map, -1);

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map[ch - 'a'] = i;
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			end = Math.max(end, map[ch - 'a']);

			if (i == end) {
				int len = end - start + 1;
				list.add(len);
				end = i + 1;
				start = i + 1;
			}

		}

		return list;

	}

}
