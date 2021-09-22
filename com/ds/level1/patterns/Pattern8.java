package com.ds.level1.patterns;

public class Pattern8 {

	public static void main(String[] args) {

		int n = 5;
//		for (int i = 1; i <= n; i++) {
//
//			for (int x = 1; x <= n - i; x++) {
//				System.out.print("\t");
//			}
//
//				System.out.print("*");
//			
//
//			System.out.println();
//
//		}

//		 //another aproach
//           for(int i=1;i<=n;i++){
//               
//               for(int x=1;x<=n;x++){
//                   if(i+x==n+1){  //on second diagonal
//                   System.out.print("*");
//                   }else{
//                       System.out.print("\t");
//                   }
//               }
//               
//             
//               System.out.println();
//               
//           }

		// another appraoch
		int nos = n - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}

			System.out.print("*");
			nos--;

			System.out.println();
		}

	}

}
