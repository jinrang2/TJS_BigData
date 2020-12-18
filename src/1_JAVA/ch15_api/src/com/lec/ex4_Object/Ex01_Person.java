package com.lec.ex4_Object;

public class Ex01_Person {
	
	
	public static void main(String[] args) {
		Person p1 = new Person(1210101922222l);
		Person p2 = new Person(1210101922222l);
		Person p3 = p1;
		
		Person a;
		
		if (p1.equals(p2)) {
			System.out.println("같다냥");
		} else {
			System.out.println("다르다냥");
		}
		
		
	}
}
