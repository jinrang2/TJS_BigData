package com.lec.ex5_momchild;

public class Child {
	private String name;
	
	MomPouch momPouch = new MomPouch();
	
	public Child(String name) {
		this.name = name;
	}
	
	public void takeMoney(int money) {
		if (momPouch.money >= money ) {
			momPouch.money -= money;
			System.out.printf("%s 가 %d 가져가서 엄마지갑엔 %d\n",this.name, money, momPouch.money);
		} else {
			System.out.printf("%s 가 돈을 못받음. 현재 엄마 돈은\n",name);
		}
			
	}
}
