package com.ds.level2.DP;

import java.util.HashSet;
import java.util.List;

//139. Word Break

/*
 * Given a string A and a dictionary of n words B, find out if A can be segmented into a space-separated
 *  sequence of dictionary words.

Note: From the dictionary B each word can be taken any number of times and in any order.

 */

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {

		HashSet<String> set = new HashSet<>();
		for (String str : wordDict) {
			set.add(str);
		}

		boolean[] dp = new boolean[s.length()];

		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.substring(0, i + 1))) {
				dp[i] = true;
			} else {
				for (int j = 0; j < i; j++) {
					if (dp[j] == true && set.contains(s.substring(j + 1, i + 1))) {
						dp[i] = true;
					}
				}
			}
		}

		return dp[s.length() - 1];

	}

}
