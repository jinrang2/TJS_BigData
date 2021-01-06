package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBInfo;

public class SelectWhereDeptno {
	public static void main(String[] args) {
		Connection conn = null;		// DB접속
		Statement stmt = null;		// SQL전송 객체 변수
		ResultSet rs = null;		// SELECT문 결과 받는 객체 변수
		
		System.out.println("검색할 부서 번호를 입력하세요? : ");
		Scanner sc = new Scanner(System.in);
		
		int deptno = sc.nextInt();
		
		String sql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;


		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			System.out.println("ORACLE DRIVER 연결 성공");
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String dname	=	 rs.getString("dname");
				String loc 		=	 rs.getString("loc");
				System.out.println(deptno+"번 부서의 정보는 다음과 같습니다");
				System.out.println("부서명 : " + dname);
				System.out.println("위  치 : " + loc);
				
			} else {
				System.out.println("해당 부서가 없습니다");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
