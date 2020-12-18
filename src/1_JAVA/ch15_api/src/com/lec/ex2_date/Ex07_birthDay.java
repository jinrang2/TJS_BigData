package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.lec.ex1_string.Friend;

public class Ex07_birthDay {

	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("홍길동","010-9999-9999","12-14"),
				new Friend("홍당무","010-8888-8888","01-01"),
				new Friend("신길동","010-1234-1234","12-14")	};
		
		boolean bFind=false;
		int idx=0;
		Date date = new Date();	
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); 
		
		String outString = sdf.format(date);
		
		for(idx = 0 ; idx < friends.length ; ++idx) {
			
			if (friends[idx].getBirth().equals(outString)) {
				bFind=true;
				friends[idx].print();
			}				
		}
		
		if (bFind == false) {
			System.out.println("오늘이 생일인 사람이 없습니다.");
		}
		
		
	}
}
