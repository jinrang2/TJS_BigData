package com.lec.person_dao;

import java.util.ArrayList;

import com.lec.att.DBConsolePrint;

public class TestMain {
	public static void main(String[] args) {
		//PersonDto dto = new PersonDto("홍길동","배우",99,99,99);
		PersonDao dao = PersonDao.getInstance();
		
		/*int result = dao.insertPerson(dto);
		
		System.out.println(result==PersonDao.SUCCESS ? "입력성공" : "입력실패");*/
		
		System.out.println("-----------------2번 테스트--------------");
		
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		
		if(dtos.size() == 0 ) {
			System.out.println("배우가 없습니다");
		} else {
			
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "등수");
			dbcp.add(2, "이름");
			dbcp.add(3, "직업");
			dbcp.add(4, "국어");
			dbcp.add(5, "영어");
			dbcp.add(6, "수학");
			dbcp.add(7, "총점");
			
			for(PersonDto d:dtos) {
				dbcp.add(1, d.getRank());
				dbcp.add(2, d.getName());
				dbcp.add(3, d.getJname());
				dbcp.add(4, d.getKor());
				dbcp.add(5, d.getEng());
				dbcp.add(6, d.getMat());
				dbcp.add(7, d.getSum());
			}				
			
			dbcp.print();
		}
		
		System.out.println("-----------------3번 테스트--------------");
		
		dtos = dao.selectAll();
		
		if(dtos.size() == 0 ) {
			System.out.println("배우가 없습니다");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "등수");
			dbcp.add(2, "이름");
			dbcp.add(3, "직업");
			dbcp.add(4, "국어");
			dbcp.add(5, "영어");
			dbcp.add(6, "수학");
			dbcp.add(7, "총점");
			
			for(PersonDto d:dtos) {
				dbcp.add(1, d.getRank());
				dbcp.add(2, d.getName());
				dbcp.add(3, d.getJname());
				dbcp.add(4, d.getKor());
				dbcp.add(5, d.getEng());
				dbcp.add(6, d.getMat());
				dbcp.add(7, d.getSum());
			}				
			
			dbcp.print();				
		}
	}
}
