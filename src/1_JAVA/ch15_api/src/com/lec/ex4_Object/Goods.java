package com.lec.ex4_Object;

public class Goods {
	private String code;
	private String name;
	private int price;
	private int stockNum;
	
	public Goods(String code, String name, int price, int stockNum) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.stockNum = stockNum;
	}
	
	@Override
	public String toString() {
		return String.format("코드:%s  품명:%-10s\t가격:%d\t재고:%d",code,name,price,stockNum);
	}
}
