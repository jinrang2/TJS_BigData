package com.lec.ex6_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i=10, j=10;
		if (i == j) {
			System.out.println("i와j는 같다");			
		}
		
		Integer obj1 = new Integer(10);
		Integer obj2 = new Integer(10);
		
		if ("Hello".equals(i)) {
			System.out.println("같지 않다");
		} else {
			System.out.println("같다 아니왜? 헬로우랑 10이 왜?");
		}
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2의 데이터는 같다");
		}
		
		int total = obj1 + obj2;
		System.out.println(total);
	}
}
