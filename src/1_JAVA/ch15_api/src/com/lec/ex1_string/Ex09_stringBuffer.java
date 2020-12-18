package com.lec.ex1_string;

public class Ex09_stringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuilder strBu = new StringBuilder("abc");
		
		System.out.println("현 strBu의 해쉬코드 :  "+strBu.hashCode());
		System.out.println("1. "+strBu);
		
		
		strBu.append("def");		System.out.println("2. "+strBu + "가용크기 : "+strBu.capacity());
		strBu.insert(3, "AAA");		System.out.println("3. "+strBu + "가용크기 : "+strBu.capacity());		
		strBu.delete(3, 6);			System.out.println("4. "+strBu + "가용크기 : "+strBu.capacity());
		
		int capacitySize = strBu.capacity();
		System.out.println("가용크기 : "+capacitySize);
		System.out.println("현 strBu의 해쉬코드 :  "+strBu.hashCode());
		
		strBu.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("2. "+strBu + "가용크기 : "+strBu.capacity());
		System.out.println("현 strBu의 해쉬코드 :  "+strBu.hashCode());
		
		//strBu.ensureCapacity(1200000000);
		strBu.ensureCapacity(1200);
		System.out.println("현 strBu의 해쉬코드 :  "+strBu.hashCode());
	}
}
