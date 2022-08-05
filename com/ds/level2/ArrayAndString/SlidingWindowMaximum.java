package com.ds.level2.ArrayAndString;

import java.util.Stack;

//239. Sliding Window Maximum

/*
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the
 *  very left of the array to the very right. You can only see the k numbers in the window. Each time the 
 *  sliding window moves right by one position.

Return the max sliding window.
 */

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {

		int arr[] = new int[nums.length - k + 1];
		int ans[] = nextGreaterOnRight(nums);

		int j = 0;
		for (int i = 0; i <= nums.length - k; i++) {
			if (j < i) {
				j = i;
			}

			while (ans[j] < i + k) {
				j = ans[j];
			}

			arr[i] = nums[j];
		}

		return arr;

	}

	public int[] nextGreaterOnRight(int[] ar) {

		int ans[] = new int[ar.length];
		Stack<Integer> st = new Stack<Integer>();

		ans[ar.length - 1] = ar.length;
		st.push(ar.length - 1);

		for (int i = ar.length - 2; i >= 0; i--) {
			while (st.size() > 0 && ar[st.peek()] < ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = ar.length;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);
		}

//         st.push(0);
//          for(int i=1;i<ar.length;i++){
//             while(st.size()>0 && ar[st.peek()]<=ar[i]){
//                 int idx=st.pop();
//                 ans[idx]=i;
//             }

//             st.push(i);
//         }

//         while(st.size()>0){
//             int idx=st.pop();
//                 ans[idx]=ar.length;
//         }

		return ans;

	}

}
