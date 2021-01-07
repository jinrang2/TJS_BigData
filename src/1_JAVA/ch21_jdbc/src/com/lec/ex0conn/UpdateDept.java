package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.lec.db.DBConsolePrint;
import com.lec.db.DBInfo;

public class UpdateDept {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt 	= null;
		ResultSet rs = null;
		
		
		String sql = "";
		
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();

			sql = "SELECT DEPTNO, RPAD(DNAME,8,' '), LOC FROM DEPT";

			rs = stmt.executeQuery(sql);
			
			DBConsolePrint dbcp = new DBConsolePrint();
			
			dbcp.add(1,"DEPTNO");
			dbcp.add(2,"�μ���");
			dbcp.add(3,"�μ�����");	
			
			if(rs.next()) {
				do {
					int deptno			= rs.getInt(1);
					String dname		= rs.getString(2);
					String loc			= rs.getString(3);
					
					dbcp.add(1,String.format("%d", rs.getInt(1)));
					dbcp.add(2,rs.getString(2));
					dbcp.add(3,rs.getString(3));
				} while (rs.next());
				
				dbcp.print();
				
			} else {
				System.out.println("�μ��� ����� �����ϴ�");
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.print("������ �μ� ��ȣ�� ?");
			int deptno = sc.nextInt();
			System.out.print("����� �μ� �̸��� ?");
			String dname = sc.next();			
			sc.nextLine();
			System.out.print("����� �μ� ��ġ�� ?");
			String loc = sc.nextLine();
			
			
			sql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s'\r\n" + 
					"WHERE DEPTNO=%d", dname, loc, deptno);
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "�μ����漺��" : "�μ��������");
			
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
