package com.ds.level1.String;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

	public static void solution(ArrayList<Integer> al) {
		// write your code here

		for (int i = al.size() - 1; i >= 0; i--) {
			int val = al.get(i);
			if (isPrime(val) == true) {
				al.remove(i);
			}
		}

	}

	public static boolean isPrime(int val) {

		for (int i = 2; i * i <= val; i++) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;

	}

}
