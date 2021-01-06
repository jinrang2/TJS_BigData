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
		Connection conn = null;		// DB����
		Statement stmt = null;		// SQL���� ��ü ����
		ResultSet rs = null;		// SELECT�� ��� �޴� ��ü ����
		String sql = "select pno, pname, rpad(job,10,' '), manager, startdate, pay, bonus, dno from personal;";

		try {
			Class.forName(DBInfo.MYSQL_DRIVER);
			System.out.println("MYSQL DRIVER ���� ����");
			
			conn = DriverManager.getConnection(DBInfo.MYSQL_URL,DBInfo.MYSQL_ID,DBInfo.MYSQL_PWD);
			System.out.println("ORACLE ���� ����");
			
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql);
			
			System.out.printf("���\t�̸�\t��å\t\t�����     �Ի���\t�޿�\t�󿩱�\t�μ���ȣ\n");
			
			// 6.��� �޾� ���ϴ� ���� ���� - rs�� �ִ� ������ �ֿܼ� ���
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
				System.out.println("\t\t\t\t������� �����ϴ�");
			}
			
		} catch (ClassNotFoundException e) {			
			System.out.println(e.getMessage()+ " : ����̹� ����");
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
