package com.lec.loop;

import java.util.Scanner;

public class Ex10dowhile_randomNum {
	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		int num;
		
		int lotto = (int)(Math.random()*45)+1;
		
		do {
			System.out.print("�ζ� ��ȣ�� �Է��ϼ���? : ");
			num =  scanner.nextInt();
			//System.out.println(lotto);
			
			if(num > lotto) {
				System.out.printf("%d ���� ���� ���� �����ϼ���\n",num);
			} else if (num < lotto) {
				System.out.printf("%d ���� ū ���� �����ϼ���\n",num);
			}
			
			
		} while (num != lotto);
		
				
		System.out.println("���� �̽��ϴ�");
	}
}
