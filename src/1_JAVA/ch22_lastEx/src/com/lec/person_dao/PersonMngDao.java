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
			System.out.print("1:�Է� | 2:������ ��� | 3:��ü��� | �׿�:���� ");
			fn = sc.next();
			
			switch(fn) {
			case "1":
				System.out.print("�Է��� �̸�?");
				String name = sc.next();
				System.out.print("�Է��� ����?");
				String jname = sc.next();
				System.out.println("���� ���� ?");
				int kor = sc.nextInt();
				System.out.println("���� ���� ?");
				int eng = sc.nextInt();
				System.out.println("���� ���� ?");
				int mat = sc.nextInt();
				
				PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson);
				
				System.out.println(result==PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
				
				break;
				
			case "2":
				System.out.print("��ȸ�� �������� (��� | ���� ) ? : ");
				jname = sc.next();
				persons = dao.selectJname(jname);
				
				if(persons.size() != 0) {
					DBConsolePrint dbcp = new DBConsolePrint();
					
					dbcp.add(1, "���");	dbcp.add(2, "�̸�");	dbcp.add(3, "����");
					dbcp.add(4, "����");	dbcp.add(5, "����");	dbcp.add(6, "����");
					dbcp.add(7, "����");
					
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
					System.out.println(jname + "������ ����� �����ϴ�.");
				}				
				
				break;
			
			case "3":
				persons = dao.selectAll();
				
				if(persons.size() != 0) {
					DBConsolePrint dbcp = new DBConsolePrint();
					
					dbcp.add(1, "���");	dbcp.add(2, "�̸�");	dbcp.add(3, "����");
					dbcp.add(4, "����");	dbcp.add(5, "����");	dbcp.add(6, "����");
					dbcp.add(7, "����");
					
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
					System.out.println("����� �����ϴ�.");
				}
				
				break;
			
			}
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("Bye");
	}
}
