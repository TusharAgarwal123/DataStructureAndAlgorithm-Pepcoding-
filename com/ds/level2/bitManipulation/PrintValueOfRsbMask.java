package com.ds.level2.bitManipulation;

import java.util.Scanner;

/*
 * 1. You are given a number n.
2. You have to print the right-most set bit mask.
 */
public class PrintValueOfRsbMask {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		// int i=1;
		// while((n&i)==0){
		// i=i<<1;
		// }

		int rb = n & -n;

		System.out.println(Integer.toBinaryString(rb));

	}

}
