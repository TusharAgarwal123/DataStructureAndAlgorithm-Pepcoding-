package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
 */
public class FindItineraryFromTickets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);
			set.add(s1);
		}

		for (String dest : map.values()) {
			if (set.contains(dest)) {
				set.remove(dest);
			}
		}

		String strt = null;
		for (String ss : set) {
			strt = ss;
		}

		while (true) {
			if (map.containsKey(strt)) {
				System.out.print(strt + " -> ");
				strt = map.get(strt);
			} else {
				System.out.println(strt + ".");
				break;
			}
		}

	}

}
