package com.lec.ex3_exceptionExs;

public class Ex02_Friend {
	public static void main(String[] args) {
		Friend f1 = new Friend();
		Friend f2 = new Friend("홍길동","010-9999-9999");
		
		System.out.println(f2);
		System.out.println(f1);
	}
}
