package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBConsolePrint;
import com.lec.db.DBInfo;

public class UpdateDept2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt 	= null;
		ResultSet rs = null;
		
		
		String sql = "";
		
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();

			sql = "SELECT DEPTNO, RPAD(DNAME,10,' ') DNAME, LOC FROM DEPT";

			rs = stmt.executeQuery(sql);
			
			
			
			DBConsolePrint dbcp = new DBConsolePrint();
			System.out.println(dbcp);
			
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
			
			Scanner sc = new Scanner(System.in);
			System.out.print("변경할 부서 번호는 ?");
			int deptno = sc.nextInt();
			System.out.print("변경될 부서 이름은 ?");
			String dname = sc.next();			
			sc.nextLine();
			System.out.print("변경될 부서 위치는 ?");
			String loc = sc.nextLine();
			
			
			sql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s'\r\n" + 
					"WHERE DEPTNO=%d", dname, loc, deptno);
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "부서변경성공" : "부서변경실패");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null)		stmt.close();
				if(conn != null)		conn.close();							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
