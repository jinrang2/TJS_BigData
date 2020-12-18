package com.lec.ex09lib;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
			BookLib[] books = { new BookLib("BOOK100","java","아무개"),
								new BookLib("BOOK101","hadoop","저무개"),
								new BookLib("BOOK102","oracle","이무개"),
								new BookLib("BOOK103","python","김무개"),
								new BookLib("BOOK104","mysql","신무개")
			};
			
			CDLib[] cds = { new CDLib("CD100","javastudy","BOOK100"),
					new CDLib("CD101","hadoopstudy","BOOK101"),
					new CDLib("CD102","oraclestudy","BOOK102"),
					new CDLib("CD103","pythonstudy","BOOK103"),
					new CDLib("CD104","mysqlstudy","BOOK104")
			};
			
			Scanner sc = new Scanner(System.in);
			int fn;		// 기능 번호 인덱스(1:대출	2:반납)
					
			do {
				System.out.print(" 1:책대출 | 2:CD대출 | 3:책반납 | 4:CD반납 | 5:도서&CD 현황 | 0:종료 : ");
				fn = sc.nextInt();
				
				switch(fn) {
					case 1:
						menu1(books);
						break;
					case 2:
						menu2(cds);
									
						break;
					case 3:
						menu3(books);
						break;						
					case 4:
						menu4(cds);
						
						break;						
					case 5:
						menu5(books, cds);
						break;
				}
				
			}while(fn != 0);
			
			
			
			System.out.println("시스템 종료");
			sc.close();
	}
	
	public static void menu1(BookLib[] books) {
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
			System.out.println("\"" + title+ "\" 책은 저희 도서관에 없습니다");
		} else if(books[idx].isBorrowable() != false) {
			System.out.println("\"" + title+ "\" 책은 대출중입니다");
		} else {
			System.out.printf("\"%s\" 책은 대출 가능합니다.\n",books[idx].getBookTitle());
			System.out.println("대출인은? : ");
			borrower = sc.next();
			System.out.println("대출일은? : ");
			checkOutDate = sc.next();
			
			books[idx].checkOut(borrower, checkOutDate);
		}
	}
	
	public static void menu2(CDLib[] cds) {
		Scanner sc = new Scanner(System.in);
		int idx=0;		// 기능 번호 인덱스(1:대출	2:반납)
		String title, borrower, checkOutDate;
		
		System.out.println("대출할 CD 이름은? : ");
		title = sc.next();
		
		for(idx = 0; idx < cds.length ; ++idx) {
			if(title.equals(cds[idx].getCdTitle())) {
				break;
			}
		}
		
		if (idx == cds.length) {
			System.out.println("대출할 CD는 저희 도서관에는 없습니다.");
		} else if(cds[idx].isBorrowable() != false) {
			System.out.println("\"" + title+ "\" CD는 대출중입니다");
		} else {
			System.out.printf("\"%s\" CD는 대출 가능합니다.\n",cds[idx].getCdTitle());
			System.out.println("대출인은? : ");
			borrower = sc.next();
			System.out.println("대출일은? : ");
			checkOutDate = sc.next();
			
			cds[idx].checkOut(borrower, checkOutDate);
		}
	}
	
	public static void menu3(BookLib[] books) {
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
			System.out.printf("\"%s\" 책은 저희 도서관에는 없습니다.",books[idx].getBookTitle());
		} else {
			books[idx].checkIn();
		}	
	}
	
	public static void menu4(CDLib[] cds) {
		Scanner sc = new Scanner(System.in);
		int idx=0;		// 기능 번호 인덱스(1:대출	2:반납)
		String title;
		
		System.out.println("반납할 CD 이름은? : ");
		title = sc.next();
		
		for(idx = 0; idx < cds.length ; ++idx) {
			if(title.equals(cds[idx].getCdTitle())) {
				break;
			}
		}
		
		if (idx == cds.length) {
			System.out.printf("\"%s\" CD는 저희 도서관에는 없습니다.",cds[idx].getCdTitle());
		} else {
			cds[idx].checkIn();
		}		
	}
	
	public static void menu5(BookLib[] books, CDLib[] cds) {
		System.out.println();
		for(BookLib book : books) {
			book.printState();
		}
		System.out.println();
		for(CDLib cd : cds) {
			cd.printState();
		}
		System.out.println();
	}
}


