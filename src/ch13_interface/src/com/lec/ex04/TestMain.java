package com.lec.ex04;

public class TestMain {

	public static void main(String[] args) {
		TestClass t1 =  new TestChildClass();
				
		t1.m1();
		t1.m2();
		t1.m3();
		
		System.out.println();
		
		TestChildClass t2 =  new TestChildClass();
		
		t2.m1();
		t2.m2();
		t2.m3();
		t2.m11();
		
		
	}

}
