package com.lec.ex1_string;

public class Ex08 {
	public static void main(String[] args) {
		String str1 = "월드컵";		// String str1 = new String("월드컵");
		String str2 = "월드컵";		// String str1 = new String("월드컵");
		
		//String str1 = new String("월드컵");
		//String str2 = new String("월드컵");
				
		if(str1 == str2) {
			System.out.println("str1 과 str2는 같은 주소(같은 객체)");
		} else {
			System.out.println("str1 과 str2는 다른 주소(다른 객체)");
		}
		
		//str1 = str1.concat(" 2002");
		//str2 = str2.concat(" 2002");
		
		str1 = str1 + "2002";
		//str2 = str2 + "2002";
		
		
		if(str1 == str2) {
			System.out.println("str1 과 str2는 같은 주소(같은 객체)");
		} else {
			System.out.println("str1 과 str2는 다른 주소(다른 객체)");
		}
	}
}
