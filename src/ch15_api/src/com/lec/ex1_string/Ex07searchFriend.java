package com.lec.ex1_string;

import java.util.Scanner;

public class Ex07searchFriend {

	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-14"),
							new Friend("신길동", "010-9999-8888", "08-14"),
							new Friend("마미숙", "010-9999-7777", "01-14")};
		
		// 찾을 친구의 전화번호 뒷자리를 입력한다.
		// friends 배열에서 해당 전홥너호 뒷자리와 같은 친구가 있으면 그 친구를 출력
		// 없으면 없다고 출력한다.
		Scanner sc = new Scanner(System.in);
		int idx = 0 ;
		String tel="";
		
		System.out.print("찾을 친구의 전화번호를 입력하세요. : ");
		tel = sc.next();
		
		for (idx = 0 ; idx < friends.length ; ++idx ) {
			String temp = friends[idx].getTel();
			String telLast = temp.substring(temp.lastIndexOf('-')+1);
			
			if(tel.equals(telLast)) {
				//System.out.println("친구를 찾았음");
				System.out.println(temp);
				break;
			}
		}
		
		if ( idx == friends.length) {
			System.out.println("친구를 못 찾았음");
		}
		
				
		/*for (Friend friend : friends) {
			friend.print();
		}*/
		
		

	}
}
