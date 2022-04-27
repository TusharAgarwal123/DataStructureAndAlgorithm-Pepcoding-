package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
    crossword puzzle. 
2. You are also given n number of words which need to be filled into the crossword.
3. Cells containing '-' are to be filled with the given words.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
 */
public class CrosswordPuzzle {

	public static void solution(char[][] arr, String[] words, int vidx) {
		// write your code here

		if (vidx == words.length) {
			print(arr);
			return;
		}

		String word = words[vidx];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (canPlaceVertically(arr, i, j, word)) {

					boolean[] placed = new boolean[word.length()];
					placeVertically(arr, i, j, word, placed);
					solution(arr, words, vidx + 1);
					unPlaceVertically(arr, i, j, placed);

				}

				if (canPlaceHorizontallly(arr, i, j, word)) {

					boolean[] placed = new boolean[word.length()];
					placeHorizontallly(arr, i, j, word, placed);
					solution(arr, words, vidx + 1);
					unPlaceHorizontallly(arr, i, j, placed);

				}

			}
		}

	}

	public static void placeVertically(char[][] arr, int i, int j, String word, boolean[] placed) {

		for (int k = 0; k < word.length(); k++) {
			if (arr[i + k][j] == '-') {
				arr[i + k][j] = word.charAt(k);
				placed[k] = true; // true means we are putting character.
			} else { // character is already present.
				placed[k] = false;
			}
		}

	}

	public static void unPlaceVertically(char[][] arr, int i, int j, boolean[] placed) {

		for (int k = 0; k < placed.length; k++) {
			if (placed[k] == true) {
				arr[i + k][j] = '-';
			}
		}

	}

	public static void placeHorizontallly(char[][] arr, int i, int j, String word, boolean[] placed) {

		for (int k = 0; k < word.length(); k++) {
			if (arr[i][j + k] == '-') {
				arr[i][j + k] = word.charAt(k);
				placed[k] = true; // true means we are putting character.
			} else { // character is already present.
				placed[k] = false;
			}
		}

	}

	public static void unPlaceHorizontallly(char[][] arr, int i, int j, boolean[] placed) {

		for (int k = 0; k < placed.length; k++) {
			if (placed[k] == true) {
				arr[i][j + k] = '-';
			}
		}

	}

	public static boolean canPlaceVertically(char[][] arr, int i, int j, String words) {

		for (int k = 0; k < words.length(); k++) {

			if (k + i >= arr.length) {
				return false;
			}

			else if (arr[k + i][j] == '-' || arr[k + i][j] == words.charAt(k)) {

			} else {
				return false;
			}
		}

		// this check is optional, it just check weather word is perfect fit or not.
		// if(i+words.length()==arr.length || arr[i+words.length()][j]=='+'){
		// return true;
		// }else{
		// return false;
		// }

		return true;

	}

	public static boolean canPlaceHorizontallly(char[][] arr, int i, int j, String words) {

		for (int k = 0; k < words.length(); k++) {
			if (k + j >= arr[0].length) {
				return false;
			}

			else if (arr[i][k + j] == '-' || arr[i][k + j] == words.charAt(k)) {

			} else {
				return false;
			}
		}

		return true;

	}

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = scn.next();
		}
		solution(arr, words, 0);
	}

}
