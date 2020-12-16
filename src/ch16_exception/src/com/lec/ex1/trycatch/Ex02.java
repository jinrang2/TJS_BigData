package com.lec.ex1.trycatch;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i,j;
		
		System.out.print("첫번째 수는?");
		i = sc.nextInt();
		System.out.print("두번째 수는?");
		j = sc.nextInt();
		
		System.out.println("i = "+i+" j = "+j);
		
		System.out.println("i * j = " + (i*j) );
		try {
			System.out.println("i / j = " + (i/j) );
		} catch(Exception e) {
			//System.out.println("0으로 나누면 패스");
			System.out.println(e.getMessage());		//문제가 발생할 경우 처리하는 부분
			//e.printStackTrace();

		}
		System.out.println("i + j = " + (i+j) );
		System.out.println("i - j = " + (i-j) );
		System.out.println("DONE");
		sc.close();

	}

}
