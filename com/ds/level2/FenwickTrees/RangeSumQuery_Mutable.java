package com.ds.level2.FenwickTrees;

//307. Range Sum Query - Mutable

/*
 * Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right
 inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */

public class RangeSumQuery_Mutable {

	class NumArray {
		class Fenwick {
			int[] farr;

			Fenwick(int[] nums) {
				this.farr = new int[nums.length + 1];
			}

			int sum(int pos) {
				int res = 0;

				while (pos > 0) {
					res += farr[pos];
					pos = pos - rsb(pos);
				}

				return res;
			}

			void update(int pos, int delta) {

				while (pos < farr.length) {
					farr[pos] += delta;
					pos = pos + rsb(pos);
				}

			}

			// returns the right most set bit of x.
			private int rsb(int x) {
				return (x & -x);
			}
		}

		Fenwick ft;
		int[] oarr;

		public NumArray(int[] nums) {
			ft = new Fenwick(nums);
			oarr = nums;
			for (int i = 0; i < nums.length; i++) {
				int pos = i + 1;
				int val = nums[i];
				ft.update(pos, val);
			}
		}

		public void update(int index, int val) {
			int delta = val - oarr[index];
			int pos = index + 1;
			ft.update(pos, delta);
			oarr[index] = val;
		}

		public int sumRange(int left, int right) {

			int lpos = left + 1;
			int rpos = right + 1;

			int sumBeforeLeft = ft.sum(lpos - 1);
			int sumTillright = ft.sum(rpos);

			return sumTillright - sumBeforeLeft;

		}

	}

}
