package com.lec.ex2_dataInputStreamoutputStream;

public class Product {
	private String	name;
	private int		price;
	private int		ps;
	
	public Product(String name, int price, int ps) {
		this.name = name;
		this.price = price;
		this.ps = ps;
	}
	
//	public Product(Product product) {
//		this.name = new String(product.name);
//		this.price = product.price;
//		this.ps = product.ps;
//	}

	@Override
	public String toString() {
		return name + "\t" + price + "\t" + ps;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getPs() {
		return ps;
	}
	
}
