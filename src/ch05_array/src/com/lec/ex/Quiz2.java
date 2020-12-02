package com.lec.ex;

public class Quiz2 {

	public static void main(String[] args) {
		int[][] iArr = { {   5,  5,   5,   5,   5}, {10, 10, 10, 10, 10}, {20, 20, 20, 20, 20}, {30, 30, 30, 30, 30}};
		
		for(int i=0; i < iArr.length ; ++i) {
			for(int j=0;  j < iArr[i].length ; ++j) {
				System.out.println(iArr[i][j]);
			}
		}
	}
}
