package com.lec_ex4_threadN_objectN;

public class ThreadEXTestMain {
	public static void main(String[] args) {
		Runnable target1 = new ThreadEx();
		Runnable target2 = new ThreadEx();
		
		Thread t1 = new Thread(target1, "A");
		Thread t2 = new Thread(target2, "B");
		
		t1.start();
		t2.start();
		
		System.out.println("메인함수");
		System.out.println("메인함수끝");
		
	}
}
