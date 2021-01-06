package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBInfo;

public class InsertDept {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �μ� ��ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.print("�Է��� �μ� �̸��� ?");
		String dname = sc.next();
		
		sc.nextLine();
		System.out.print("�Է��� �μ� ��ġ�� ?");
		String loc = sc.nextLine();
		
		System.out.printf("%d\t%s\t%s\n",deptno, dname, loc);
		
		String sql= String.format("INSERT INTO DEPT VALUES (%d,'%s', '%s')", deptno, dname , loc);
		
				
		
		
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "�μ��Է¼���" : "�μ��Է½���");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)		stmt.close();
				if (conn != null)		conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
