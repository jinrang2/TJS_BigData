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
		Connection conn = null;		// DB����
		Statement stmt = null;		// SQL���� ��ü ����
		ResultSet rs = null;		// SELECT�� ��� �޴� ��ü ����
		
		Scanner sc = new Scanner(System.in);
		String sql = "";

		try {
			Class.forName(DBInfo.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL, DBInfo.ORACLE_ID, DBInfo.ORACLE_PWD);
			stmt = conn.createStatement();

			sql = "SELECT DEPTNO, RPAD(DNAME,8,' '), LOC FROM DEPT";

			rs = stmt.executeQuery(sql);
			
			System.out.println("�μ���ȣ �μ���\t\t�μ�����");
			
			if(rs.next()) {
				do {
					int deptno			= rs.getInt(1);
					String dname		= rs.getString(2);
					String loc			= rs.getString(3);						
					System.out.printf("%d\t %s\t %s\t\n"
							,deptno, dname, loc);
				} while (rs.next());
			} else {
				System.out.println("�μ��� ����� �����ϴ�");
			}

			System.out.print("\n�˻��� �μ����� �Է��ϼ���? : ");
			String dname = sc.nextLine();
			sql = "SELECT * FROM DEPT WHERE DNAME='"+dname+"'";
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				int   deptno	=	 rs.getInt("deptno");
				String loc 		=	 rs.getString("loc");
				System.out.println(dname+" �μ��� ������ ������ �����ϴ�");
				System.out.println("�μ���ȣ : " + deptno);
				System.out.println("��  ġ : " + loc);

			} else {
				System.out.println("�ش� �μ��� �������� �����ϴ�");
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
