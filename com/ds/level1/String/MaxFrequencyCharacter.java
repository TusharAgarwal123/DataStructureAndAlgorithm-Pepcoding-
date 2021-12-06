package com.ds.level1.String;

public class MaxFrequencyCharacter {

	public static void main(String[] args) {
		String s = "abacdacaa";

		int ar[] = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int idx = ch - 'a';
			ar[idx]++;
		}

		int maxIndex = 0;
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] > ar[maxIndex]) {
				maxIndex = i;
			}
		}

		char maxChar = (char) ('a' + maxIndex);
		System.out.println(maxChar);
		
		
		//if string consist of both upper and lower case letter
//		int ar[] = new int[256];
//
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			ar[ch]++;
//		}
//
//		int maxIndex = 0;
//		for (int i = 1; i < ar.length; i++) {
//			if (ar[i] > ar[maxIndex]) {
//				maxIndex = i;
//			}
//		}
//
//		char maxChar = (char) (maxIndex);
//		System.out.println(maxChar);

	}

}
