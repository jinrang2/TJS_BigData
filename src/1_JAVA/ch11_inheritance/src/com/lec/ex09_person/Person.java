package com.lec.ex09_person;


// Person p = new Person("홍길동","착하다");
public class Person {
	private String name;
	private String character;
	
	Person() {System.out.println("매개변수 없는 생성자 호출");}
		
	public Person(String name, String character) {
		System.out.println("매개변수 있는 생성자 호출");
		this.name = name;
		this.character = character;
	}
	
	public void intro() {
		System.out.println(name + "은(는)" + character);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	
}
