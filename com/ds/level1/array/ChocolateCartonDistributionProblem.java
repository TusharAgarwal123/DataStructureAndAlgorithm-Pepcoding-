package com.ds.level1.array;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateCartonDistributionProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int m = sc.nextInt();

		Arrays.sort(ar);

		int s = 0;
		int e = m - 1;

		int min = Integer.MAX_VALUE;

		while (e < n) {
			int diff = ar[e] - ar[s];
			min = Math.min(min, diff);
			s++;
			e++;
		}

		System.out.println(min);

	}

}
