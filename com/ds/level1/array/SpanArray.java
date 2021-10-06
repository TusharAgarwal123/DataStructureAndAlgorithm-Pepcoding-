package com.ds.level1.array;

import java.util.Scanner;

public class SpanArray {
	public static void main(String[] args) throws Exception {
	    // write your code here

	     Scanner sc=new Scanner(System.in);
	     int n=sc.nextInt();
	     int ar[]=new int[n];
	     for(int i=0;i<n;i++){
	         ar[i]=sc.nextInt();
	     }
	     
	     int min=ar[0];
	     int max=ar[0];
	     
	     for(int i=0;i<n;i++){
	         if(ar[i]<min){
	             min=ar[i];
	         }
	         if(ar[i]>max){
	             max=ar[i];
	         }
	     }
	     
	     System.out.println(max-min);
	 }

}
