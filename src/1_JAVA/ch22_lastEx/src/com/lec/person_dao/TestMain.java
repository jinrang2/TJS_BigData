package com.lec.person_dao;

import java.util.ArrayList;

import com.lec.att.DBConsolePrint;

public class TestMain {
	public static void main(String[] args) {
		//PersonDto dto = new PersonDto("ȫ�浿","���",99,99,99);
		PersonDao dao = PersonDao.getInstance();
		
		/*int result = dao.insertPerson(dto);
		
		System.out.println(result==PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");*/
		
		System.out.println("-----------------2�� �׽�Ʈ--------------");
		
		ArrayList<PersonDto> dtos = dao.selectJname("���");
		
		if(dtos.size() == 0 ) {
			System.out.println("��찡 �����ϴ�");
		} else {
			
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "���");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "����");
			dbcp.add(4, "����");
			dbcp.add(5, "����");
			dbcp.add(6, "����");
			dbcp.add(7, "����");
			
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
		
		System.out.println("-----------------3�� �׽�Ʈ--------------");
		
		dtos = dao.selectAll();
		
		if(dtos.size() == 0 ) {
			System.out.println("��찡 �����ϴ�");
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1, "���");
			dbcp.add(2, "�̸�");
			dbcp.add(3, "����");
			dbcp.add(4, "����");
			dbcp.add(5, "����");
			dbcp.add(6, "����");
			dbcp.add(7, "����");
			
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
