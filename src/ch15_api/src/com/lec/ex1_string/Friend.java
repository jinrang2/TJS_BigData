package com.lec.ex1_string;
// 이름, 전화번호, 생일(12-12)	new Friend("홍","8","12-12");
public class Friend {
	private String name;
	private String tel;
	private String birth;
	
	public Friend() {}

	public Friend(String name, String tel, String birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	
	public void print() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		//return super.toString();
		
		return String.format("[이름]:%s [전화]%s [생일]%s",
				  name,		tel,	birth);
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getBirth() {
		return birth;
	}		
}
