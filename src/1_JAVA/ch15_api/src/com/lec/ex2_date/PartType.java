package com.lec.ex2_date;

public enum PartType {
	COMPUTER("컴퓨터"),
	PLANNING("기획"), 
	DESIGN("디자인"), 
	ACCOUNTING("세무"), 
	HUMANRESOURCE("인사");
	
	private String name;
	
	private PartType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

