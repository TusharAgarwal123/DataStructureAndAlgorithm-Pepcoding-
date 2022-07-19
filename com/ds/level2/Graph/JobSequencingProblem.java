package com.ds.level2.Graph;

import java.util.Arrays;

/*
 * Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
 We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.
 */

public class JobSequencingProblem {

	class Job {
		int id, profit, deadline;

		Job(int x, int y, int z) {
			this.id = x;
			this.deadline = y;
			this.profit = z;
		}
	}

	int[] JobScheduling(Job arr[], int n) {
		// Your code here

		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

		parent = new int[101]; // largest deadline is 100 given in constraint.

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int c = 0;
		int pr = 0; // profit.

		for (Job j : arr) {

			int x = j.deadline;
			int xl = find(x);

			if (xl > 0) {
				// job j is done on xl day.
				c++;
				pr += j.profit;
				parent[xl] = find(xl - 1);
			}

		}

		return new int[] { c, pr };

	}

	int parent[];

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}

}
