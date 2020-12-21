package com.lec_ex5_synchronize;

// 동기화 작업시에는 Runnable
public class ThreadEx implements Runnable {
	private int num;		// 스레드 공유 변수
	
	@Override
	public void run() {
		for(int i=0; i<10 ; i++) {
			
			out();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		} // for
	}	// main
	
	private synchronized void out() {
		String threadname =  Thread.currentThread().getName();
		
		if(threadname.equals("A")) {
			System.out.println("★★★A수행중★★★");
			num++;
		}
		
		System.out.println(threadname + "의 num = " + num);
	}
}
