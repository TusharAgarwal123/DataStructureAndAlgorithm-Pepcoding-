package com.ds.level2.recursion_backtracking;

import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are 
     present in dictionary.
 */
public class Word_Break_I {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for (int i = 0; i < n; i++) {
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence, "", dict);
	}

	// we will process the string we have given and check all it's prefix that it
	// make any word that is present
	// in dictionary or not, if present then we will add it in sentence.
	public static void wordBreak(String str, String ans, HashSet<String> dict) {
		// write your code here

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			String prefix = str.substring(0, i + 1);
			if (dict.contains(prefix)) {
				String ros = str.substring(i + 1);
				wordBreak(ros, ans + prefix + " ", dict);
			}

		}

	}

}
