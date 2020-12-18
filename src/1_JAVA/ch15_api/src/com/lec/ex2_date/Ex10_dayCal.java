package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex10_dayCal {

	public static void main(String[] args) {
		Date checkOutDate = new Date(new GregorianCalendar(2020,10,15).getTimeInMillis() );
		Date now = new Date();
		
		System.out.println(checkOutDate);
		
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (1000*60*60*24);
		
		System.out.println(day);
		
		if(day>14) {
			day -= 14;
			System.out.println("연체료"+(day*100)+"원을 받으셨나요? : ");
			Scanner scanner = new Scanner(System.in);
			String ok = scanner.next();
			
			while ( ok.equalsIgnoreCase("y")) {
				System.out.println("연체료"+(day*100)+"원을 받으셔야 반납처리 가능합니다 (Y/y) : ");
				scanner.next();
				break;
			}
				
		
		}
		
		System.out.println("반납합니다");
		
	}

}
