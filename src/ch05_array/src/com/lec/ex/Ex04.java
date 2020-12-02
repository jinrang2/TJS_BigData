package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		int[][] iArr = { {1,2,3}, {4,5}, {6,7,8}};
		
		
//		System.out.println(iArr[1].length);
		
		
		for(int i=0; i < iArr.length ; ++i) {
			for(int j=0;  j < iArr[i].length ; ++j) {
				System.out.println(iArr[i][j]);
			}
		}
	}
}
