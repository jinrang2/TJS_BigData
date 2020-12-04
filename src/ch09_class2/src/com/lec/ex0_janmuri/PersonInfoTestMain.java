package com.lec.ex0_janmuri;

class PersonInfo{
	private String name;
	private int age;
	private char gender;	
	
	PersonInfo() {}

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void print() {
		System.out.printf(this.infoString());
	}
	
	public String infoString() {
		
		return String.format("이름 = %s\t나이=%d\t성별=%c\n",name, age, gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}

public class PersonInfoTestMain {
	public static void main(String[] args) {
		int[] iArr = {10,20,30};
		PersonInfo[] person = { new PersonInfo("홍길동",20,'남'),
								new PersonInfo("홍길순",22,'여'),
								new PersonInfo()
		};
		
		person[2].setName("홍길덩");
		person[2].setAge(21);
		person[2].setGender('남');
		
		
		for (PersonInfo p : person) {
			p.print();
			System.out.println(p.infoString());
			//System.out.println(p.getClass());
		}
	}
}
