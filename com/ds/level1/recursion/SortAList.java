package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.List;

public class SortAList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(7);
		list.add(1);
		list.add(5);
		list.add(3);
		System.out.println(list);
		sortList(list);
		System.out.println(list);

	}

	public static void sortList(List<Integer> list) {

		if (list.size() == 1) {
			return;
		}

		int temp = list.remove(0);
		sortList(list);
		insertAtSortedPosition(list, temp);

	}

	public static void insertAtSortedPosition(List<Integer> list, int k) {

		if (list.size() == 0 || list.get(list.size() - 1) <= k) {
			list.add(k);
			return;
		}

		int temp = list.remove(list.size() - 1);
		insertAtSortedPosition(list, k);
		list.add(temp);

	}

}
