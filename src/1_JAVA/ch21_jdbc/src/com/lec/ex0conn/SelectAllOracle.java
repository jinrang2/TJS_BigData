package com.lec.ex0conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.lec.db.DBInfo;

public class SelectAllOracle {
	public static void main(String[] args) {
		Connection conn = null;		// DB����
		Statement stmt = null;		// SQL���� ��ü ����
		ResultSet rs = null;		// SELECT�� ��� �޴� ��ü ����
		String sql = "SELECT EMPNO, ENAME, RPAD(JOB,8,' ') AS JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP";

		try {
			// 1. ����̹� �ε�
			Class.forName(DBInfo.ORACLE_DRIVER);
			System.out.println("ORACLE DRIVER ���� ����");
			// 2. DB ���� ��ü ����
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			System.out.println("ORACLE ���� ����");
			// 3. SQL ���� ��ü ����
			stmt = conn.createStatement();
			// 4. SQL���� 5.����� �ޱ� 
			rs =  stmt.executeQuery(sql);
			
			System.out.printf("���\t�̸�\t��å\t\t�����\t�Ի���\t�޿�\t�󿩱�\t�μ���ȣ\n");
			
			// 6.��� �޾� ���ϴ� ���� ���� - rs�� �ִ� ������ �ֿܼ� ���
			while(rs.next()) {
				int empno			= rs.getInt("empno");
				String ename		= rs.getString("ename");
				String job			= rs.getString("job");
				int mgr				= rs.getInt("mgr");
				Timestamp hiredate	= rs.getTimestamp("hiredate");
				int sal				= rs.getInt("sal");
				int comm			= rs.getInt("comm");
				int deptno			= rs.getInt("deptno");
				System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n"
						,empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {			
			System.out.println(e.getMessage()+ " : ����̹� ����");
		} catch (SQLException e) {			
			System.out.println(e.getMessage()+ " : conn ��ü ���� �� ��");
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
