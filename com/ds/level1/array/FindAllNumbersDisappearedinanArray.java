package com.ds.level1.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {

	}

	public List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> missing = new ArrayList<>();
		HashSet<Integer> numbers = new HashSet<>();
		for (int x : nums) {
			numbers.add(x);
		}

		for (int i = 1; i <= nums.length; i++) {
			if (!numbers.contains(i)) {
				missing.add(i);
			}
		}

		return missing;
	}

}
