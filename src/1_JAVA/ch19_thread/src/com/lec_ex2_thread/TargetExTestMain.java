package com.lec_ex2_thread;

public class TargetExTestMain {
	public static void main(String[] args) {
		Thread target01 = new TargetEx01() ;
		Thread target02 = new TargetEx02();
		
		target01.setName("A");
		target02.setName("B");
		
		target01.start();
		target02.start();
		
		for(int i=0 ; i<10 ; i++) {
			System.out.println("나는 " +  Thread.currentThread().getName() + " -" +i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
}
