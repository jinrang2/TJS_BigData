package com.lec.ex;

public class Quiz3 {
	public static void main(String[] args) {
		int money = 2680;
		int remainMoney = money;
		int temp; 
		
				
		int[] coinUnit = {500, 100, 50, 10};
		
		for(int i : coinUnit) {
			
			temp = remainMoney / i;
			remainMoney = remainMoney - (temp * i);
			
			System.out.printf("%d��¥�� %d�� ",i,temp);
			System.out.println("������:"+remainMoney);
		}
		
	}
}
