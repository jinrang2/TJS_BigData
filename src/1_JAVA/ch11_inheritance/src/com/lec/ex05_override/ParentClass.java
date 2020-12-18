package com.lec.ex05_override;

public class ParentClass {
	
	private int i;
	
	public ParentClass() {
		System.out.println("P 매개변수 없는 생성자");
	}
	
	public ParentClass(int i) {
		System.out.println("P 매개변수 있는 생성자");
	}
	
	public void method1() {
		System.out.println("Parent의 method1()");
	}
	
	public void method2() {
		System.out.println("Parent의 오버로딩1 method2()");
	}

	public void method2(int i) {
		System.out.println("Parent의 오버로딩2 method2()");
	}

	
}
