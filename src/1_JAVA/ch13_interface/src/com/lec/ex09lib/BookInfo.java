package com.lec.ex09lib;

public class BookInfo {
	private String bookno;
	private String bookTitle;
	private String writer;

	public BookInfo() {
	}

	public BookInfo(String bookno, String bookTitle, String writer) {
		this.bookno = bookno;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	
	
}