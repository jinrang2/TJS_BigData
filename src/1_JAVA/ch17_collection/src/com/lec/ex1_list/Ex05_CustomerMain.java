package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex05_CustomerMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		String answer, name, tel, address ;
		
		
		do {
			System.out.println("회원 가입 진행 하시겠습니까(Y/N)? ");
			answer = sc.nextLine();		// y:진행 n: 중단 other:다시묻기
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.print("가입하실 회원님 이름은 ?");
				name = sc.nextLine();
				
				System.out.print("가입하실 전화번호는 ?");
				tel = sc.nextLine();

				System.out.print("가입하실 회원님 주소는 ?");
				address = sc.nextLine();
				
				customers.add(new Customer(name, tel, address));
				
			} else if (answer.equalsIgnoreCase("n")) {
				break;
			}
			
		}while(true);
		
		for (Customer c : customers) {
			System.out.println(c);
		}
			
		System.out.println("bye");		
	}
}
