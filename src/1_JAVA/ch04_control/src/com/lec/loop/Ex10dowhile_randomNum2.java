package com.lec.loop;

import java.util.Scanner;

public class Ex10dowhile_randomNum2 {
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		int num;
		int min=1,max=45;
		int lotto = (int)(Math.random()*45)+1;
		
		do {
			System.out.printf("�ζ� ��ȣ�� �Է��ϼ���? (%d~%d): ",min,max);
			//System.out.println(lotto);
			num =  scanner.nextInt();
			
			if(num > lotto) {
				max = num;
			} else if (num < lotto) {
				min = num;
			}
			
			//System.out.printf("%d ���� ���� ���� �����ϼ���\n",num);
			
			
		} while (num != lotto);
		
				
		System.out.println("���� �̽��ϴ�");
	}
}
