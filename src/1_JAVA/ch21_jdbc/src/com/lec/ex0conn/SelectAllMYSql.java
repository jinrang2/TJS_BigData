package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lec.db.DBInfo;

public class SelectAllMYSql {
	public static void main(String[] args) {
		Connection conn = null;		// DB접속
		Statement stmt = null;		// SQL전송 객체 변수
		ResultSet rs = null;		// SELECT문 결과 받는 객체 변수
		String sql = "select pno, pname, rpad(job,10,' '), manager, startdate, pay, bonus, dno from personal;";

		try {
			Class.forName(DBInfo.MYSQL_DRIVER);
			System.out.println("MYSQL DRIVER 연결 성공");
			
			conn = DriverManager.getConnection(DBInfo.MYSQL_URL,DBInfo.MYSQL_ID,DBInfo.MYSQL_PWD);
			System.out.println("ORACLE 연결 성공");
			
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql);
			
			System.out.printf("사번\t이름\t직책\t\t상사사번     입사일\t급여\t상여금\t부서번호\n");
			
			// 6.결과 받아 원하는 로직 수행 - rs에 있는 데이터 콘솔에 출력
			if(rs.next()) {
				do {
					int pno				= rs.getInt(1);
					String pname		= rs.getString(2);
					String job			= rs.getString(3);
					int manager			= rs.getInt(4);
					Date startdate		= rs.getDate(5);
					int pay				= rs.getInt(6);
					int bonus			= rs.getInt(7);
					int dno				= rs.getInt(8);
					System.out.printf("%d\t%s\t%s\t%d\t  %TF\t%d\t%d\t%d\n"
							,pno, pname, job, manager, startdate, pay, bonus, dno);
				} while (rs.next());
			} else {
				System.out.println("\t\t\t\t결과물이 없습니다");
			}
			
		} catch (ClassNotFoundException e) {			
			System.out.println(e.getMessage()+ " : 드라이버 오류");
		} catch (SQLException e) {			
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)		rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+ " : 닫기 오류");
			}
		}
	}
}
