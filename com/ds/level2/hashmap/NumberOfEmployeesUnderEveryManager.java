package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
 */
public class NumberOfEmployeesUnderEveryManager {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		String ceo = "";

		HashMap<String, HashSet<String>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] parts = scn.nextLine().split(" ");
			String emp = parts[0];
			String man = parts[1];

			if (man.equals(emp)) {
				ceo = man;
				continue;
			}

			if (map.containsKey(man)) {
				HashSet<String> emps = map.get(man);
				emps.add(emp);
			} else {
				HashSet<String> emps = new HashSet<>();
				emps.add(emp);
				map.put(man, emps);
			}
		}

		HashMap<String, Integer> ans = new HashMap<>();
		size(map, ceo, ans);

		for (String emp : ans.keySet()) {
			System.out.println(emp + " " + ans.get(emp));
		}
	}

	public static int size(HashMap<String, HashSet<String>> map, String ceo, HashMap<String, Integer> ans) {
		if (map.containsKey(ceo) == false) {
			ans.put(ceo, 0);
			return 1;
		}

		int sz = 0;

		for (String emp : map.get(ceo)) {
			int cs = size(map, emp, ans);
			sz += cs;
		}
		ans.put(ceo, sz);
		return sz + 1;
	}

}
