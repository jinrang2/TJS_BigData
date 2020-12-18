package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true);		// true: 프로그램 종료되면 timer종료
		TimerTask tt1 = new TimerTaskEx1();
		TimerTask tt2 = new TimerTaskEx2();
		
		timer.schedule(tt1, 1000, 2000);		
		timer.schedule(tt2, 2000, 1000);
		
		Thread.sleep(10000);
		
		System.out.println("끝");
	}
}
