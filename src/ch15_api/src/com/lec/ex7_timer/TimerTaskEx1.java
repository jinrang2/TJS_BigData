package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {
	
	@Override
	public void run() {
		System.out.println("★★★★★작업1 : 초마다 수행할 예정");
	}
}
