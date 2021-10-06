package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class ExitPointOfMatrix {

	// we have an 2D array containing only 0 and 1.a man enter from (0,0) initially
	// it go in east direction
	// if 0 comes it will go straight and if 1 comes it will take 90 degree turn in
	// right direction,
	// you have to find the exit point .

	// Solution: as there are only 4 direction possible east, west, north, south.
	// east=0,south=1,west=2,north=3.

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ar[][] = new int[r][c];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		int i = 0;
		int j = 0;
		int dir = 0;

		while (true) {

			dir = (dir + ar[i][j]) % 4;

			if (dir == 0) { // east
				j++;
				if (j == ar[0].length) {
					j--;
					break;
				}
			} else if (dir == 1) { // south
				i++;
				if (i == ar.length) {
					i--;
					break;
				}
			} else if (dir == 2) { // west
				j--;
				if (j == -1) {
					j++;
					break;
				}
			} else { // north
				i--;
				if (i == -1) {
					i++;
					break;
				}
			}
		}

		System.out.println(i);
		System.out.println(j);

	}

}
