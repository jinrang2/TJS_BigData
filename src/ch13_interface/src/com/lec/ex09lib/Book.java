package com.lec.ex09lib;

public class Book implements ILendable {
	private String bookno;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte   state;
	
	public Book() {}
	
	

	public Book(String bookno, String bookTitle, String writer) {
		this.bookno = bookno;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state != STATE_NORMAL) {
			System.out.println("대출중인 도서입니다");
			return;
		} 
		
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		
		System.out.printf("\"%s\" 도서가 대출되었습니다\n", bookTitle  );
	}

	@Override
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("대출중인 도서가 아닙니다. 어디서 났어!?");
			return;
		} 
						
		System.out.printf("\"%s\" 도서가 반납 처리 되었습니다\n", bookTitle  );
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.printf("책이름 : %s  저자 : %s - 대출가능\n",bookTitle, writer );
		} else if (state == STATE_BORROWED) {
			System.out.printf("책이름 : %s  저자 : %s - 대출중\n",bookTitle, writer );
		} else {
			System.out.printf("책이름 : %s  저자 : %s - 유령상태\n",bookTitle, writer );
		}
		
		
		
		
		

	}

}
