package com.lec.ex2_date;

import java.util.Calendar;
import java.util.StringTokenizer;


public class Ex01_Calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year	= cal.get(Calendar.YEAR);
		int month	= cal.get(Calendar.MONTH)+1;
		int day		= cal.get(Calendar.DAY_OF_MONTH); //
		int week	= cal.get(Calendar.DAY_OF_WEEK);
		int hour24	= cal.get(Calendar.HOUR_OF_DAY)+1;
		int hour12	= cal.get(Calendar.HOUR); //
		int ampm    = cal.get(Calendar.AM_PM); //0(am), 1(pm)
		int min		= cal.get(Calendar.MINUTE);
		int sec		= cal.get(Calendar.SECOND);
		int milisec = cal.get(Calendar.MILLISECOND);
		
		System.out.printf("%d년 %d월 %d일 ", year,month, day);
		
		switch(week) {
			case 1: System.out.print("일요일");  break;
			case 2: System.out.print("월요일"); break;
			case 3: System.out.print("화요일"); break;
			case 4: System.out.print("수요일"); break;
			case 5: System.out.print("목요일"); break;
			case 6: System.out.print("금요일"); break;
			case 7: System.out.print("토요일"); break;
		}
		
		System.out.printf(" %d시 %d분 %d초\n", hour24, min, sec);
		
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시 %tM분 %tS초\n",
						   cal,   cal,  cal,  cal,  cal,  cal,  cal); 
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시 %1$tM분 %1$tS초\n",cal);
		
		//System.out.printf("%1$d %1$d %1$d %1$d %1$d %1$d %1$d %1$d  ",100);
		
		System.out.println( (ampm == 0 ) ? "오전" :  "오후" );
		System.out.printf("%d시 %d분 %d초\n", hour12,min, sec);
		
		System.out.printf("%tl시 %tM분 %tS초\n", cal, cal, cal);
		System.out.printf("%1$tl시 %1$tM분 %1$tS초\n", cal);
	}

}

