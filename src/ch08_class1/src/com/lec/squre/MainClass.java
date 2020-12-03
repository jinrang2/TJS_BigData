package com.lec.squre;

public class MainClass {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		box.calNsetVolume();
		rect.calNsetVolume();
		
		System.out.println("박스 부피 : " + box.getVolume() + " " + box.getUnit());
		System.out.println("rect 넓이 : " + rect.getVolume() + " " + rect.getUnit());
		
	}
}
