package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 1. You are given two integers N and M, and an array(arr) of numbers with length M.
2. N represents the total number of tasks assigned to a group of 5 students.
3. Out of these five students, three students completed M number of tasks of their choices and left the group.
4. Tasks completed by these students are represented by the given array.
5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
6. They decided to complete the remaining tasks in an alternate way -
   First of the remaining tasks will be completed by s1
   Second of the remaining tasks will be completed by s2
   Third of the remaining tasks will be completed by s1.. and so on.    
7. You have to find the tasks that s1 and s2 have to complete.
 */
public class TaskCompletion {

	public static void completeTask(int n, int m, int[] arr) {
		// write your code here

		HashSet<Integer> set = new HashSet<>();
		for (int x : arr) {
			set.add(x);
		}

		ArrayList<Integer> set1 = new ArrayList<>();
		ArrayList<Integer> set2 = new ArrayList<>();

		boolean s1 = true;

		for (int i = 1; i <= n; i++) {
			if (!set.contains(i)) {
				if (s1) {
					set1.add(i);
				} else {
					set2.add(i);
				}

				s1 = !s1;
			}
		}

		for (int x : set1) {
			System.out.print(x + " ");
		}

		System.out.println();

		for (int x : set2) {
			System.out.print(x + " ");
		}
		System.out.println();

	}

}
