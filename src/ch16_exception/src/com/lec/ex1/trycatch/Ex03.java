package com.lec.ex1.trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i,j=1;
		
		do {
			try {
				System.out.println("첫번째 수는?");
				i = sc.nextInt();
				break;
			} catch(InputMismatchException e){
				System.out.println(e.toString());
				//e.printStackTrace();
				sc.nextLine();
			}
			
		} while (true);
		
		
		System.out.println("두번째 수는?");
		
		
		try {
			j = sc.nextInt();		
			System.out.println("i = "+i+" j = "+j);
			System.out.println("i * j = " + (i*j) );
			System.out.println("i / j = " + (i/j) );
		} catch (InputMismatchException e) {
			System.out.println(e.toString());
			//System.out.println("두번째 수를 잘못 입력하셔서 1로 초기화 함");
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
			//System.out.println(e.toString()+" 0으로 나누는것은 패스");			
		} catch (Exception e) {
			//e.getStackTrace();
			//System.out.println(e.toString()+" 뭔 에러일까"+ "");
			//e.printStackTrace();
		}
						
		System.out.println("i + j = " + (i+j) );
		System.out.println("i - j = " + (i-j) );
		System.out.println("DONE");
		sc.close();

	}
	

}
