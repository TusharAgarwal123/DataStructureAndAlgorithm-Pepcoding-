package com.ds.level1.array;

import java.util.Scanner;

public class DifferenceOfTwoArray {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int ar1[] = new int[n1];
		for (int i = 0; i < n1; i++) {
			ar1[i] = sc.nextInt();
		}

		int n2 = sc.nextInt();
		int ar2[] = new int[n2];
		for (int i = 0; i < n2; i++) {
			ar2[i] = sc.nextInt();
		}

		int diff[] = new int[n2];

		int i = n1 - 1;
		int j = n2 - 1;
		int k = diff.length - 1;
		int b = 0;

		while (k >= 0) {

			int s = 0;
			int f = 0;
			if (j >= 0) {
				s = ar2[j];
			}

			if (i >= 0) {
				f = ar1[i];
			}
			int d = s - f - b;

			if (d < 0) {
				b = 1;
				d = d + 10;
			} else {
				b = 0;
			}

			diff[k] = d;

			i--;
			j--;
			k--;

		}

		int id = 0;
		while (id < diff.length) {
			if (diff[id] != 0) {
				break;
			} else {
				id++;
			}
		}

		for (int x = id; x < diff.length; x++) {
			System.out.println(diff[x]);
		}

	}

}
