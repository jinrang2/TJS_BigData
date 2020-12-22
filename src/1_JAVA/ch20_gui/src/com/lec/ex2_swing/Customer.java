package com.lec.ex2_swing;

public class Customer {
	private String name;
	private String tel;
	private int point;
	
	
	public Customer(String name, String tel) {
		this(name, tel, 1000);
	}

	public Customer(String name, String tel, int point) {
		this.name = name;
		this.tel = tel;
		this.point = point;
	}

	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + point;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public int getPoint() {
		return point;
	}
	
	
	
}
