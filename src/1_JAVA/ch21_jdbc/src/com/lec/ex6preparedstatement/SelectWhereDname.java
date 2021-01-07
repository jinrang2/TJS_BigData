package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBInfo;

public class SelectWhereDname {
	public static void main(String[] args) {
		Connection conn = null;		// DB접속
		Statement stmt = null;		// SQL전송 객체 변수
		ResultSet rs = null;		// SELECT문 결과 받는 객체 변수
		
		Scanner sc = new Scanner(System.in);
		String sql = "";

		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();

			sql = "SELECT DEPTNO, RPAD(DNAME,8,' '), LOC FROM DEPT";

			rs = stmt.executeQuery(sql);
			
			System.out.println("부서번호 부서명\t\t부서도시");
			
			if(rs.next()) {
				do {
					int deptno			= rs.getInt(1);
					String dname		= rs.getString(2);
					String loc			= rs.getString(3);						
					System.out.printf("%d\t %s\t %s\t\n"
							,deptno, dname, loc);
				} while (rs.next());
			} else {
				System.out.println("부서에 사람이 없습니다");
			}

			System.out.print("\n검색할 부서명을 입력하세요? : ");
			String dname = sc.nextLine();
			sql = "SELECT * FROM DEPT WHERE DNAME='"+dname+"'";
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				int   deptno	=	 rs.getInt("deptno");
				String loc 		=	 rs.getString("loc");
				System.out.println(dname+" 부서의 정보는 다음과 같습니다");
				System.out.println("부서번호 : " + deptno);
				System.out.println("위  치 : " + loc);

			} else {
				System.out.println("해당 부서가 존재하지 없습니다");
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
