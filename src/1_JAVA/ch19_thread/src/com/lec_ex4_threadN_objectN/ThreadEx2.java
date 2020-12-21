package com.lec_ex4_threadN_objectN;

public class ThreadEx2 extends Thread {
	private int num;		// 스레드 공유 변수
	
	
	
	public ThreadEx2() {
		super();
	}
	

	public ThreadEx2(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0; i<10 ; i++) {
			String threadname =  Thread.currentThread().getName();
			
			if(threadname.equals("A")) {
				System.out.println("★★★A수행중★★★");
				num++;
			}
			
			System.out.println(threadname + "의 num = " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	}	// main
}
