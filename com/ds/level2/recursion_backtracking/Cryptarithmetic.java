package com.ds.level2.recursion_backtracking;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 1. You are given three strings s1, s2 and s3.
2. First two are supposed to add and form third. s1 + s2 = s3
3. You have to map each individual character to a digit, so that the above equation holds true.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing the signature. The judge can't force you but intends you to teach a concept.
 */
public class Cryptarithmetic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		String s3 = scn.nextLine();

		HashMap<Character, Integer> charIntMap = new HashMap<>();
		String unique = "";
		for (int i = 0; i < s1.length(); i++) {
			if (!charIntMap.containsKey(s1.charAt(i))) {
				charIntMap.put(s1.charAt(i), -1);
				unique += s1.charAt(i);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!charIntMap.containsKey(s2.charAt(i))) {
				charIntMap.put(s2.charAt(i), -1);
				unique += s2.charAt(i);
			}
		}

		for (int i = 0; i < s3.length(); i++) {
			if (!charIntMap.containsKey(s3.charAt(i))) {
				charIntMap.put(s3.charAt(i), -1);
				unique += s3.charAt(i);
			}
		}

		boolean[] usedNumbers = new boolean[10];
		solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
	}

	public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
			String s1, String s2, String s3) {
		// write your code here

		if (idx == unique.length()) {

			int sum1 = getSum(s1, charIntMap);
			int sum2 = getSum(s2, charIntMap);
			int sum3 = getSum(s3, charIntMap);

			if (sum1 + sum2 == sum3) {
				for (int i = 0; i < 26; i++) {

					char ch = (char) (i + 'a');
					if (charIntMap.containsKey(ch)) {
						System.out.print(ch + "-" + charIntMap.get(ch) + " ");
					}

				}
				System.out.println();
			}

			return;
		}

		for (int i = 0; i <= 9; i++) {

			if (usedNumbers[i] == false) {
				usedNumbers[i] = true;
				charIntMap.put(unique.charAt(idx), i);
				solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
				usedNumbers[i] = false;
				charIntMap.put(unique.charAt(idx), -1);
			}

		}

	}

	public static int getSum(String str, HashMap<Character, Integer> charIntMap) {

		StringBuilder sb = new StringBuilder();

		for (char ch : str.toCharArray()) {

			int num = charIntMap.get(ch);
			sb.append(num);

		}

		return Integer.parseInt(sb.toString());

	}

}
