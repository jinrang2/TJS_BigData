package com.lec.ex5_momchild;

public class childTestMain {
	public static void main(String[] args) {
		Child child1 = new Child("첫째 똘만이");
		Child child2 = new Child("둘째 갑돌이");
		Child child3 = new Child("셋째 똘순니");
		
		child1.takeMoney(1000);
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		
		System.out.println("첫째 엄마 지갑"+child1.momPouch.money);
		System.out.println("둘째 엄마 지갑"+child1.momPouch.money);
		System.out.println("셋째 엄마 지갑"+child1.momPouch.money);
		System.out.println("static 엄마 지갑"+ MomPouch.money);
		
	}
}
