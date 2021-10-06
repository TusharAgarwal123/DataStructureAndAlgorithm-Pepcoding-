package com.ds.level1.array;

import java.util.Scanner;

public class SumOfTwoArray {
	
	public static void main(String[] args) throws Exception {
	    // write your code here
	    
	    Scanner sc=new Scanner(System.in);
	     int n1=sc.nextInt();
	     int ar1[]=new int[n1];
	     for(int i=0;i<n1;i++){
	         ar1[i]=sc.nextInt();
	     }
	     
	     int n2=sc.nextInt();
	     int ar2[]=new int[n2];
	     for(int i=0;i<n2;i++){
	         ar2[i]=sc.nextInt();
	     }
	     
	     int sum[]=new int[n1>n2? n1 : n2];
	     
	     int i=n1-1;
	     int j=n2-1;
	     int k=sum.length-1;
	     int c=0;
	     
	     while(i>=0 || j>=0){
	         int d=c;
	         
	         if(i>=0){
	         d+=ar1[i];
	         }
	         if(j>=0){
	         d+=ar2[j];
	         }
	         
	         c=d/10;
	         d=d%10;
	         sum[k]=d;
	         i--;
	         j--;
	         k--;
	     }
	     
	     if(c>0){
	         System.out.println(c);
	     }
	     
	     for(int val:sum){
	         System.out.println(val);
	     }
	    
	 }


}
