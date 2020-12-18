package com.lec.ex09lib;

public class BookLib extends BookInfo implements ILendable  {
	
	private String borrower;
	private String checkOutDate;
	private byte   state;
	
	public BookLib() {}
	
	public BookLib(String bookno, String bookTitle, String writer) {
		
		super(bookno, bookTitle, writer);
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
		
		System.out.printf("\"%s\" 도서가 대출되었습니다\n", getBookTitle()  );
	}

	@Override
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("대출중인 도서가 아닙니다. 어디서 났어!?");
			return;
		} 
						
		System.out.printf("\"%s\" 도서가 반납 처리 되었습니다\n", getBookTitle()  );
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.printf("책이름 : %s\t\t저자 : %s\t- 대출가능\n",getBookTitle(), getWriter() );
		} else if (state == STATE_BORROWED) {
			System.out.printf("책이름 : %s\t\t저자 : %s\t- 대출중\n", getBookTitle(), getWriter()  );
		} else {
			System.out.printf("책이름 : %s\t\t저자 : %s\t - 유령상태\n",getBookTitle(), getWriter()  );
		}
	}
	
	public boolean isBorrowable() {
		if(this.getState()==ILendable.STATE_BORROWED) {
			return true;
		}
		
		return false;
	}	
	
	public byte getState() {
		return state;
	}
}
