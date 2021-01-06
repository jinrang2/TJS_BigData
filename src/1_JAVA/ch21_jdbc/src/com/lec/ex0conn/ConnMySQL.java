package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.lec.db.DBInfo;

public class ConnMySQL {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			// 1. 드라이버 로드
			Class.forName(DBInfo.MYSQL_DRIVER);
			System.out.println("드라이버 로드 성공");
			// 2. DB 연결 객체 생성
			conn = DriverManager.getConnection(DBInfo.MYSQL_URL,DBInfo.MYSQL_ID,DBInfo.MYSQL_PWD);
			System.out.println("MYSQL 연결 성공");
			//conn.commit();
			//SQLException
		} catch (ClassNotFoundException e) {			
			System.out.println(e.getMessage()+ " : 드라이버 오류");
		} catch (SQLException e) {			
			System.out.println(e.getMessage()+ " : conn 객체 생성 못 함");
		} finally {
			try {
				if (conn != null)	conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage()+ " : 닫기 오류");
			}
		}
	}
}
