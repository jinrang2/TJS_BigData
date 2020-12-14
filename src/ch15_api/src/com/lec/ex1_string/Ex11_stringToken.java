package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex11_stringToken {

	public static void main(String[] args) {
		String str1 = "정해인 유준상 강동원 김윤석 하정우";
		String str2 = "2020/12/14";
		
		// space, \t, \b 단위로 token 나눔
		StringTokenizer token1 = new StringTokenizer(str1);
		StringTokenizer token2 = new StringTokenizer(str2,"/");
		
		System.out.println("token1의 갯수"+token1.countTokens());
		
		while (token1.hasMoreTokens()) {
			//String temp = (String) token1.nextElement();
			System.out.println(token1.nextToken());
			
		}
		
		while (token2.hasMoreElements()) {
			//String temp = (String) token1.nextElement();
			System.out.println(token2.nextElement());
			
		}
	}

}
