package com.lec_ex4_threadN_objectN;

public class ThreadEX2TestMain {
	public static void main(String[] args) {
		Thread t1 = new ThreadEx2("A");
		Thread t2 = new ThreadEx2("B");
		
		t1.start();
		t2.start();
		
		System.out.println("메인함수");
		System.out.println("메인함수끝");
		
	}
}
