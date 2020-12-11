package com.lec.ex09lib;

public class CDLib extends CDInfo implements ILendable  {
	
	private String borrower;
	private String checkOutDate;
	private byte   state;
	
	public CDLib() {}
	
	public CDLib(String cdNo, String cdTitle, String bookNo) {
		
		super(cdNo, cdTitle, bookNo);
		this.borrower = "";
		this.checkOutDate = "";
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state != STATE_NORMAL) {
			System.out.println("대출중인 CD입니다");
			return;
		} 
		
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		
		System.out.printf("\"%s\" CD가 대출되었습니다\n", getCdTitle()  );
	}

	@Override
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("대출중인 CD가 아닙니다. 어디서 났어!?");
			return;
		} 
						
		System.out.printf("\"%s\" CD가 반납 처리 되었습니다\n", getCdTitle()  );
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.printf("CD이름 : %s\t책번호 : %s\t- 대출가능\n",getCdTitle(), getCdNo() );
		} else if (state == STATE_BORROWED) {
			System.out.printf("CD이름 : %s\t책번호 : %s\t- 대출중\n", getCdTitle(), getCdNo() );
		} else {
			System.out.printf("CD이름 : %s\t책번호 : %s\t - 유령상태\n",getCdTitle(), getCdNo() );
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
