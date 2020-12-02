package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int[] iArr = {10,20,30,40,50};
		
		iArr[1] = 200;
		
		for (int idx=0 ;  idx < 5 ; ++idx){
			System.out.println(iArr[idx]);
		}
		
		int[] iArr2 = new int[5];
		iArr2[0] = 999;
		for (int idx=0 ;  idx < iArr2.length ; ++idx){
			System.out.println(idx+"번째값 : "+iArr2[idx]);
		}
		
		int[] iArr3;
		iArr3 = new int[5];
		
		for(int idx = 0 ; idx < iArr3.length ; ++idx) {
			iArr3[idx] = 10;
		}
		
		for (int i : iArr3){
			//System.out.println( iArr3[i-1]-1 + "번째값 : "+i);
			System.out.println(i);
		}
		
		
	}
}
