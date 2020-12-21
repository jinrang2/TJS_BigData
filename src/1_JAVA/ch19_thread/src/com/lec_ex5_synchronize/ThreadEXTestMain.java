package com.lec_ex5_synchronize;

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
