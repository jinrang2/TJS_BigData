package com.lec.mart;

import java.util.ArrayList;
import java.util.Collections;

import com.lec.att.DBConsolePrint;

public class CustomerTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		int result=0;
		
		//customers = dao.selectById("1");
		//customers = dao.selectByTel("7777");
		//customers = dao.selectByName("박길동");
		//customers = dao.selectByLevelName("GOLD");
		//customers = dao.selectByAll();
		//result  = dao.buyPoint("500", "1");
		//result  = dao.buyCache("1000000", "1");
		//result  = dao.joinCustomer("010-1111-1111", "최길동");
		//result  = dao.deleteCustomer("4");
		
		System.out.println(result);
		
				
		if (customers.isEmpty()) {
			//System.out.println("없당");
			
		} else {
			DBConsolePrint dbcp = new DBConsolePrint();

			dbcp.add(1, "ID");
			dbcp.add(2, "전화");
			dbcp.add(3, "이름");
			dbcp.add(4, "포인트");
			dbcp.add(5, "구매누적액");
			dbcp.add(6, "고객레벨");
			dbcp.add(7, "다음레벨");		

			for (CustomerDto s: customers) {
				dbcp.add(1, s.getCid());
				dbcp.add(2, s.getcTel());
				dbcp.add(3, s.getcName());
				dbcp.add(4, s.getcPoint());
				dbcp.add(5, s.getcAmount());
				dbcp.add(6, s.getLevelName());
				dbcp.add(7, s.getNext());
				
				//System.out.println(s);
			}
			
			dbcp.print();
		}
		
	}
}
