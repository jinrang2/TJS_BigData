package com.lec.ex08;

public class GrandChild extends Child1 {
	private int g = 3;

	public GrandChild() {
		//super();
		System.out.println("GrandChild형 객체 생성");
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}
}
