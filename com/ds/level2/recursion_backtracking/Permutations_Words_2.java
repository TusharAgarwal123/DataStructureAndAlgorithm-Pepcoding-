package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
 */
public class Permutations_Words_2 {

	// on level we are putting character and in options we have boxes.
	public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {
// write your code here

		if (cc == str.length()) {

			for (char ch : spots) {
				System.out.print(ch);
			}

			System.out.println();

			return;

		}

		char ch = str.charAt(cc);
		int oops = lastOccurence.get(ch);

		for (int i = oops + 1; i < spots.length; i++) {
			if (spots[i] == null) {
				spots[i] = ch;
				lastOccurence.put(ch, i);
				generateWords(cc + 1, str, spots, lastOccurence);
				spots[i] = null;
				lastOccurence.put(ch, oops);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Character[] spots = new Character[str.length()];
		HashMap<Character, Integer> lastOccurence = new HashMap<>();
		for (char ch : str.toCharArray()) {
			lastOccurence.put(ch, -1);
		}

		generateWords(0, str, spots, lastOccurence);
	}

}
