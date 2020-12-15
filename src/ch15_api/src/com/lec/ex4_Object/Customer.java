package com.lec.ex4_Object;

import java.security.acl.LastOwnerException;

public class Customer {
	private String tel;
	private String name;
	private int point;
	private int amount;
	
	public Customer(String tel, String name) {
		this.tel = tel;
		this.name = name;
		point = 1000;
	}
	
	@Override
	public String toString() {
		
		/*int begin = tel.indexOf('-')+1;
		int end = tel.indexOf('-',begin);
		String temp = tel;
		
		System.out.println(begin);
		System.out.println(end);
		
		for (int i = begin ; i < end ; ++i) {
			temp.replaceAll("XXXX", replacement)
		}*/
		
		
		return String.format("전화번호:%-15s 이름:%-6s 포인트:%d 누적금액:%d", tel,name, point,amount);
	}
}
