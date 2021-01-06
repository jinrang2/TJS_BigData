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
		Connection conn = null;		// DB����
		Statement stmt = null;		// SQL���� ��ü ����
		ResultSet rs = null;		// SELECT�� ��� �޴� ��ü ����
		
		System.out.println("�˻��� �μ� ��ȣ�� �Է��ϼ���? : ");
		Scanner sc = new Scanner(System.in);
		
		int deptno = sc.nextInt();
		
		String sql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;


		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			System.out.println("ORACLE DRIVER ���� ����");
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String dname	=	 rs.getString("dname");
				String loc 		=	 rs.getString("loc");
				System.out.println(deptno+"�� �μ��� ������ ������ �����ϴ�");
				System.out.println("�μ��� : " + dname);
				System.out.println("��  ġ : " + loc);
				
			} else {
				System.out.println("�ش� �μ��� �����ϴ�");
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
				System.out.println(e.getMessage()+ " : �ݱ� ����");
			}
		}
		
		
	}
}
