package com.lec.ex09_person;

public class TestMain {

	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("아빠곰");
		papa.setCharacter("뚱뚱해");
		
		Person mom =  new Person("엄마곰","날씬해");
		papa.intro();
		mom.intro();
		
		System.out.println("=======================================");
		Baby child1 = new Baby();
		child1.setName("아기곰1");
		child1.setCharacter("적당히 귀여워");
		child1.intro();
		
		System.out.println("=======================================");
		Baby child2 = new Baby("아기곰2","너무 귀여워");
		
		child2.intro();
		child2.cry();
	 }

}
