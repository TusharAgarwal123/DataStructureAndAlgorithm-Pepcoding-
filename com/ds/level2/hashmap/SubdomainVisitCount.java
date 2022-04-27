package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 1. A website domain like "www.pepcoding.com" consists of various subdomains like 
   "com" at the topmost level, "pepcoding.com" at the next level, and "www.pepcoding.com"
    at the lowest level.
2. When you visit a domain like "www.pepcoding.com", you will also visit its parent domains 
"pepcoding.com" and "com".   
3. You are given N number of strings where every string contains a number and a domain separated
 by a space, where the number represents the visit count of the domain.
4. You have to find the number of visits for each sub-domain.
 */

//811. Subdomain Visit Count
public class SubdomainVisitCount {

	public static List<String> subdomainVisits(String[] cpdomains) {
		// write your code here

		HashMap<String, Integer> map = new HashMap<>();
		for (String str : cpdomains) {

			String tmp[] = str.split(" ");
			int visitCount = Integer.parseInt(tmp[0]);

			String words[] = tmp[1].split("\\.");

			StringBuilder sb = new StringBuilder();

			for (int idx = words.length - 1; idx >= 0; idx--) {
				if (idx == words.length - 1) {
					sb.append(words[idx]);
				} else {
					sb.insert(0, ".");
					sb.insert(0, words[idx]);
				}

				String domain = sb.toString();
				if (map.containsKey(domain)) {
					map.put(domain, map.get(domain) + visitCount);
				} else {
					map.put(domain, visitCount);
				}

			}

		}

		List<String> list = new ArrayList<>();
		for (String str : map.keySet()) {
			StringBuilder sb = new StringBuilder();
			sb.append(map.get(str));
			sb.append(" ");
			sb.append(str);

			list.add(sb.toString());
		}

		return list;
	}

}
