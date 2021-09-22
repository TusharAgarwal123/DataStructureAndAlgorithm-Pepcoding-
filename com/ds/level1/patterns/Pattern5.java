package com.ds.level1.patterns;

import java.util.Scanner;

public class Pattern5 {
	public static void main(String[] args) {
		System.out.println("Enter the n:");
		Scanner scn = new Scanner(System.in);

		// write ur code here
		int n = scn.nextInt();

		// upper half
		for (int i = 1; i <= (n / 2) + 1; i++) {

			for (int x = 1; x <= (n / 2) - i + 1; x++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= (2 * i) - 1; j++) {
				System.out.print("*" + "\t");
			}
			System.out.println();
		}

		// lower half
		for (int i = 1; i <= (n / 2); i++) {

			for (int x = 1; x <= i; x++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= n - (2 * i); j++) {
				System.out.print("*" + "\t");
			}
			System.out.println();
		}

		// another approach

//        int nos=n/2;
//        int nost=1;
//        
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=nos;j++){
//                System.out.print("\t");
//            }
//            for(int j=1;j<=nost;j++){
//                System.out.print("*\t");
//            }
//            
//            System.out.println();
//            if(i<=n/2){
//                nos--;
//                nost+=2;
//            }else{
//                nos++;
//                nost-=2;
//            }
//        }

	}

}
