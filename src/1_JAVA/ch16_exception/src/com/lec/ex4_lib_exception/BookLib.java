package com.lec.ex4_lib_exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookLib extends BookInfo implements ILendable  {
	
	private String borrower;
	private Date   checkOutDate;
	private byte   state;
	
	
	public BookLib() {}
	
	public BookLib(String bookno, String bookTitle, String writer) {
		
		super(bookno, bookTitle, writer);
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower) throws Exception {
		if(state != STATE_NORMAL) {
			throw new Exception("대출중인 도서입니다");
		} 
		
		this.borrower = borrower;
		this.checkOutDate = new Date();
		state = STATE_BORROWED;
		
		System.out.printf("\"%s\" 도서가 ★대출★되었습니다\n", getBookTitle()  );
		System.out.println("[대출인]"+borrower);
		
		String outDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		outDate =  sdf.format(checkOutDate);
		
		System.out.println("[대출일]"+outDate);
	}

	@Override
	public void checkIn() throws Exception {
		if(state != STATE_BORROWED) {
			throw new Exception("대출중인 도서가 아닙니다. 어디서 났어!?");
		} 
						
		Date now = new Date();
		
		//System.out.println(checkOutDate);
		
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (1000*60*60*24);
		
		//System.out.println(day);
		
		if(day>30) {
			day -= 30;
			System.out.println("연체료"+(day*PENALTY)+"원을 받으셨나요? (Y/y) : ");
			Scanner sc = new Scanner(System.in);
			String ok = sc.next();
			
			while ( ok.equalsIgnoreCase("y") == false ) {
				System.out.println("연체료"+(day*PENALTY)+"원을 받으셔야 반납처리 가능합니다 (Y/y) : ");
				ok = sc.next();
			}
		}
		
		this.checkOutDate = null;
		state = STATE_NORMAL;
		
		System.out.printf("\"%s\" 도서가 ★반납★ 처리 되었습니다\n", getBookTitle()  );
		
		borrower = null;
	}

	@Override
	public String toString() {
		String temp;
		String outDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(checkOutDate != null) {
			outDate =  sdf.format(checkOutDate);
		}else {
			outDate = "미대여";
		}
		
		if (state == STATE_NORMAL) {
			temp = String.format("책이름 : %s\t\t저자 : %s\t- 대출가능\t",getBookTitle(), getWriter(), outDate );
		} else if (state == STATE_BORROWED) {
			temp = String.format("책이름 : %s\t\t저자 : %s\t- 대출(%s)중\t", getBookTitle(), getWriter(), outDate   );
		} else {
			temp = String.format("책이름 : %s\t\t저자 : %s\t - 유령상태\t%s",getBookTitle(), getWriter(),outDate   );
		}
		
		return temp;
	}
	
	public boolean isBorrowable() {
		if(this.getState()==ILendable.STATE_BORROWED) {
			return true;
		}
		
		return false;
	}	
	

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}
}
