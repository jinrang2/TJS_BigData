package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBInfo;

public class SelectWhereDname3 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs	= null;
		
		String sql = "SELECT DEPTNO, RPAD(DNAME,10,' ') DNAME, LOC FROM DEPT";
		
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("DEPTNO\tDNAME\t\tLOC");
			
			if(rs.next()) {
				do {
						int deptno	 = rs.getInt("DEPTNO");
						String dname = rs.getString("DNAME");
						String loc	 = rs.getString("LOC");
						System.out.printf("%d\t%s\t%s\n",deptno, dname, loc);
				} while (rs.next());
			} else {
				System.out.println("부서가 없습니다");
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.print("\n부서명을 입력해주세요.");
			
			
			String dnameLike = sc.nextLine();
			
			
			
			
			sql = "SELECT DNAME, EMPNO, ENAME, SAL, GRADE\r\n" + 
					"FROM EMP E, SALGRADE S, DEPT D\r\n" + 
					"WHERE E.DEPTNO = D.DEPTNO\r\n" + 
					"  AND E.SAL BETWEEN LOSAL AND HISAL\r\n" + 
					"  AND DNAME LIKE '%" + dnameLike + "%'";
			
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("부서명\n사번\t이름\t급여\t등급");
			
			if(rs.next()) {
				do {
						String dname = rs.getString("DNAME");
						int empno	 = rs.getInt("EMPNO");
						String ename = rs.getString("ENAME");
						String sal	 = rs.getString("SAL");
						String grade	 = rs.getString("GRADE");
						System.out.printf("%s\t%d\t%s\t%s\t%s\n",dname, empno, ename, sal,grade);
				} while (rs.next());
			} else {
				System.out.println(dnameLike + "이 들어간 부서에 속한 사원이 없습니다");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)			rs.close();
				if (stmt != null)		stmt.close();
				if (conn != null)		conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		

	}	
}
