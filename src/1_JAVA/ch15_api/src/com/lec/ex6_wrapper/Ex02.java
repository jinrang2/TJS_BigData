package com.lec.ex6_wrapper;

public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10","20","30","40","30","40","30","40");
		System.out.println(total);
	}
	
	private static int valueSum(String ... values) {
		int sum=0;
		
		
		for (int i = 0; i < values.length; i++) {
			sum += Integer.parseInt(values[i]);
			
		}
		
		return sum;
	}
}
