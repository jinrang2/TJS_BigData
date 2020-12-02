package com.lec.loop;

import java.util.Scanner;

public class Ex10dowhile_randomNum2 {
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		int num;
		int min=1,max=45;
		int lotto = (int)(Math.random()*45)+1;
		
		do {
			System.out.printf("로또 번호를 입력하세요? (%d~%d): ",min,max);
			//System.out.println(lotto);
			num =  scanner.nextInt();
			
			if(num > lotto) {
				max = num;
			} else if (num < lotto) {
				min = num;
			}
			
			//System.out.printf("%d 보다 작은 수를 도전하세요\n",num);
			
			
		} while (num != lotto);
		
				
		System.out.println("맞추 셨습니다");
	}
}
