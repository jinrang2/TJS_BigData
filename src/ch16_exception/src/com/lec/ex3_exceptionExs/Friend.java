package com.lec.ex3_exceptionExs;

public class Friend {
	private String name;
	private String tel;
	
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		String Post = tel.substring(tel.lastIndexOf("-")+1);
		return "Friend [name=" + name + ", tel=" + tel + "]";
	}
	
	
}
