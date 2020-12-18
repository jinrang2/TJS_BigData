package com.lec.ex2_parking;

import com.lec.cons.PiClass;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	//private static final int FEE_UNIT = 2000;
	
	public Parking() {}
			
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		
		System.out.printf("\"%s\" 님 어서오세요\n",no);
		System.out.printf("입차시간 : %d시\n\n",inTime);
		
	}
	
	public void out(int outTime) {
		this.outTime = outTime;
		
		System.out.printf("\"%s\" 님 안녕히 가세요\n",no);
		System.out.printf("입차시간 : %d시\n",inTime);
		System.out.printf("출차시간 : %d시\n",outTime);
		System.out.printf("주차요금 : %d원\n",(outTime-inTime)*PiClass.HOURLYRATE);
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	
	
	
	
}
