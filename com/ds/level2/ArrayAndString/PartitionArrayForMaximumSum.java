package com.ds.level2.ArrayAndString;

/*
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 */

//1043 leetcode

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    //memoraization -> O(n)*O(k) and space -> O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return findMax(0,arr,k,n,dp);
    }

    public int findMax(int ind, int[] arr,int k,int n,int[] dp){
        if(ind==arr.length){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }

        int maxSum = Integer.MIN_VALUE;
        int len=0;
        int max = Integer.MIN_VALUE;
        for(int i=ind;i<Math.min(ind+k,n);i++){
            len++;
            max = Math.max(max,arr[i]);
            int sum = len*max;
            maxSum = Math.max(maxSum,sum+findMax(i+1,arr,k,n,dp));
        }

        return dp[ind]=maxSum;
    }


    //recursive approach -->TLE, time -> exponential
    public int maxSumAfterPartitioning2(int[] arr, int k) {

        int n = arr.length;
        return findMax2(0,arr,k,n);
    }

    public int findMax2(int ind, int[] arr,int k,int n){
        if(ind==arr.length){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int len=0;
        int max = Integer.MIN_VALUE;
        for(int i=ind;i<Math.min(ind+k,n);i++){
            len++;
            max = Math.max(max,arr[i]);
            int sum = len*max;
            maxSum = Math.max(maxSum,sum+findMax2(i+1,arr,k,n));
        }

        return maxSum;
    }
}
