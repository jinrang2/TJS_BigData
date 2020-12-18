package com.lec.ex09_person;

public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수 없는 baby 생성자");
	}
	
	public Baby(String name,String character) {
		super(name, character);
		System.out.println("매개변수 있는 baby 생성자");
	}

	public void cry() {
		System.out.println("응애응애");
	}
	
	@Override
	public void intro() {
		System.out.println(getName()+"은(는) 아기라서 엄마가 대신 소개할게");
		super.intro();
	}
}
