package com.lec.ex1_string;

import java.util.Scanner;

// I:체크인(반납되었습니다) o체크아웃(대출되었습니다) 출력
// x 종료
public class Ex04Quiz {

	public static void main(String[] args) {
		String fn;
		Scanner sc = new Scanner(System.in);
		int i = 0;
				
		do {
			System.out.print("I:체크, O:체크아웃, x:Exit? : ");
			fn = sc.next();
			
			if( fn.equalsIgnoreCase("i")) {
				System.out.println("반납되었습니다");
			}
			else if (fn.equalsIgnoreCase("o")) {
				System.out.println("대출되었습니다");
			}
		
		}while( !fn.equalsIgnoreCase("x"));
		
		System.out.println("종료되었습니다");

	}

}
