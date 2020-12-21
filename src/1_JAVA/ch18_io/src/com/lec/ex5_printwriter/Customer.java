package com.lec.ex5_printwriter;

public class Customer {
	private String name;
	private String phone;
	private String birth;
	private String address;
	
	public Customer(String name, String phone, String birth, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.address = address;
	}


	@Override
	public String toString() {
		return name + "\t" + phone + "\t" + birth  + "\t" + address;
	}
	
	
}