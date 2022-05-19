package com.ds.level2.recursion_backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once. 
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if 
     you start and stop collecting gold from any position in the grid that has some gold.
 */
public class GoldMine_2 {

	static int max = 0;

	public static void getMaxGold(int[][] arr) {
		// write your code here

		boolean visited[][] = new boolean[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0 && visited[i][j] == false) {
					ArrayList<Integer> list = new ArrayList<>();

					traverAndCollectGold(arr, i, j, visited, list);

					int sum = 0;
					for (int x : list) {
						sum += x;
					}

					max = Math.max(max, sum);
				}
			}
		}

	}

	public static void traverAndCollectGold(int ar[][], int i, int j, boolean[][] visited, ArrayList<Integer> bag) {

		if (i < 0 || j < 0 || i >= ar.length || j >= ar[0].length || visited[i][j] == true || ar[i][j] == 0) {
			return;
		}

		visited[i][j] = true;
		bag.add(ar[i][j]);

		traverAndCollectGold(ar, i + 1, j, visited, bag);
		traverAndCollectGold(ar, i - 1, j, visited, bag);
		traverAndCollectGold(ar, i, j + 1, visited, bag);
		traverAndCollectGold(ar, i, j - 1, visited, bag);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}

}
