package com.lec.ex09lib;

public class CDInfo {
	private String cdNo;
	private String cdTitle;
	private String bookNo;

	public CDInfo() {
	}

	public CDInfo(String bookno, String bookTitle, String writer) {
		this.cdNo = bookno;
		this.cdTitle = bookTitle;
		this.bookNo = writer;
	}

	/**
	 * @return the cdTitle
	 */
	public String getCdTitle() {
		return cdTitle;
	}

	/**
	 * @return the cdNo
	 */
	public String getCdNo() {
		return cdNo;
	}
	
	

	 
}