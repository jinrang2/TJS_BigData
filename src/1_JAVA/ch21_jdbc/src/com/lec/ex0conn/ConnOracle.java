package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lec.db.DBInfo;;

public class ConnOracle {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DBInfo.ORACLE_DRIVER);
			// 2. DB 연결 객체 생성
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			System.out.println("DB 연결 성공");
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
