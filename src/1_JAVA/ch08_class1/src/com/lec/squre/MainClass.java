package com.lec.squre;

public class MainClass {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		box.calNsetVolume();
		rect.calNsetVolume();
		
		System.out.println("�ڽ� ���� : " + box.getVolume() + " " + box.getUnit());
		System.out.println("rect ���� : " + rect.getVolume() + " " + rect.getUnit());
		
	}
}
