package com.ds.leetcode.may;

import java.util.ArrayList;
import java.util.List;

//216. Combination Sum III
public class CombinationSumIII {

	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {

		// List<List<Integer>> ans=new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		solve(k, n, list, ans, 0, 1);

		// solve(1,k,n,0,0,new boolean[10],list);

		return ans;

	}

	public void solve(int cs, int ts, int n, int ssf, int lc, boolean visited[], List<Integer> list) {

		if (cs > ts) {
			if (ssf == n) {
				ans.add(list);
			}
			return;
		}

		for (int i = lc + 1; i < 10; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				list.add(i);
				solve(cs + 1, ts, n, ssf + i, i, visited, new ArrayList<>(list));
				visited[i] = false;
				list.remove(list.size() - 1);
			}
		}

	}

	public void solve(int k, int n, List<Integer> list, List<List<Integer>> ans, int ssf, int i) {

		if (ssf > n) {
			return;
		}

		// if(k==0){
		// if(ssf==n){
		// ans.add(list);
		// }
		// return;
		// }

		if (i == 10) {
			if (k == 0 && ssf == n) {
				ans.add(list);
			}
			return;
		}

		list.add(i);
		solve(k - 1, n, new ArrayList<>(list), ans, ssf + i, i + 1);

		list.remove(list.size() - 1);
		solve(k, n, list, ans, ssf, i + 1);

	}

}
