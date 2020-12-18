package com.lec.ex;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arithmetic ar =  new Arithmetic();
		
		System.out.print("숫자를 입력하세요 : ");
		int su = sc.nextInt();
		System.out.println("절대값은"+Arithmetic.abs(su));
		
		int sum = ar.sum(10,51);
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		System.out.println("======================================");
		sum = ar.sum(70);
		System.out.println("합은"+sum);
		System.out.println(ar.evenOdd(sum));
		
		sc.close();
	}
}
