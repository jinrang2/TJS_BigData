package com.lec.ex4_lib_exception;

import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LibMain {
	public static void main(String[] args) {
			BookLib[] books = { new BookLib("BOOK100","java","아무개"),
								new BookLib("BOOK101","hadoop","저무개"),
								new BookLib("BOOK102","oracle","이무개"),
								new BookLib("BOOK103","python","김무개"),
								new BookLib("BOOK104","mysql","신무개")
			};
						
			Scanner sc = new Scanner(System.in);
			int fn=-1;		
					
			do {
				System.out.print(" 0:전체 대출여부 상태 열람 | 1:책대출 | 2:책반납 : ");
				try {
					fn = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다. 메뉴외의 입력시 프로그램이 종료됩니다");
					fn=-1;
					break;
				} 
				
				switch(fn) {
					case 0:		
						printInfo(books);		
						break;
					case 1:		
						try {
							checkOut(books);
							break;
						} catch (Exception e) {
							printErr(e);
							break;
						}
						
					case 2:
						try {
							checkin(books);
							break;
						} catch (Exception e) {
							printErr(e);
							break;
						}
					default:
						System.out.println("잘못된 메뉴 번호 입니다. 프로그램이 종료됩니다");
						fn = -1;
				}
				
			}while(fn != -1);
			
			System.out.println("시스템 종료");
			sc.close();
	}
	
	public static void checkOut(BookLib[] books) throws Exception {
		Scanner sc = new Scanner(System.in);
		int idx=0;		// 기능 번호 인덱스(1:대출	2:반납)
		String title, borrower, checkOutDate;
		
		System.out.println("대출할 책 이름은? : ");
		title = sc.next();
		
		for(idx = 0; idx < books.length ; ++idx) {
			if(title.equals(books[idx].getBookTitle())) {
				break;
			}
		}
		
		if (idx == books.length) {
			throw new Exception("\"" + title+ "\" 책은 저희 도서관에 없습니다");
		} else if(books[idx].isBorrowable() != false) {
			throw new Exception("\"" + title+ "\" 책은 대출중입니다");
		} else {
			System.out.printf("\"%s\" 책은 대출 가능합니다.\n",books[idx].getBookTitle());
			System.out.println("대출인은? : ");
			borrower = sc.next();
			
			
			books[idx].checkOut(borrower);
		}
	}
	
	
	public static void checkin(BookLib[] books) throws Exception {
		Scanner sc = new Scanner(System.in);
		int idx=0;		// 기능 번호 인덱스(1:대출	2:반납)
		String title;
		
		System.out.println("반납할 책 이름은? : ");
		title = sc.next();
		
		for(idx = 0; idx < books.length ; ++idx) {
			if(title.equals(books[idx].getBookTitle())) {
				break;
			}
		}		
		
		
		if (idx == books.length) {
			String temp;
			temp = String.format("\"%s\" 책은 저희 도서관에는 없습니다.",title);
			throw new Exception(temp);
		} else {
			books[idx].checkIn();
		}	
	}
	
	
	
	public static void printInfo(BookLib[] books) {
		System.out.println();
		for(BookLib book : books) {
			System.out.println(book);
		}		
		System.out.println();
	}
	
	public static void printErr(Exception e) {
		
		System.out.println(e.getMessage());
		//System.out.print(err.getErrMsg());
	}
}


