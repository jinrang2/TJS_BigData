package com.lec.loop;

import java.util.Scanner;

public class Ex09doWhile {
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		int num;
		
		do {
			System.out.print("¦���� �Է� �ϼ��� : ");
			num =  scanner.nextInt();
		} while ( num % 2 == 1);
		
		System.out.print("¦�� �������� Ż��");
		
		scanner.close();
	}
}
