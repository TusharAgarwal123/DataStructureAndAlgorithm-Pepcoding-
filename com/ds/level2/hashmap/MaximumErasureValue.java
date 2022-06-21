package com.ds.level2.hashmap;

import java.util.HashMap;

//leetcode 1695. Maximum Erasure Value

/*
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 */

public class MaximumErasureValue {

	public int maximumUniqueSubarray(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

//         HashSet<Integer> set=new HashSet<>();
//         int sum=0;
//         int ans=0;
//         int left=0;

//         int right=0;

//         while(right<nums.length){

//             if(set.contains(nums[right])){
//                 sum-=nums[left];
//                 set.remove(nums[left]);
//                 left++;
//                 continue;
//             }

//             sum+=nums[right];
//             ans=Math.max(ans,sum);
//             set.add(nums[right]);
//             right++;

//         }

//         return ans;

		HashMap<Integer, Integer> map = new HashMap<>();

		int i = 0;
		int j = -1;

		int ans = 0;

		int sum = 0;

		while (i < nums.length) {

			int val = nums[i];

			if (map.containsKey(val)) {

				while (true) {
					ans = Math.max(ans, sum);
					int rv = nums[j + 1];
					sum = sum - rv;
					j++;
					map.remove(rv);
					if (rv == val) {
						break;
					}
				}

			} else {
				sum += val;
				map.put(val, 1);
				i++;
			}

		}

		ans = Math.max(ans, sum);

		return ans;

	}

}
