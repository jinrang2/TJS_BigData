package com.lec.squre;

public class SqureMain {
	public static void main(String[] args) {
		Squre s1 = new Squre();
		Squre s2 = new Squre(10);
		//Squre s3; 
		
		System.out.println("s1의 한변의 길이는 "+s1.getSide());
		System.out.println("s1의 넓이는 "+s1.area());
		System.out.println("s1의 한변의 길이는 "+s2.getSide());
		System.out.println("s1의 넓이는 "+s2.area());
		
		s2.setSide(5);
		System.out.println("s1의 넓이는 "+s2.area());
	}
}
