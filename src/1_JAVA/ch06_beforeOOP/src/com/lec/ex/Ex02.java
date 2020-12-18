package com.lec.ex;

public class Ex02 {
	private static int sum(int from, int to) {
		
		int result = 0;
		
		for (int i = from; i <= to ; i++) {
			result += i;
		}
		
		return result;
	}
	
	private static int sum(int to) {
		
		int result = 0;
		
		for (int i = 1; i <= to ; i++) {
			result += i;
		}
		
		return result;
	}
	
	private static String evenOdd(int value) {
		String result = value%2 == 0 ? "짝수입니다" : "홀수입니다";
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int sum = sum(1,10);
		System.out.println("합은"+sum);
		System.out.println(evenOdd(sum));
		
		sum = sum(10);		
		System.out.println("합은"+sum);
		System.out.println(evenOdd(sum));
				
		sum = sum(1,50);		
		System.out.println("합은"+sum);
		System.out.println(evenOdd(sum));
		
		sum = sum(10,50);
		System.out.println("합은"+sum);
		System.out.println(evenOdd(sum));	
	}
	
	
}
