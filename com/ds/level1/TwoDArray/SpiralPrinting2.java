package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class SpiralPrinting2 {

	// this time we are printing box by box.
	// first outer box then inner box and so on.

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int col = sc.nextInt();
		int ar[][] = new int[r][col];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		int c = 0;
		int tne = r * col;
		int minr = 0;
		int minc = 0;
		int maxr = r - 1;
		int maxc = col - 1;

		while (c < tne) {

			// left wall
			for (int i = minr; i <= maxr && c < tne; i++) {
				System.out.println(ar[i][minc]);
				c++;
			}

			minc++;

			// bottom wall
			for (int j = minc; j <= maxc && c < tne; j++) {
				System.out.println(ar[maxr][j]);
				c++;
			}
			maxr--;

			// right wall

			for (int i = maxr; i >= minr && c < tne; i--) {
				System.out.println(ar[i][maxc]);
				c++;
			}
			maxc--;

			// top wall

			for (int j = maxc; j >= minc && c < tne; j--) {
				System.out.println(ar[minr][j]);
				c++;
			}
			minr++;
		}

	}

}
