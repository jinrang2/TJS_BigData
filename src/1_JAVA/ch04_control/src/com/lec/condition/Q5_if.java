package com.lec.condition;

import java.util.Scanner;

public class Q5_if {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� �Է��ϼ��� :");
		int month = scanner.nextInt();
		int temp =  (int)((month%12)/3);
				
		switch( temp ) {
			case 0:
				System.out.print("�ܿ�");	break;
			case 1:
				System.out.print("��");		break;
			case 2:
				System.out.print("����");	break;
			case 3:
				System.out.print("����");	break;
		}
	}
}
