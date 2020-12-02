package com.lec.condition;

import java.util.Scanner;

public class Q1_if {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);		
		
		System.out.print("첫번째 수는 ? : ");
		int num1 =  scanner.nextInt();
		
		System.out.print("두번째 수는 ? : ");
		int num2 =  scanner.nextInt();
		
		if (num1 < 0) {
			num1 *= -1;
		}
		
		if (num2 < 0) {
			num2 *= -1;
		}
		
		if (num1 == num2) {
			System.out.println("입력하신 값들의 절대값은 같습니다");
		} else if (num1 > num2 ){
			System.out.println("입력하신 값들중 큰 절대값은 "+num1+"입니다"); 
		} else {
			System.out.println("입력하신 값들중 큰 절대값은 "+num2+"입니다");
		}
		
	}

}
