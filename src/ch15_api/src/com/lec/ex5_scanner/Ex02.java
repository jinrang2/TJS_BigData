package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		//sc.nextLine();		// 버퍼 지우기
		System.out.print("주소을 입력하세요 : ");
		String address = sc.nextLine();
		System.out.println("입력하신 주소는 " + address);
		
		
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();		// 30 \n
//		System.out.println("입력하신 나이는 " + age);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.println("입력하신 이름은 " + name);
		
		
		System.out.println("=====프로그램 끝======");
	}
}
