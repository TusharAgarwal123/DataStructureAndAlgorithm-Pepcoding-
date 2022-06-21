package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 210. Course Schedule II

/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 *  course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		ArrayList<Integer>[] graph = new ArrayList[numCourses];

		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		// building graph.
		for (int i = 0; i < prerequisites.length; i++) {
			int f = prerequisites[i][0];
			int s = prerequisites[i][1];

			graph[f].add(s);

		}

		// applying kanh's algorithm.

		int in[] = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			for (int n : graph[i]) {
				in[n]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int v = 0; v < numCourses; v++) {
			if (in[v] == 0) { // adding only those which don't have any dependency.
				q.add(v);
			}
		}

		int ans[] = new int[numCourses];
		int idx = numCourses - 1;

		while (q.size() > 0) {
			int rem = q.remove();
			ans[idx] = rem;
			idx--;

			for (int n : graph[rem]) {
				in[n]--;

				if (in[n] == 0) {
					q.add(n);
				}
			}
		}

		if (idx == -1) {
			return ans;
		} else {
			return new int[] {};
		}

	}

}
