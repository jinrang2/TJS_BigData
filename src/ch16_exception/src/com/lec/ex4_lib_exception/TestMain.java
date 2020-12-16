package com.lec.ex4_lib_exception;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {
	public static void main(String[] args) {
		BookLib book = new BookLib("890ㄱ-01","java","홍길동");
		BookLib book1 = new BookLib("890ㄱ-02","hadoop","홍하둡");
		
		try {
			book.checkOut("kim");
			book1.checkOut("lee");
			
			book.setCheckOutDate(new Date(new GregorianCalendar(2020,9,30).getTimeInMillis()));
			System.out.println(book);
			
			
			book.checkIn();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(book);
		System.out.println(book1);
	}
}
