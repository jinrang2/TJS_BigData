package com.lec.ex2_date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_gcSimpleDateFormat {

	public static void main(String[] args) {
		Date date	 = new Date();
		// 2020년 12월 14일 3시 03분 05초
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-mm-dd HH:MM:ss");
		
		String outString = sdf.format(date);
		
		System.out.println(outString);
		
		
	}

}
