package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given two numbers which represent the numerator and denominator of a fraction.
2. You have to convert this fraction into a decimal.
3. If the decimals are repeating recursively, then you have to put the recurring sequence inside a bracket.
 */

//leetcode 166.
public class RecurringSequenceInAFraction {

	public static String solution(int numerator, int denominator) {

		StringBuilder sb = new StringBuilder();

		int quo = numerator / denominator;
		int rem = numerator % denominator;

		sb.append(quo);

		if (rem == 0) {
			return sb.toString();
		} else {
			sb.append(".");
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		while (rem != 0) {
			if (!map.containsKey(rem)) {

				map.put(rem, sb.length());
				rem = rem * 10;
				quo = rem / denominator;
				rem = rem % denominator;

				sb.append(quo);

			} else {
				int len = map.get(rem);
				sb.insert(len, "(");
				sb.append(")");
				break;
			}
		}

		return sb.toString();
	}

	// this solution will accept on leetcode, it handles the negative number cases
	// also.
	public String fractionToDecimal(int num, int deno) {

		StringBuilder sb = new StringBuilder();
		if (num == 0) {
			return "0";
		}

		if ((num < 0 && deno > 0) || (num > 0 && deno < 0)) {
			sb.append("-");
		}

		long numerator = Math.abs((long) num);
		long denominator = Math.abs((long) deno);

		long quo = numerator / denominator;
		long rem = numerator % denominator;

		sb.append(quo);

		if (rem == 0) {
			return sb.toString();
		} else {
			sb.append(".");
		}

		HashMap<Long, Integer> map = new HashMap<>();
		while (rem != 0) {
			if (!map.containsKey(rem)) {

				map.put(rem, sb.length());
				rem = rem * 10;
				quo = rem / denominator;
				rem = rem % denominator;

				sb.append(quo);

			} else {
				int len = map.get(rem);
				sb.insert(len, "(");
				sb.append(")");
				break;
			}
		}

		return sb.toString();

	}

}
