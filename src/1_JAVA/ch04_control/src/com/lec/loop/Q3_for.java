package com.lec.loop;

import java.util.Scanner;

public class Q3_for {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
				
		System.out.print("�������� ������ ���� �Է��ϼ���? : ");
		int num1 =  scanner.nextInt();
		
		for (int i = 1;  i <= 9 ; ++i) {
			System.out.printf("%d * %d = %2d\n", num1, i, i*num1);
		}
		
	}

}
