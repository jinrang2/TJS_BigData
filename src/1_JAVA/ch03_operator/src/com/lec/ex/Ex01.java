package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		int n1 = 33, n2=10;
		int result;
		double resultDouble;
		
		result = n1 + n2;	System.out.printf("%d %c %d =  %d\n", n1, '+', n2, result);
		result = n1 - n2;	System.out.printf("%d %c %d =  %d\n", n1, '-', n2, result);
		result = n1 * n2;	System.out.printf("%d %c %d =  %d\n", n1, '*', n2, result);
		resultDouble = (double)n1 / n2;	System.out.printf("%d %c %d =  %.1f\n", n1, '/', n2, resultDouble);
		
		
		if( n1%2 == 0 )
			System.out.println("礎熱");
		else
			System.out.println("�汝�");
		
		
	}	// main л熱 部
}	// class 部
