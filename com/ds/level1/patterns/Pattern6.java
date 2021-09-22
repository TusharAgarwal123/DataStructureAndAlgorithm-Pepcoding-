package com.ds.level1.patterns;

import java.util.Scanner;

public class Pattern6 {
	public static void main(String[] args) {
		System.out.println("Enter the n:");
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		// upper half
		for (int i = 1; i <= ((n / 2) + 1); i++) {

			for (int j = 1; j <= ((n / 2) - i + 2); j++) {
				System.out.print("*" + "\t");
			}

			for (int k = 1; k <= ((2 * i) - 1); k++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= ((n / 2) - i + 2); j++) {
				System.out.print("*" + "\t");
			}
			System.out.println();

		}

		// lower half

		for (int i = 1; i <= n / 2; i++) {

			for (int j = 1; j <= i + 1; j++) {
				System.out.print("*" + "\t");

			}

			for (int j = 1; j <= (n - (2 * i)); j++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= i + 1; j++) {
				System.out.print("*" + "\t");

			}

			System.out.println();

		}

	}

//	public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        
//        int starCount = n/2 + 1;
//        int spaceCount = 1;
//        
//        for(int i = 1; i <= n/ 2 + 1; i++){
//            printStar(starCount);
//            printSpace(spaceCount);
//            printStar(starCount);
//            System.out.println();
//            starCount--;
//            spaceCount += 2;
//        }
//        
//         starCount = 2;
//         spaceCount = n - 2;
//        
//        for(int i = n/2 ; i >= 1; i--){
//            printStar(starCount);
//            printSpace(spaceCount);
//            printStar(starCount);
//            System.out.println();
//            starCount++;
//            spaceCount -= 2;
//        }
//
//    }
//    
//    public static void printStar(int count){
//        while(count-- > 0)
//            System.out.print("*\t");
//    }
//    
//    public static void printSpace(int count){
//        while(count-- > 0)
//            System.out.print('\t');
//    }

}
