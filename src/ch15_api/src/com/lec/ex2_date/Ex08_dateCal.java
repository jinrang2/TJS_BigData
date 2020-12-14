package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ex08_dateCal {

	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar();
		
		GregorianCalendar thatTime = new GregorianCalendar(2020,10,30,9,30,0);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-DD hh:mm:ss");
		
		long nowMS = now.getTimeInMillis();
		long thatMS = thatTime.getTimeInMillis();
		//long timeMinus = nowMS - thatMS;
		long day = (nowMS - thatMS) / 1000*60*60*24;
		
		//String strDate =  sdf.format(nowMS - thatMS);
		
		System.out.println("개강한 이후"+day+"일 지남");
	}

}
