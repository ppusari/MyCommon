package com.ppusari.java.structure.array;

public class ArrayTest {
	
	public static void main(String[] agrs) {
		
		base();
	
	}
	
	public static void base(){
		// 1차원 배열
		int[] i1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};		
		int[] i2 = new int[] {1,2,3,4,5,6,7,8,9,10};		
		int[] i3 = new int[10];
		for(int i=0; i<i3.length; i++)
			i3[i] = i;
		
		
		// 2차원 배열
		System.out.print("2차원 배열: ");
		int[][] ii4 = new int[][] { {1,2},
									{3,4},
									{5,6} };	
		for (int i=0; i<3; i++) {
			for (int j=0; j<2; j++) {				 
				System.out.print(ii4[i][j]);				 
			}
		}
		
		
		// 동적배열
		System.out.print("\n동적배열: ");
		int[][] ii5 = new int[2][];
		ii5[0] = new int[3];
		ii5[1] = new int[2];
		for (int i=0; i<ii5.length; i++) {
			for (int j=0; j<ii5[i].length; j++) {
				ii5[i][j] = 0;
				System.out.print(ii5[i][j]);
			}
		} 
						
		// 문자열 배열. 		
		String[] s1 = {"string", "string", "string"};
		String[] s2 = new String[10];
		String[] s3 = new String[] {"string", "string"};	 
	}

 
}
