package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lec.db.DBInfo;;

public class ConnOracle {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			// 1. ����̹� �ε�
			Class.forName(DBInfo.ORACLE_DRIVER);
			// 2. DB ���� ��ü ����
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			System.out.println("DB ���� ����");
			//conn.commit();
			//SQLException
		} catch (ClassNotFoundException e) {			
			System.out.println(e.getMessage()+ " : ����̹� ����");
		} catch (SQLException e) {			
			System.out.println(e.getMessage()+ " : conn ��ü ���� �� ��");
		} finally {
				try {
					if (conn != null)	conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage()+ " : �ݱ� ����");
				}
		}
	}
}
