package com.ds.level1.array;

public class RotateAnArray {
	
	public static void main(String[] args) {
		
		int ar[]= {1,2,3,4,5};
		int k=3;
		rotate(ar, k);
		for(int x:ar) {
			System.out.print(x);
		}
		
	}
	
	 public static void rotate(int[] a, int k){
		    // write your code here
		    
		    k=k%a.length;
		    if(k<0){
		        k=k+a.length;
		    }
		    
		    reverse(a,0,a.length-k-1);
		    reverse(a,a.length-k,a.length-1);
		    reverse(a,0,a.length-1);
		    
		  }
		  
		  public static void reverse(int[] ar,int l,int r){
		      while(l<=r){
		          int temp=ar[l];
		          ar[l]=ar[r];
		          ar[r]=temp;
		          l++;
		          r--;
		      }
		  }


}
