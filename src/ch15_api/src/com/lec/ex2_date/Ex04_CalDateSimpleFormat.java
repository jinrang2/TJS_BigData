package com.lec.ex2_date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex04_CalDateSimpleFormat {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date date	 = new Date();
		// 2020년 12월 14일 3시 03분 05초
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		
		String outString = sdf.format(cal.getTime());
		
		System.out.println(outString);
		
		outString  = sdf.format(date);
		
		System.out.println(outString);
	}

}
