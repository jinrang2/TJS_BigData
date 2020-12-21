package com.lec_ex1_runnable;

public class TaggetTestMain {
	public static void main(String[] args) {
		Target target =  new Target();
		
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("메인 함수 끝");
	}
}
