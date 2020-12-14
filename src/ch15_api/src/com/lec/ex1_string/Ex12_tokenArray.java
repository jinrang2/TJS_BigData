package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_tokenArray {

	public static void main(String[] args) {
		// str을 tokenizer하여 names 배열로
		String str ="정해인 유준상 강동원 김윤석 하정우";
		String[] names;
		int idx = 0;
		
		StringTokenizer tok1 = new StringTokenizer(str);
		names = new String[tok1.countTokens()];
		
		
		while (tok1.hasMoreTokens()) {
			names[idx++] = tok1.nextToken();
		}

		System.out.println("제대로 배열에 들어갔는지 확인");
		for(String name: names) {
			System.out.println(name);
		}
	}

}
