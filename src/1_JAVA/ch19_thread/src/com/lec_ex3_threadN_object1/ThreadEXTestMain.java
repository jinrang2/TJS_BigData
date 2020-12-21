package com.lec_ex3_threadN_object1;

public class ThreadEXTestMain {
	public static void main(String[] args) {
		Runnable target = new ThreadEx();
		
		Thread t1 = new Thread(target, "A");
		Thread t2 = new Thread(target, "B");
		
		t1.start();
		t2.start();
		
		System.out.println("메인함수");
		System.out.println("메인함수끝");
		
	}
}
