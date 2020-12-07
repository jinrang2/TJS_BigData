package com.lec.ex02_super;

public class TestMain {
	public static void main(String[] args) {
		
//		System.out.println("i값 : "+child.getI());
//		System.out.println("J값 : "+child.getJ());
//		child.setI(10);	child.setI(20);
		
		Child child = new Child(10,20);
		System.out.println("i값 : "+child.getI());
		System.out.println("J값 : "+child.getJ());
		child.sum();
	}
}
