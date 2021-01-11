package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

import com.lec.att.DBConsolePrint;

public class PersonMngDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> persons;
		
		do {
			System.out.print("1:입력 | 2:직업별 출력 | 3:전체출력 | 그외:종료 ");
			fn = sc.next();
			
			switch(fn) {
			case "1":
				System.out.print("입력할 이름?");
				String name = sc.next();
				System.out.print("입력할 직업?");
				String jname = sc.next();
				System.out.println("국어 점수 ?");
				int kor = sc.nextInt();
				System.out.println("영어 점수 ?");
				int eng = sc.nextInt();
				System.out.println("수학 점수 ?");
				int mat = sc.nextInt();
				
				PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				
				System.out.println(result==PersonDao.SUCCESS ? "입력성공" : "입력실패");
				
				break;
				
			case "2":
				System.out.print("조회할 직업명은 (배우 | 가수 ) ? : ");
				jname = sc.next();
				persons = dao.selectJname(jname);
				
				if(persons.size() != 0) {
					DBConsolePrint dbcp = new DBConsolePrint();
					
					dbcp.add(1, "등수");	dbcp.add(2, "이름");	dbcp.add(3, "직업");
					dbcp.add(4, "국어");	dbcp.add(5, "영어");	dbcp.add(6, "수학");
					dbcp.add(7, "총점");
					
					for(PersonDto p:persons) {
						dbcp.add(1, p.getRank());
						dbcp.add(2, p.getName());
						dbcp.add(3, p.getJname());
						dbcp.add(4, p.getKor());
						dbcp.add(5, p.getEng());
						dbcp.add(6, p.getMat());
						dbcp.add(7, p.getSum());
					}				
					
					dbcp.print();
				} else {
					System.out.println(jname + "직업인 사람이 없습니다.");
				}				
				
				break;
			
			case "3":
				persons = dao.selectAll();
				
				if(persons.size() != 0) {
					DBConsolePrint dbcp = new DBConsolePrint();
					
					dbcp.add(1, "등수");	dbcp.add(2, "이름");	dbcp.add(3, "직업");
					dbcp.add(4, "국어");	dbcp.add(5, "영어");	dbcp.add(6, "수학");
					dbcp.add(7, "총점");
					
					for(PersonDto p:persons) {
						dbcp.add(1, p.getRank());
						dbcp.add(2, p.getName());
						dbcp.add(3, p.getJname());
						dbcp.add(4, p.getKor());
						dbcp.add(5, p.getEng());
						dbcp.add(6, p.getMat());
						dbcp.add(7, p.getSum());
					}				
					
					dbcp.print();
				} else {
					System.out.println("사람이 없습니다.");
				}
				
				break;
			
			}
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("Bye");
	}
}
