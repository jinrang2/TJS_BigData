package com.lec.ex3_exceptionExs;

import java.util.Scanner;

public class ExScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요: ");
		String name = sc.next();
		System.out.println("입력한 이름은"+name);
		nickName();
		
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		System.out.println("입력한 이름은"+age);
	}
	
	private static void nickName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("별명을 입력하세요: ");
		String nickName = sc.next();
		System.out.println("별명은 "+nickName);
	}
	
}
