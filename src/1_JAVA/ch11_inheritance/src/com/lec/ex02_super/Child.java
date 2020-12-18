package com.lec.ex02_super;

public class Child extends SuperIJ{
	private int total;
	
	public Child(int i, int j) {
		setI(i);
		setJ(i);
	}
	
	public void sum() {
		 total = getI() + getJ();
		 System.out.println("본 객체의 total"+total);
	}
}
