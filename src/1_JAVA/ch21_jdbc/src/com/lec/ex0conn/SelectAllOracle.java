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
		Connection conn = null;		// DB접속
		Statement stmt = null;		// SQL전송 객체 변수
		ResultSet rs = null;		// SELECT문 결과 받는 객체 변수
		String sql = "SELECT EMPNO, ENAME, RPAD(JOB,8,' ') AS JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP";

		try {
			// 1. 드라이버 로드
			Class.forName(DBInfo.ORACLE_DRIVER);
			System.out.println("ORACLE DRIVER 연결 성공");
			// 2. DB 연결 객체 생성
			conn = DriverManager.getConnection(DBInfo.ORACLE_URL,DBInfo.ORACLE_ID,DBInfo.ORACLE_PWD);
			System.out.println("ORACLE 연결 성공");
			// 3. SQL 전송 객체 생성
			stmt = conn.createStatement();
			// 4. SQL전송 5.결과값 받기 
			rs =  stmt.executeQuery(sql);
			
			System.out.printf("사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여금\t부서번호\n");
			
			// 6.결과 받아 원하는 로직 수행 - rs에 있는 데이터 콘솔에 출력
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
			System.out.println(e.getMessage()+ " : 드라이버 오류");
		} catch (SQLException e) {			
			System.out.println(e.getMessage()+ " : conn 객체 생성 못 함");
		} finally {
				try {
					if (rs != null)		rs.close();
					if (stmt != null)	stmt.close();
					if (conn != null)	conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage()+ " : 닫기 오류");
				}
		}		
	}
}
