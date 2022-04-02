package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * 1. You are given three numbers A, B, and X.
2. You have to print all-powerful numbers that have value less than or equal to X.
3. A number is powerful if it is equal to x^i + y^j for i >= 0 and j >= 0.
 */

//970. Powerful Integers
public class PowerfulNumber {

	// both approach time complexity is same.
	public List<Integer> powerfulIntegers(int x, int y, int bound) {

		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		if (bound <= 1) {
			return list;
		}

		for (int vx = 1; vx < bound; vx *= x) {
			for (int vy = 1; vy < bound; vy *= y) {
				int val = vy + vx;
				if (val <= bound) {
					set.add(val);
				}
				if (y == 1) {
					break;
				}
			}
			if (x == 1) {
				break;
			}
		}

		list.addAll(set);
		return list;

	}

	// in this approach we have break question into different cases.
	public List<Integer> powerfulIntegers2(int x, int y, int bound) {

		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();

		if (bound <= 1) {
			return list;
		} else if (x == 1 && y == 1) {
			list.add(2);
			return list;
		} else if (x == 1) {

			for (int vy = 1; vy < bound; vy *= y) {
				int val = 1 + vy;
				if (!set.contains(val)) {
					set.add(val);
					list.add(val);
				}
			}

		} else if (y == 1) {
			for (int vx = 1; vx < bound; vx *= x) {
				int val = 1 + vx;
				if (!set.contains(val)) {
					set.add(val);
					list.add(val);
				}
			}
		} else {

			for (int vx = 1; vx < bound; vx *= x) {
				for (int vy = 1; vx + vy <= bound; vy *= y) {
					int val = vx + vy;
					if (!set.contains(val)) {
						set.add(val);
						list.add(val);
					}
				}
			}

		}

		return list;

	}

}
