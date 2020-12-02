package com.lec.condition;

import java.util.Scanner;

public class Q5_if {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 :");
		int month = scanner.nextInt();
		int temp =  (int)((month%12)/3);
				
		switch( temp ) {
			case 0:
				System.out.print("겨울");	break;
			case 1:
				System.out.print("봄");		break;
			case 2:
				System.out.print("여름");	break;
			case 3:
				System.out.print("가을");	break;
		}
	}
}
