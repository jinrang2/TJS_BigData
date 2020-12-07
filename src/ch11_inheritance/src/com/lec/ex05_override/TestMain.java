package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pObj1 =  new ParentClass();
		ParentClass pObj2 =  new ParentClass(2);
		
		pObj1.method1();
		pObj1.method2();
		pObj1.method2(10);
		
		System.out.println("==============================");
		
		ParentClass pObj3 = new ChildClass();
		
		
		pObj3.method1();
		
		System.out.println("==============================");
		
		ChildClass cObj1 = new ChildClass();
		
		cObj1.method1();
		cObj1.method2();
		cObj1.method3();
		
	}
}
