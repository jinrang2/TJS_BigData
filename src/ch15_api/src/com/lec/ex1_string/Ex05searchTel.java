package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05searchTel {

	public static void main(String[] args) {
		String[] tels = {"010-9999-7777",
						"010-8888-8888",
						"010-7777-7777"};
		
		Scanner sc = new Scanner(System.in);
		int idx; // 전화번호가 중복이 없을 때
		
		System.out.print("찾고자 하는 전화번호 뒷자리 : ");
		String searchTel = sc.next();
				
		for (idx=0 ; idx < tels.length ; ++idx ) {
			String temp = tels[idx];
			String post = temp.substring(temp.lastIndexOf("-")+1);
			
			if(searchTel.equals(post)) {
				System.out.println(temp + "를 찾았습니다");
				break;
			} // if
		} // for
			
		if(idx == tels.length) {
			System.out.println("입력하신 전화번호는 없는 번호입니다");
		}
		
		
		
		sc.close();
	} // main
}
