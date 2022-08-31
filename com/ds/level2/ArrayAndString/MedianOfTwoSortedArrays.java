package com.ds.level2.ArrayAndString;

//4. Median of Two Sorted Arrays

/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted
 *  arrays.

The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;

		int m1 = (m + n + 1) / 2;
		int m2 = (m + n + 2) / 2;

		// for odd (m+n) m1 and m2 will be same.

		int median1 = getKthElementFromMergedArray(nums1, nums2, m1, 0, 0);
		int median2 = getKthElementFromMergedArray(nums1, nums2, m2, 0, 0);

		return (median1 + median2) / 2.0;

	}

	// this is optimized O(long(m+n))
	public int getKthElementFromMergedArray(int[] nums1, int[] nums2, int k, int s1, int s2) {

		if (s1 >= nums1.length) {
			return nums2[s2 + k - 1];
		}

		if (s2 >= nums2.length) {
			return nums1[s1 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}

		int el1 = Integer.MAX_VALUE;
		int el2 = Integer.MAX_VALUE;

		if (s1 + k / 2 - 1 < nums1.length) {
			el1 = nums1[s1 + k / 2 - 1];
		}

		if (s2 + k / 2 - 1 < nums2.length) {
			el2 = nums2[s2 + k / 2 - 1];
		}

		if (el1 < el2) {
			return getKthElementFromMergedArray(nums1, nums2, k - k / 2, s1 + k / 2, s2);
		} else {
			return getKthElementFromMergedArray(nums1, nums2, k - k / 2, s1, s2 + k / 2);
		}

	}

	// this take O(m+n)
	public int getKthElementFromMergedArray2(int[] nums1, int[] nums2, int k, int s1, int s2) {

		int c = 0;

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
				c++;
				if (c == k) {
					return nums1[i - 1];
				}
			} else {
				j++;
				c++;
				if (c == k) {
					return nums2[j - 1];
				}
			}

		}

		while (i < nums1.length) {
			i++;
			c++;
			if (c == k) {
				return nums1[i - 1];
			}
		}

		while (j < nums2.length) {
			j++;
			c++;
			if (c == k) {
				return nums2[j - 1];
			}
		}

		return -1;

	}

}
