package com.lec.condition;

import java.util.Scanner;

public class Q1_if {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);		
		
		System.out.print("ù��° ���� ? : ");
		int num1 =  scanner.nextInt();
		
		System.out.print("�ι�° ���� ? : ");
		int num2 =  scanner.nextInt();
		
		if (num1 < 0) {
			num1 *= -1;
		}
		
		if (num2 < 0) {
			num2 *= -1;
		}
		
		if (num1 == num2) {
			System.out.println("�Է��Ͻ� ������ ���밪�� �����ϴ�");
		} else if (num1 > num2 ){
			System.out.println("�Է��Ͻ� ������ ū ���밪�� "+num1+"�Դϴ�"); 
		} else {
			System.out.println("�Է��Ͻ� ������ ū ���밪�� "+num2+"�Դϴ�");
		}
		
	}

}
