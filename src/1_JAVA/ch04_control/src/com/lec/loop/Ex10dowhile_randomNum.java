package com.lec.loop;

import java.util.Scanner;

public class Ex10dowhile_randomNum {
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		int num;
		
		int lotto = (int)(Math.random()*45)+1;
		
		do {
			System.out.print("로또 번호를 입력하세요? : ");
			num =  scanner.nextInt();
			//System.out.println(lotto);
			
			if(num > lotto) {
				System.out.printf("%d 보다 작은 수를 도전하세요\n",num);
			} else if (num < lotto) {
				System.out.printf("%d 보다 큰 수를 도전하세요\n",num);
			}
			
			
		} while (num != lotto);
		
				
		System.out.println("맞추 셨습니다");
	}
}
