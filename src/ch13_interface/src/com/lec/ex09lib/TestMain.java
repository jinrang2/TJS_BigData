package com.lec.ex09lib;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("890ㅁ","자바","홍길동");
		BookLib book2 = new BookLib("890ㅂ","하둡","홍끼리");
		
		book1.checkIn();
		book1.checkOut("신길동", "201209");
		book1.checkOut("김길동", "201209");
		book1.printState();
		book2.printState();
	}
}
