package com.lec.ex4_lib_exception;

public enum ErrType {
	ERR_SUCCESS("성공"),
	ERR_WRONG_MENU_INPUT("잘못된 입력입니다. 메뉴외의 입력시 프로그램이 종료됩니다"),
	ERR_WRONG_BOOK_NAME("책은 저희 도서관에 없습니다."),
	ERR_STATE_BORROW("대출중인 도서입니다"),
	ERR_STATE_ISNOT_BORROW("대출중인 도서가 아닙니다.");
	
	private String errMsg;
	
	private ErrType(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
}