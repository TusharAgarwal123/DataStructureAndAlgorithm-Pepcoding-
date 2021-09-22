package com.ds.level1.patterns;

public class Pattern9 {

	public static void main(String[] args) {

		int n = 5;
		for (int i = 1; i <= n; i++) {

			for (int x = 1; x <= n; x++) {
				if ((i + x == n + 1) || i == x) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}

			System.out.println();

		}

		// another approach

//        int nis=n-2;
//        int nos=0;
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=nos;j++){
//                System.out.print("\t");
//            }
//            System.out.print("*\t");
//             for(int j=1;j<=nis;j++){
//                System.out.print("\t");
//            }
//            
//            if(i!=(n/2)+1){
//                System.out.print("*\t");
//            }
//            
//            if(i<=n/2){
//                nos++;
//                nis-=2;
//            }else{
//                nos--;
//                nis+=2;
//            }
//            System.out.println();
//        }
	}

}
