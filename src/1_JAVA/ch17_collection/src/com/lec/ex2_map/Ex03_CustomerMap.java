package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ex03_CustomerMap {
	public static void main(String[] args) {
		HashMap<String,Customer> cs = new HashMap<String,Customer>();
		Scanner sc = new Scanner(System.in);
		String fn;
		String name,phone,address;
						
		while(true) {
			System.out.println("회원 가입 진행 하시겠습니까(Y/N)? ");
			fn = sc.nextLine().trim();		// y:진행 n: 중단 other:다시묻기
			
			if(fn.equalsIgnoreCase("n")) {
				break;
			}
			
			System.out.print("이름을 입력하세요. : ");
			name = sc.nextLine().trim();
			
			System.out.print("전화번호를 입력하세요. : ");
			phone = sc.nextLine();
				
			System.out.print("주소를 입력하세요. : ");
			address = sc.nextLine();
			
			cs.put(phone, new Customer(name, phone, address));			
		}
		
		Iterator<String> iter = cs.keySet().iterator();
		
		if(cs.size() == 0) {
			System.out.println("가입된 회원이 없습니다.");
		}
		
		
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(cs.get(key));
		}
		
		sc.close();
	}
}
