package com.lec.ex;

public class Arithmetic {
	
	public int sum(int from, int to) {
		
		int result = 0;
		
		for (int i = from; i <= to ; i++) {
			result += i;
		}
		
		return result;
	}
	
	public int sum(int to) {
		
		int result = 0;
		
		for (int i = 1; i <= to ; i++) {
			result += i;
		}
		
		return result;
	}
	
	public String evenOdd(int value) {
		String result = value%2 == 0 ? "Â¦¼öÀÔ´Ï´Ù" : "È¦¼öÀÔ´Ï´Ù";
		return result;
	}
	
	public static int abs(int value) {
		return value < 0 ? -value : value;		
	}
}
