package com.ds.level2.recursion_backtracking;

/*
 * You are given an m x n matrix board, representing the current 
 * state of a crossword puzzle. The crossword contains lowercase English letters (from solved words), ' ' to represent any empty cells, and '#' to represent any blocked cells.

A word can be placed horizontally (left to right or right to left)
 or vertically (top to bottom or bottom to top) in the board if:

It does not occupy a cell containing the character '#'.
The cell each letter is placed in must either be ' ' (empty) or match the letter already on the board.
There must not be any empty cells ' ' or other lowercase letters directly
 left or right of the word if the word was placed horizontally.
There must not be any empty cells ' ' or other lowercase letters directly
 above or below the word if the word was placed vertically.
Given a string word, return true if word can be placed in board, or false otherwise.
 */

//2018. Check if Word Can Be Placed In Crossword
public class CheckifWordCanBePlacedInCrossword {

	public boolean placeWordInCrossword(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (canPlaceVerticallyTopToBottom(board, i, j, word)
						|| canPlaceVerticallyBottomToTop(board, i, j, word)) {

					return true;

				}

				if (canPlaceHorizontallyLeftToRight(board, i, j, word)
						|| canPlaceHorizontallyRightToLeft(board, i, j, word)) {

					return true;

				}

			}
		}

		return false;

	}

	public boolean canPlaceVerticallyTopToBottom(char[][] board, int i, int j, String word) {

		for (int k = 0; k < word.length(); k++) {

			if (i + k >= board.length) {
				return false;
			} else if (board[i + k][j] == ' ' || board[i + k][j] == word.charAt(k)) {
				continue;
			} else {
				return false;
			}

		}

		if (i > 0) {
			if (board[i - 1][j] != '#') {
				return false;
			}
		}

		if (i + word.length() == board.length || board[i + word.length()][j] == '#') {
			return true;
		} else {
			return false;
		}

		// return true;

	}

	public boolean canPlaceVerticallyBottomToTop(char[][] board, int i, int j, String word) {

		for (int k = 0; k < word.length(); k++) {

			if (i - k < 0) {
				return false;
			} else if (board[i - k][j] == ' ' || board[i - k][j] == word.charAt(k)) {
				continue;
			} else {
				return false;
			}

		}

		if (i < board.length - 1) {
			if (board[i + 1][j] != '#') {
				return false;
			}
		}

		if (i - word.length() == -1 || board[i - word.length()][j] == '#') {
			return true;
		} else {
			return false;
		}

		// return true;

	}

	public boolean canPlaceHorizontallyLeftToRight(char[][] board, int i, int j, String word) {

		for (int k = 0; k < word.length(); k++) {

			if (j + k >= board[0].length) {
				return false;
			} else if (board[i][j + k] == ' ' || board[i][j + k] == word.charAt(k)) {
				continue;
			} else {
				return false;
			}

		}

		if (j > 0) {
			if (board[i][j - 1] != '#') {
				return false;
			}
		}

		if (j + word.length() == board[0].length || board[i][j + word.length()] == '#') {
			return true;
		} else {
			return false;
		}

		// return true;

	}

	public boolean canPlaceHorizontallyRightToLeft(char[][] board, int i, int j, String word) {

		for (int k = 0; k < word.length(); k++) {

			if (j - k < 0) {
				return false;
			} else if (board[i][j - k] == ' ' || board[i][j - k] == word.charAt(k)) {
				continue;
			} else {
				return false;
			}

		}

		if (j < board[0].length - 1) {
			if (board[i][j + 1] != '#') {
				return false;
			}
		}

		if (j - word.length() == -1 || board[i][j - word.length()] == '#') {
			return true;
		} else {
			return false;
		}

		// return true;

	}

}
