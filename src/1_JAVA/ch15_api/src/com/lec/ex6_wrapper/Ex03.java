package com.lec.ex6_wrapper;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("스트링을 정수 : Integer.parseInt(문자열)");
		
		int i = Integer.parseInt("123");
		
		Integer aaa = i;
		
		System.out.println(i);
		
		String abc = String.valueOf(i);
		
		System.out.println(abc);
		
		
	}
}
