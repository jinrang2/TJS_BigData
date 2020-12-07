package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
//		ParentClass p1 = new ParentClass();
//		ParentClass p2 = new ParentClass(10);
//		
//		p1.getPapaName();
//		p1.getMamiName();
		
		System.out.println("========================");
		
		ChildClass c1 =  new ChildClass();
		ChildClass c2 =  new ChildClass(20);
		
		System.out.println("========================");
		
		c1.getPapaName();
		c1.getMamiName();
		
		System.out.println("========================");
		
		c2.getPapaName();
		c2.getMamiName();
		
	}
}
