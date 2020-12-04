package com.lec.ex6_product;

public class Product {
	private int serialNo;
	public static int count = 100;
	
	public Product() {
		serialNo = ++count;
	}
	
	public void infoString() {
		System.out.printf("serialNo = %d\t공유변수 count = %d\n",serialNo, count);
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
