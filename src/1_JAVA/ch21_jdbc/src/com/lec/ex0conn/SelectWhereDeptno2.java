package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

import com.lec.db.DBInfo;

/*
 * 1.�ش� �μ��� �����ϴ� ��� �μ����� ���
 * ����� ������ ��� ����Ʈ ���, �������� ���� ��� ����� ���ٰ� ���
 * 
 * 2. �ش� �μ���ȣ�� �������� ���� ��� : ���� ���� �ʴ� �μ���ȣ ��� ���
 * 
 */
public class SelectWhereDeptno2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt	= null;
		ResultSet rs	= null;
		
		System.out.print("�˻��� �μ� ��ȣ�� �Է��ϼ���? : ");
		
		Scanner sc = new Scanner(System.in); 
		int deptno = sc.nextInt();
		boolean deptyn = false;
		
		String sql = "SELECT DEPTNO, DNAME, LOC FROM DEPT WHERE DEPTNO="+deptno;
		String dname = "";
						
		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,
												DBInfo.ORACLE_ID,
												DBInfo.ORACLE_PWD);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dname	=	 rs.getString("dname");
				String loc 		=	 rs.getString("loc");
				System.out.println(deptno+"�� �μ��� ������ ������ �����ϴ�");
				System.out.println("�μ��� : " + dname);
				System.out.println("��  ġ : " + loc);		
				deptyn = true;
			} else {
				System.out.println("�������� �ʴ� �μ� ��ȣ �Դϴٴ�");
			}
			
			if(deptyn) {

				sql = "SELECT E1.EMPNO, E1.ENAME, E1.JOB, E2.ENAME as mgr " + 
					  "  FROM EMP E1, EMP E2 " + 
					  " WHERE E1.MGR = E2.EMPNO AND E1.DEPTNO="+deptno;

				rs = stmt.executeQuery(sql);

				if(rs.next()) {
					do {
						int empno			= rs.getInt("empno");
						String ename		= rs.getString("ename");
						String job			= rs.getString("job");
						String mgr			= rs.getString("mgr");						
						System.out.printf("%d\t %s\t %s\t %s\n"
								,empno, ename, job, mgr);
					} while (rs.next());
				} else {
					System.out.println(dname + " �μ��� ����� �����ϴ�");
				}
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
	
	public static String strEx1(int deptno) {
		String sql = "";
		
		return sql;
	}
	
	public static String strEx2(int deptno) {
		String sql = "";
		
		return sql;
	}
}
